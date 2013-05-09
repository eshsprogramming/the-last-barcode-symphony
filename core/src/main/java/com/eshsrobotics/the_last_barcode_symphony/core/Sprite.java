package com.eshsrobotics.the_last_barcode_symphony.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Sprite 
{
    private SpriteBatch batch;
    private Texture texture;
    int spriteX = 0;
    int spriteY = 0;
    
    public void render(float delta)
    {
        batch = new SpriteBatch();
        texture = new Texture(Gdx.files.internal("Test.png"));
        if(Gdx.input.isTouched() == true)
        {
            spriteX = Gdx.input.getX();
            spriteY = Gdx.graphics.getHeight()-Gdx.input.getY();
        }
        batch.begin();
        batch.draw(texture, spriteX-16, spriteY-16);
        batch.end();
    }
}
