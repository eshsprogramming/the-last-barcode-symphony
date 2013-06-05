package com.eshsrobotics.the_last_barcode_symphony.core;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;


public class PauseScreen implements Screen
{
    SpriteBatch spriteBatch = new SpriteBatch();
    Button resumeButton = new Button();
    Button mainMenuButton = new Button();
    Button quitButton = new Button();
    Button restartButton = new Button();
    TheLastBarcodeSymphony game = TheLastBarcodeSymphony.getInstance();

    public void create()
    {
        resumeButton.create(Gdx.graphics.getWidth() / 2 - 45, Gdx.graphics.getHeight() * 7 / 8 - 36, "ResumeButton.png", game.playScreen);
        mainMenuButton.create(Gdx.graphics.getWidth() / 2 - 45, Gdx.graphics.getHeight() * 5 / 8 - 36, "MainMenuButton.png", game.mainMenu);
        quitButton.create(Gdx.graphics.getWidth() / 2 - 45, Gdx.graphics.getHeight() / 8 - 36, "QuitButton.png", game.quitScreen);
        restartButton.create(Gdx.graphics.getWidth() / 2 - 45, Gdx.graphics.getHeight() * 3 / 8 - 36, "RestartButton.png", game.resetScreen);
    }

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        resumeButton.render(spriteBatch);
        mainMenuButton.render(spriteBatch);
        quitButton.render(spriteBatch);
        restartButton.render(spriteBatch);

        TheLastBarcodeSymphony.getInstance().music.pause();
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

    public void resume()
    {
    }

    public void dispose()
    {
    }
}

