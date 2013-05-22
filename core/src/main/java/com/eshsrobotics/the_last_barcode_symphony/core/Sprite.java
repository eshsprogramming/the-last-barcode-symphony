package com.eshsrobotics.the_last_barcode_symphony.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Sprite
{
    private SpriteBatch batch;
    private Texture texture;
    int spriteX = 100;
    int spriteY = Gdx.graphics.getHeight()-48;

    public void create()
    {
        batch = new SpriteBatch();
        texture = new Texture(Gdx.files.internal("Test.png"));
    }

    public void render(float delta, int number)
    {
        spriteX = Gdx.graphics.getWidth()-number*48;
        batch.begin();
        batch.draw(texture, spriteX, spriteY);
        batch.end();
    }
}
