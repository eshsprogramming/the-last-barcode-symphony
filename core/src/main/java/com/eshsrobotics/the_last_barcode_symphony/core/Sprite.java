package com.eshsrobotics.the_last_barcode_symphony.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Sprite
{
    private SpriteBatch batch;
    private Texture texture;
    int spriteX = 100;
    int spriteY = 100;

    public void create()
    {
        batch = new SpriteBatch();
        texture = new Texture(Gdx.files.internal("Test.png"));
    }

    public void render(float delta)
    {
        Input input = Gdx.input;
        int x = input.getX(),
            y = Gdx.graphics.getHeight() - input.getY();
        int width = texture.getWidth(),
            height = texture.getHeight();
        batch.begin();
        batch.draw(texture, spriteX, spriteY);
        batch.end();

        if(input.isTouched() == true)
        {
            if(x < spriteX + width && x > spriteX)
            {
                if(y < spriteY + height && y > spriteY)
                {
                    spriteX = x - width / 2;
                    spriteY = y - height / 2;
                }
            }
        }
    }
}
