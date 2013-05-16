package com.eshsrobotics.the_last_barcode_symphony.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Shape
{
    private ShapeRenderer shape;
    float shapeGreen = 0;
    float shapeBluea = 0;
    float shapeRedb = 0;
    int height = Gdx.graphics.getHeight();
    int width = Gdx.graphics.getWidth();
    int shapeX = 0;
    int shapeY = (int)(Math.random() * height);
    int shapeWidth = 30 + (int)(Math.random() * 250);
    int shapeHeight = 30 + (int)(Math.random() * 250);
    int shapeXa = 0;
    int shapeYa = (int)(Math.random() * height);
    int shapeWidtha = 30 + (int)(Math.random() * 250);
    int shapeHeighta = 30 + (int)(Math.random() * 250);
    int shapeXb = 0;
    int shapeYb = (int)(Math.random() * height);
    int shapeWidthb = 30 + (int)(Math.random() * 250);
    int shapeHeightb = 30 + (int)(Math.random() * 250);
    int scoreReal = 0;
    int speed = 0;
    int speeda = 0;
    int speedb = 0;
    double score = 0;
    boolean touched = false;
    boolean toucheda = false;
    boolean touchedb = false;
    BitmapFont font;
    SpriteBatch sprite;

    public void create()
    {
        shape = new ShapeRenderer();
        font = new BitmapFont();
        sprite = new SpriteBatch();
    }

    public void render(float delta)
    {
        Input input = Gdx.input;
        int x = input.getX(),
            y = Gdx.graphics.getHeight() - input.getY();
        scoreReal = (int)(score);
        sprite.begin();
        font.draw(sprite, Integer.toString(scoreReal), 30, height - 30);
        font.setColor(0, 0, 0, 1.0f);
        sprite.end();
        speed = 1 + (int)(score/5500);
        shapeX += 1 + speed;
        speeda = 1 + (int)(score/4500);
        shapeXa += 2 + speeda;
        speedb = 1 + (int)(score/3500);
        shapeXb += 3 + speedb;
        shape.begin(ShapeType.Filled);
        shape.setColor(0, shapeGreen, 0, 1);
        shape.rect(shapeX, shapeY, shapeWidth, shapeHeight);
        shape.end();
        shape.begin(ShapeType.Filled);
        shape.setColor(0, 0, shapeBluea, 1);
        shape.rect(shapeXa, shapeYa, shapeWidtha, shapeHeighta);
        shape.end();
        shape.begin(ShapeType.Filled);
        shape.setColor(shapeRedb, 0, 0, 1);
        shape.rect(shapeXb, shapeYb, shapeWidthb, shapeHeightb);
        shape.end();
        
        //Cheat code to get up to speed
        if(input.isKeyPressed(Keys.SPACE))
        {
            score = 10000;
        }

        if(shapeX > width)
        {
            shapeY = (int)(Math.random() * height);
            shapeHeight = 30 + (int)(Math.random() * 250);
            shapeWidth = 30 + (int)(Math.random() * 250);
            shapeX = -shapeWidth;
            
            if(touched == false)
            {
                score = (score * 0.85) - 50;
            }

            touched = false;
            shapeGreen = 0;
        }

        if(shapeXa > width)
        {
            shapeYa = (int)(Math.random() * height);
            shapeHeighta = 30 + (int)(Math.random() * 250);
            shapeWidtha = 30 + (int)(Math.random() * 250);
            shapeXa = -shapeWidtha;

            if(toucheda == false)
            {
                score = (score * 0.9) - 50;
            }

            toucheda = false;
            shapeBluea = 0;
        }

        if(shapeXb > width)
        {
            shapeYb = (int)(Math.random() * height);
            shapeWidthb = 30 + (int)(Math.random() * 250);
            shapeHeightb = 30 + (int)(Math.random() * 250);
            shapeXb = -shapeWidthb;

            if(touchedb == false)
            {
                score = (score * 0.95) - 50;
            }

            touchedb = false;
            shapeRedb = 0;
        }

        if(input.isTouched() == true)
        {
            if(x < shapeX + shapeWidth && x > shapeX)
            {
                if(y < shapeY + shapeHeight && y > shapeY)
                {
                    shapeGreen = 1;
                    score += 0.1 + ((90 * speed) * Math.pow(0.8, (shapeWidth + shapeHeight)/10));
                    touched = true;
                }

                else
                {
                    shapeGreen -= 0.005;
                }
            }

            else
            {
                shapeGreen -= 0.005;
            }
        }

        else
        {
            shapeGreen -= 0.005;
        }

        if(input.isTouched() == true)
        {
            if(x < shapeXa + shapeWidtha && x > shapeXa)
            {
                if(y < shapeYa + shapeHeighta && y > shapeYa)
                {
                    shapeBluea = 1;
                    score += 0.1 + ((100 * speeda) * Math.pow(0.8, (shapeWidtha + shapeHeighta)/10));
                    toucheda = true;
                }

                else
                {
                    shapeBluea -= 0.005;
                }
            }

            else
            {
                shapeBluea -= 0.005;
            }
        }

        else
        {
            shapeBluea -= 0.005;
        }

        if(input.isTouched() == true)
        {
            if(x < shapeXb + shapeWidthb && x > shapeXb)
            {
                if(y < shapeYb + shapeHeightb && y > shapeYb)
                {
                    shapeRedb = 1;
                    score += 0.1 + ((110 * speedb) * Math.pow(0.8, (shapeWidthb + shapeHeightb)/10));
                    touchedb = true;
                }

                else
                {
                    shapeRedb -= 0.005;
                }
            }

            else
            {
                shapeRedb -= 0.005;
            }
        }

        else
        {
            shapeRedb -= 0.005;
        }

        /* Old color control code. May have future use. Will delete on 5/28/13 if no use found.
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
        }*/
    }
}
