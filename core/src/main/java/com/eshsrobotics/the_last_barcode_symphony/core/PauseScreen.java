package com.eshsrobotics.the_last_barcode_symphony.core;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;


public class PauseScreen implements Screen
{
    TheLastBarcodeSymphony game;
    private ShapeRenderer resumeButton = new ShapeRenderer();
    private ShapeRenderer mainMenuButton = new ShapeRenderer();

    public PauseScreen(TheLastBarcodeSymphony game)
    {
        this.game = game;
    }

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(0, 0, 1, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        resumeButton.setColor(0, 1, 0, 1);
        resumeButton.begin(ShapeType.Filled);
        resumeButton.rect(300, 300, 50, 50);
        resumeButton.end();

        mainMenuButton.setColor(1, 0, 0, 1);
        mainMenuButton.begin(ShapeType.Filled);
        mainMenuButton.rect(300, 100, 50, 50);
        mainMenuButton.end();
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

