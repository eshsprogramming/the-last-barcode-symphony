package com.eshsrobotics.the_last_barcode_symphony.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;


public class Button
{
    TheLastBarcodeSymphony tlbs;
    private Texture texture;
    private float shapeX;
    private float shapeY;
    private Screen screen;

    public void create(int x, int y, String texturePath, Screen sendScreen, TheLastBarcodeSymphony theLastBarcodeSymphony)
    {
        texture = new Texture(Gdx.files.internal(texturePath));
        screen = sendScreen;
        tlbs = theLastBarcodeSymphony;
        shapeX = x;
        shapeY = y;
    }

    public void render(SpriteBatch batch)
    {
        Input input = Gdx.input;
        int x = input.getX(),
                y = Gdx.graphics.getHeight() - input.getY();
        batch.begin();
        batch.draw(texture, shapeX, shapeY);
        batch.end();
        if(input.isTouched() && x <= (shapeX + texture.getWidth()) && x >= shapeX && y <= (shapeY + texture.getHeight()) && y >= shapeY)
        {
            tlbs.setTheScreen(screen);
        }
    }

}
