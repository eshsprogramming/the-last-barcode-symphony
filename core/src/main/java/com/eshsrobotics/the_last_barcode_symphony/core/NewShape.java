package com.eshsrobotics.the_last_barcode_symphony.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class NewShape
{
    private ShapeRenderer shape = new ShapeRenderer();
    private Float shapeRed, shapeGreen, shapeBlue;
    private int shapeHeight;
    private int shapeWidth;
    private float shapeX;
    private float shapeY;
    private float color;
    private boolean touched;
    private float speed = 200;
    private float tempSpeed;
    private int shapeMaxSize = 250;
    private int shapeMinSize = 30;
    private Score score;
    private LifeCounter lifeCount;
    
    
    public void create()//int red, int green, int blue)
    {
        //shapeRed = red;
        //shapeGreen = green;
        //shapeBlue = blue;
        score = Score.getInstance();
        lifeCount = LifeCounter.getInstance();
        reset();
    }

    public void render(float delta)
    {
        Input input = Gdx.input;
        int x = input.getX(),
            y = Gdx.graphics.getHeight() - input.getY();
        
        shape.setColor(shapeRed * color,shapeGreen * color,shapeBlue * color, 1);
        shape.begin(ShapeType.Filled);
        shape.rect(shapeX, shapeY, shapeWidth, shapeHeight);
        shape.end();
        shape.setColor(0, 0, 0, 1);
        shape.begin(ShapeType.Line);
        shape.rect(shapeX, shapeY, shapeWidth, shapeHeight);
        shape.end();

        if(shapeX > Gdx.graphics.getWidth())
        {
            if(touched == false)
            {
                // Watch this...
                score.setSpeed(tempSpeed/100);
                score.setHeight(shapeHeight);
                score.setWidth(shapeWidth);
                score.setState(false);
                lifeCount.setLifeCount(lifeCount.getLifeCount()-1);
            }

            reset();
        }

        else
        {
            shapeX += tempSpeed*delta;

            if(input.isTouched() && x <= (shapeX + shapeWidth) && x >= shapeX && y <= (shapeY + shapeHeight) && y >= shapeY)
            {
                score.setSpeed(tempSpeed/100);
                score.setHeight(shapeHeight);
                score.setWidth(shapeWidth);
                score.setState(true);
                color = 1;
                touched = true;
            }
        }

        if(color > 0)
        {
            color -= 0.005;
        }

        else
        {
            color = 0;
        }
    }

    public void reset()
    {
        shapeHeight = (int)((Math.random() * (shapeMaxSize - shapeMinSize))+shapeMinSize);
        shapeWidth = (int)((Math.random() * (shapeMaxSize - shapeMinSize))+shapeMinSize);
        shapeX = -shapeWidth;
        shapeY = (int)(Math.random() * (Gdx.graphics.getHeight() - shapeHeight));
        color = 0;
        touched = false;
        speed = 175 + (float)(score.getScore()/75);
        tempSpeed = (float)((Math.random() * 100) + (speed - 50));
        shapeRed = (float)(Math.random());
        shapeGreen = (float)(Math.random());
        shapeBlue = (float)(Math.random());
    }
}
