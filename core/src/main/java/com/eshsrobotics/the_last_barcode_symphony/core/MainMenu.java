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
    Button highscoresButton;


    public MainMenu(TheLastBarcodeSymphony game)
    {
        this.game = game;
    }

    public void create()
    {
        this.spriteBatch = new SpriteBatch();
        playButton = new Button();
        quitButton = new Button();
        highscoresButton = new Button();
        playButton.create((Gdx.graphics.getWidth()/2)-45, (Gdx.graphics.getHeight()/2)+64, "PlayButton.png",game.playScreen,game);
        highscoresButton.create((Gdx.graphics.getWidth()/2)-45, (Gdx.graphics.getHeight()/2)-36,"HighscoresButton.png",game.highscoreScreen,game);
        quitButton.create((Gdx.graphics.getWidth()/2)-45, (Gdx.graphics.getHeight()/2)-136, "QuitButton.png",game.quitScreen,game);
    }

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        playButton.render(spriteBatch);
        highscoresButton.render(spriteBatch);
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
