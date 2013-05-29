package com.eshsrobotics.the_last_barcode_symphony.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HighscoreScreen implements Screen
{

    private TheLastBarcodeSymphony game;
    private Preferences hSReader = Gdx.app.getPreferences("Highscores");
    private BitmapFont font = new BitmapFont();
    private SpriteBatch sprite = new SpriteBatch();
    private Button backButton = new Button();

    public HighscoreScreen(TheLastBarcodeSymphony game) 
    {
        this.game = game;
        backButton.create((Gdx.graphics.getWidth()/8), (Gdx.graphics.getHeight()/8), "BackButton.png", game.mainMenu, game);
    }

    @Override
    public void render(float delta) 
    {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        
        backButton.render(sprite);
        
        sprite.begin();
        font.setColor(0, 0, 0, 1.0f);
        font.draw(sprite, "Highscores", Gdx.graphics.getWidth()/8, Gdx.graphics.getHeight()*0.875f);
        for(int i = 0; i <= 4; i++)
        {
            font.draw(sprite, Integer.toString(i + 1) + ". " + Integer.toString(hSReader.getInteger(Integer.toString(4-i))), Gdx.graphics.getWidth()/8, Gdx.graphics.getHeight() - 45*i - 125);
        }
        sprite.end();
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
