package com.eshsrobotics.the_last_barcode_symphony.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HighscoreScreen implements Screen
{

    private TheLastBarcodeSymphony game = TheLastBarcodeSymphony.getInstance();
    private Preferences hSReader = Gdx.app.getPreferences("Highscores");
    private BitmapFont font = new BitmapFont();
    private SpriteBatch sprite = new SpriteBatch();
    private Button backButton = new Button();
    private Input input = Gdx.input;
    private Texture texture = new Texture(Gdx.files.internal("ResetButton.png"));
    private Highscores highscore = Highscores.getInstance();

    int x = input.getX(),
        y = Gdx.graphics.getHeight() - input.getY(),
        shapeX = (int)(Gdx.graphics.getWidth() * 0.875) - 90,
        shapeY = (int)(Gdx.graphics.getHeight() / 8);

    public void create()
    {
        backButton.create((Gdx.graphics.getWidth() / 8), (Gdx.graphics.getHeight() / 8), "BackButton.png", game.mainMenu);
    }

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        x = input.getX();
        y = Gdx.graphics.getHeight() - input.getY();
        backButton.render(sprite);
        sprite.begin();
        font.setColor(0, 0, 0, 1.0f);
        font.draw(sprite, "Highscores", Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() * 0.875f);

        for(int i = 0; i <= 4; i++)
        {
            font.draw(sprite, Integer.toString(i + 1) + ". " + Integer.toString(hSReader.getInteger(Integer.toString(4 - i))), Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() - 45 * i - 125);
        }

        sprite.draw(texture, shapeX, shapeY);
        sprite.end();

        if(input.isTouched() && x <= (shapeX + texture.getWidth()) && x >= shapeX && y <= (shapeY + texture.getHeight()) && y >= shapeY)
        {
            for(int i = 0; i <= 4; i++)
            {
                hSReader.putInteger(Integer.toString(i), 0);
                hSReader.flush();
                highscore.loadHighscores();
            }
        }
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
