package com.eshsrobotics.the_last_barcode_symphony.core;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainMenu implements Screen
{
    SpriteBatch spriteBatch;
    Button playButton;
    Button quitButton;
    Button highscoresButton;
    Texture paraBG;
    Texture logo;

    public void create()
    {
        this.spriteBatch = new SpriteBatch();
        paraBG = new Texture(Gdx.files.internal("BGBC.png"));
        logo = new Texture(Gdx.files.internal("UglyLogo.png"));
        playButton = new Button();
        quitButton = new Button();
        highscoresButton = new Button();
        playButton.create((Gdx.graphics.getWidth() / 2) - 45, (Gdx.graphics.getHeight() / 2) - 18, "PlayButton.png", TheLastBarcodeSymphony.getInstance().resetScreen);
        highscoresButton.create((Gdx.graphics.getWidth() / 2) - 45, (Gdx.graphics.getHeight() / 2) - 118, "HighscoresButton.png", TheLastBarcodeSymphony.getInstance().highscoreScreen);
        quitButton.create((Gdx.graphics.getWidth() / 2) - 45, (Gdx.graphics.getHeight() / 2) - 218, "QuitButton.png", TheLastBarcodeSymphony.getInstance().quitScreen);
    }

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        spriteBatch.begin();
        spriteBatch.draw(paraBG, 0, 0);
        spriteBatch.draw(logo, Gdx.graphics.getWidth()/2 - logo.getWidth()/2, Gdx.graphics.getHeight() - logo.getHeight()*9/8);
        spriteBatch.end();
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
