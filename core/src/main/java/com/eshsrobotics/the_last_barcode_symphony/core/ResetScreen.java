package com.eshsrobotics.the_last_barcode_symphony.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;

public class ResetScreen implements Screen
{
    TheLastBarcodeSymphony game = TheLastBarcodeSymphony.getInstance();

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        game.playScreen.reset();
        TheLastBarcodeSymphony.getInstance().setScreen(TheLastBarcodeSymphony.getInstance().playScreen);

        TheLastBarcodeSymphony.getInstance().music.stop();
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
