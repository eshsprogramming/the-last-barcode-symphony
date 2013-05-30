package com.eshsrobotics.the_last_barcode_symphony.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

// We don't want anyone extending this so we make
// it final.
public final class Score
{
    // We store a private static instance so we don't need
    // to make everything in the class static. It also comes
    // with a few other advantages that'll be apparent later.
    // To get this static instance, the programmer just needs
    // to call Score.getInstance().
    private static Score instance = new Score();

    BitmapFont font;
    SpriteBatch sprite;
    private double score = 0;
    int roundedScore = 0;
    int screenHeight = Gdx.graphics.getHeight();
    private int width = 0;
    private int height = 0;
    private float speed = 0;
    private boolean state = false;

    // This is private so nobody can create an instance of
    // Score. Rather, they must call Score.getInstance()
    // to get the universal instance.
    private Score()
    {
        font = new BitmapFont();
        sprite = new SpriteBatch();
    }

    public void render(float delta)
    {
        roundedScore = (int)(getScore());
        sprite.begin();
        font.draw(sprite, Integer.toString(roundedScore), 30, screenHeight - 30);
        font.setColor(0, 0, 0, 1.0f);
        sprite.end();
    }

    public double getScore()
    {
        return score;
    }

    public void setScore(double score)
    {
        this.score = score;
    }

    public float getSpeed()
    {
        return speed;
    }

    public void setSpeed(float speed)
    {
        this.speed = speed;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public boolean isState()
    {
        return state;
    }

    public void setState(boolean state)
    {
        this.state = state;
        changeScore();
    }

    public void changeScore()
    {
        if(isState() == true)
        {
            score += (0.1 + ((100 * speed) * Math.pow(0.75, Math.sqrt(width * height) / 10)));
        }

        else
        {
            score -= ((Math.sqrt(width * height) * speed) + ((0.5 / speed) * score));
        }
    }

    // As stated earlier, this method exists so
    // the programmer can call Score.getInstance()
    // to get a static instance.
    public static Score getInstance()
    {
        return instance;
    }
}
