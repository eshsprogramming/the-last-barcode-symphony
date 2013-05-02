package com.eshsrobotics.the_last_barcode_symphony.core;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class TheLastBarcodeSymphony implements ApplicationListener
{
    private SpriteBatch batch;
    private Texture texture;
    private ShapeRenderer shape;

    @Override
    public void create()
    {
        texture = new Texture(Gdx.files.internal("Test.png"));
        batch = new SpriteBatch();
        shape = new ShapeRenderer();
    }

    @Override
    public void dispose()
    {
    }

    @Override
    public void render()
    {
        Gdx.gl.glClearColor(1, 1, 1, 1); //White Screen
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT); // Clear screen

        for(int i = 0; i < 10; i++)
        {
            batch.begin();
            batch.draw(texture, (float)(16 * Math.sin(i) + 16), 16 * i);
            batch.draw(texture, (float) (16*Math.sin(i) + 16), 16*i);
            batch.end();
        }

        shape.begin(ShapeType.Filled);
        shape.setColor(0, 0, 0, 1);
        shape.rect(100, 100, 50, 50);
        shape.end();
    }

    @Override
    public void resize(int width, int height)
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
}
