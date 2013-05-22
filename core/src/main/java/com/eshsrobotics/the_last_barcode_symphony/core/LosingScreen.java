package com.eshsrobotics.the_last_barcode_symphony.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LosingScreen implements Screen
{

    private TheLastBarcodeSymphony theLastBarcodeSymphony;
    BitmapFont font;
    SpriteBatch sprite;

    public LosingScreen(TheLastBarcodeSymphony theLastBarcodeSymphony) 
    {
        this.theLastBarcodeSymphony = theLastBarcodeSymphony;
    }
    
    public void create()
    {
        font = new BitmapFont();
        sprite = new SpriteBatch();
    }

    @Override
    public void render(float delta) 
    {
        Gdx.gl.glClearColor(1, 1, 1, 1); //White Screen
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT); // Clear screen
        
        sprite.begin();
        font.draw(sprite, "You Lose!", 30, Gdx.graphics.getHeight() - 30);
        font.setColor(0, 0, 0, 1.0f);
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
