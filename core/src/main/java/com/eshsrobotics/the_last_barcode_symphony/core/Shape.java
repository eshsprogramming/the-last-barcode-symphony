package com.eshsrobotics.the_last_barcode_symphony.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Shape implements InputProcessor
{
    private ShapeRenderer shape;
    float shapeRed = 0;
    float shapeGreen = 0;
    float shapeBlue = 0;
    int shapeX = 0;
    int shapeY = 0;
    int shapeWidth = 50;
    int shapeHeight = 50;
    
    public void create()
    {
        shape = new ShapeRenderer();
    }
    
    public void render(float delta)
    {
        shape.begin(ShapeType.Filled);
        shape.setColor(shapeRed, shapeGreen, shapeBlue, 1);
        shape.rect(shapeX, shapeY, shapeWidth, shapeHeight);
        shape.rect(300, 0, 25, Gdx.graphics.getHeight());
        shape.end();
        //Controls size with "WASD"
        if(Gdx.input.isKeyPressed(Keys.W))
        {
            shapeHeight = shapeHeight + 3;
        }

        if(Gdx.input.isKeyPressed(Keys.S))
        {
            shapeHeight = shapeHeight - 3;
        }

        if(Gdx.input.isKeyPressed(Keys.A))
        {
            shapeWidth = shapeWidth - 3;
        }

        if(Gdx.input.isKeyPressed(Keys.D))
        {
            shapeWidth = shapeWidth + 3;
        }

        //Controls Location with arrow keys
        if(Gdx.input.isKeyPressed(Keys.DPAD_UP))
        {
            shapeY = shapeY + 3;
        }

        if(Gdx.input.isKeyPressed(Keys.DPAD_DOWN))
        {
            shapeY = shapeY - 3;
        }

        if(Gdx.input.isKeyPressed(Keys.DPAD_LEFT))
        {
            shapeX = shapeX - 3;
        }

        if(Gdx.input.isKeyPressed(Keys.DPAD_RIGHT))
        {
            shapeX = shapeX + 3;
        }

        //Poorly controls color, will be fixed in future. Use numbers 1-3 to control
        if(Gdx.input.isKeyPressed(Keys.NUM_1))
        {
            shapeGreen = shapeGreen + 0.01f;
            float diff = 1 - shapeGreen;

            while(shapeGreen > 1)
            {
                shapeGreen = shapeGreen + diff;
            }
        }

        if(Gdx.input.isKeyPressed(Keys.NUM_2))
        {
            shapeBlue = shapeBlue + 0.01f;
            float diff = 1 - shapeBlue;

            while(shapeBlue > 1)
            {
                shapeBlue = shapeBlue + diff;
            }
        }

        if(Gdx.input.isKeyPressed(Keys.NUM_3))
        {
            shapeRed = shapeRed + 0.01f;
            float diff = 1 - shapeRed;

            while(shapeRed > 1)
            {
                shapeRed = shapeRed + diff;
            }
        }

        if(Gdx.input.isKeyPressed(Keys.NUM_4))
        {
            shapeGreen = shapeGreen - 0.01f;
            float diff = 0 - shapeGreen;

            while(shapeGreen < 0)
            {
                diff = 0 - shapeGreen;
                shapeGreen = shapeGreen + diff;
            }
        }

        if(Gdx.input.isKeyPressed(Keys.NUM_5))
        {
            shapeBlue = shapeBlue - 0.01f;
            float diff = 0 - shapeBlue;

            while(shapeBlue < 0)
            {
                shapeBlue = shapeBlue + diff;
            }
        }

        if(Gdx.input.isKeyPressed(Keys.NUM_6))
        {
            shapeRed = shapeRed - 0.01f;
            float diff = 0 - shapeRed;

            while(shapeRed < 0)
            {
                shapeRed = shapeRed + diff;
            }
        }
    }
    
    @Override
    public boolean keyDown(int keycode) 
    {
        if(keycode == Keys.W)
        {
            shapeHeight += 3;
        }
        return false;
    }
    
    @Override
    public boolean keyUp(int keycode) 
    {
        return false;
    }
    
    @Override
    public boolean keyTyped(char character) 
    {
        return false;
    }
    
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) 
    {
        return false;
    }
    
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) 
    {
        return false;
    }
    
    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) 
    {
        return false;
    }
    
    @Override
    public boolean mouseMoved(int screenX, int screenY) 
    {
        return false;
    }
    
    @Override
    public boolean scrolled(int amount) 
    {
        return false;
    }
}
