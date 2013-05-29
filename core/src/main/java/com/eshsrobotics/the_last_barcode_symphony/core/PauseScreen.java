package com.eshsrobotics.the_last_barcode_symphony.core;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;


public class PauseScreen implements Screen
{
    TheLastBarcodeSymphony game;
    SpriteBatch spriteBatch;
    Button resumeButton;
    Button mainMenuButton;
    Button quitButton;
    Button restartButton;

    public PauseScreen(TheLastBarcodeSymphony game)
    {
        this.game = game;
    }

    public void create()
    {
        this.spriteBatch = new SpriteBatch();
        resumeButton = new Button();
        mainMenuButton = new Button();
        quitButton = new Button();
        restartButton = new Button();

        resumeButton.create(100,0,"ResumeButton.png",game.playScreen,game);
        mainMenuButton.create(250,0,"MainMenuButton.png",game.mainMenu,game);
        quitButton.create(550,0,"QuitButton.png",game.quitScreen,game);
        restartButton.create(400,0,"RestartButton.png",game.resetScreen,game);
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

