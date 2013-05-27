package com.eshsrobotics.the_last_barcode_symphony.core;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainMenu implements Screen
{
    SpriteBatch spriteBatch;
    TheLastBarcodeSymphony game;
    Button playButton;
    Button quitButton;
    Button creditsButton;


    public MainMenu(TheLastBarcodeSymphony game)
    {
        this.game = game;
    }

    public void create()
    {
        this.spriteBatch = new SpriteBatch();
        playButton = new Button();
        quitButton = new Button();
        creditsButton = new Button();
        playButton.create(0,0,"PlayButton.png",game.playScreen,game);
        quitButton.create(200,0,"QuitButton.png",game.quitScreen,game);
        creditsButton.create(100,0,"CreditsButton.png",game.playScreen,game);
    }

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        playButton.render(spriteBatch);
        creditsButton.render(spriteBatch);
        quitButton.render(spriteBatch);

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
