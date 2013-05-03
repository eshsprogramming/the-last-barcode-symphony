package com.eshsrobotics.the_last_barcode_symphony.core;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;

public class TheLastBarcodeSymphony implements ApplicationListener
{
    private SpriteBatch batch;
    private Texture texture;
    private ShapeRenderer shape;
    private Texture texturebg;
    private Texture texturemg;
    private Texture clouds;
    private TextureRegion paraclouds;
    private TextureRegion paraMG;
    private ParallaxBackground rbg;
    private TextureRegion paraBG;
    private float delta = 0.1f;

    int shapeHeight = 50;
    int shapeWidth = 50;
    int shapeX = 100;
    int shapeY = 100;

    int shapeRed = 0;
    int shapeGreen = 0;
    int shapeBlue = 0;

    @Override
    public void create()
    {
        texture = new Texture(Gdx.files.internal("Test.png"));
        texturebg = new Texture(Gdx.files.internal("BGBC.png"));
        texturemg = new Texture(Gdx.files.internal("MGBC.png"));
        clouds = new Texture(Gdx.files.internal("Clouds.png"));
        paraBG = new TextureRegion(texturebg);
        paraMG = new TextureRegion(texturemg);
        paraclouds = new TextureRegion(clouds);
        batch = new SpriteBatch();
        shape = new ShapeRenderer();
        rbg = new ParallaxBackground(new ParallaxLayer[]
                {
                    new ParallaxLayer(paraBG,new Vector2(0.01f,0), new Vector2(0, 0)), 
                    new ParallaxLayer(paraclouds, new Vector2(0.05f,0), new Vector2(0,0)), 
                    new ParallaxLayer(paraMG, new Vector2(0.1f,0), new Vector2(0,0))
                },
                800,
                600,
                new Vector2(150,0));
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
        rbg.render(delta);

        batch.begin();
        batch.draw(texture, 16, 16);
        batch.end();

        shape.begin(ShapeType.Filled);
        shape.setColor(shapeRed, shapeGreen, shapeBlue, 1);
        shape.rect(shapeX, shapeY, shapeWidth, shapeHeight);
        shape.end();

        //Controls size with "WASD"
        if(Gdx.input.isKeyPressed(Keys.W)) shapeHeight = shapeHeight + 3;
        if(Gdx.input.isKeyPressed(Keys.S)) shapeHeight = shapeHeight - 3;
        if(Gdx.input.isKeyPressed(Keys.A)) shapeWidth = shapeWidth - 3;
        if(Gdx.input.isKeyPressed(Keys.D)) shapeWidth = shapeWidth + 3;

        //Controls Location with arrow keys
        if(Gdx.input.isKeyPressed(Keys.DPAD_UP)) shapeY = shapeY + 3;
        if(Gdx.input.isKeyPressed(Keys.DPAD_DOWN)) shapeY = shapeY - 3;
        if(Gdx.input.isKeyPressed(Keys.DPAD_LEFT)) shapeX = shapeX - 3;
        if(Gdx.input.isKeyPressed(Keys.DPAD_RIGHT)) shapeX = shapeX + 3;

        //Poorly controls color, will be fixed in future. Use numbers 1-3 to control
        if(Gdx.input.isKeyPressed(Keys.NUM_1)) shapeGreen++;
        if(Gdx.input.isKeyPressed(Keys.NUM_2)) shapeBlue++;
        if(Gdx.input.isKeyPressed(Keys.NUM_3)) shapeRed++;
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
