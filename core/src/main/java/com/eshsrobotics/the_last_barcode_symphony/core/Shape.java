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
    int height = Gdx.graphics.getHeight();
    int width = Gdx.graphics.getWidth();
    int shapeX = 0;
    int shapeY = (int) (Math.random()*height);
    int shapeWidth = (int) (Math.random()*250);
    int shapeHeight = (int) (Math.random()*250);
    int shapeXa = 0;
    int shapeYa = (int) (Math.random()*height);
    int shapeWidtha = (int) (Math.random()*250);
    int shapeHeighta = (int) (Math.random()*250);
    int shapeXb = 0;
    int shapeYb = (int) (Math.random()*height);
    int shapeWidthb = (int) (Math.random()*250);
    int shapeHeightb = (int) (Math.random()*250);
    
    public void create()
    {
        shape = new ShapeRenderer();
    }
    
    public void render(float delta)
    {
        shapeX += 2;
        shapeXa += 3;
        shapeXb += 4;
        shape.begin(ShapeType.Filled);
        shape.setColor(shapeRed, shapeGreen, shapeBlue, 1);
        shape.rect(shapeX, shapeY, shapeWidth, shapeHeight);
        shape.rect(shapeXa, shapeYa, shapeWidtha, shapeHeighta);
        shape.rect(shapeXb, shapeYb, shapeWidthb, shapeHeightb);
        shape.end();
        if (shapeX > width)
        {
            shapeX = 0;
            shapeY = (int) (Math.random()*height);
            shapeHeight = (int) (Math.random()*250);
            shapeWidth = (int) (Math.random()*250);
        }
        
        if (shapeXa > width)
        {
            shapeXa = 0;
            shapeYa = (int) (Math.random()*height);
            shapeHeighta = (int) (Math.random()*250);
            shapeWidtha = (int) (Math.random()*250);
        }
        
        if (shapeXb > width)
        {
            shapeXb = 0;
            shapeYb = (int) (Math.random()*height);
            shapeWidthb = (int) (Math.random()*250);
            shapeHeightb = (int) (Math.random()*250);
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
