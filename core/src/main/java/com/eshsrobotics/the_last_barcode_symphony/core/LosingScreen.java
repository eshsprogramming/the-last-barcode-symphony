package com.eshsrobotics.the_last_barcode_symphony.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LosingScreen implements Screen
{
    private BitmapFont font = new BitmapFont();
    private SpriteBatch sprite = new SpriteBatch();
    private Score score = Score.getInstance();
    private Highscores highscore = Highscores.getInstance();
    private String isHighscore = "";
    private Button mainMenu = new Button();
    private Button restart = new Button();

    public void create()
    {
        mainMenu.create(Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 8, "MainMenuButton.png", TheLastBarcodeSymphony.getInstance().mainMenu);
        restart.create(Gdx.graphics.getWidth() * 7 / 8 - 90, Gdx.graphics.getHeight() / 8, "RestartButton.png", TheLastBarcodeSymphony.getInstance().resetScreen);
    }

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(1, 1, 1, 1); //White Screen
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT); // Clear screen

        if(highscore.getIsHighscore() == 4)
        {
            isHighscore = "You got the #1 highscore!";
        }

        else if(highscore.getIsHighscore() < 4 && highscore.getIsHighscore() >= 0)
        {
            isHighscore = "You got a highscore!";
        }

        else
        {
            isHighscore = "You didn't get a highscore.";
        }

        mainMenu.render(sprite);
        restart.render(sprite);
        sprite.begin();
        font.draw(sprite, "You Lose!", Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() * 7 / 8);
        font.draw(sprite, isHighscore, Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() * 6 / 8);
        font.draw(sprite, "Your score was:", Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() * 5 / 8);
        font.draw(sprite, Integer.toString((int)score.getScore()), Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() * 9 / 16);
        font.setColor(0, 0, 0, 1.0f);
        sprite.end();

        TheLastBarcodeSymphony.getInstance().music.stop();
    }

    @Override
    public void resize(int width, int height)
    {
    }

    @Override
    public void show()
    {
    }

    @Override
    public void hide()
    {
    }

    @Override
    public void pause()
    {
    }

    @Override
    public void resume()
    {
    }

    @Override
    public void dispose()
    {
    }

}
