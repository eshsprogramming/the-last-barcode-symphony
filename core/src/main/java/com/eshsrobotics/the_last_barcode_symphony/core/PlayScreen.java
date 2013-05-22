package com.eshsrobotics.the_last_barcode_symphony.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class PlayScreen implements Screen
{
    private LifeMeter batch;
    //private Shape shape;
    private NewShape redShape;
    private NewShape greenShape;
    private NewShape blueShape;
    private Texture texturebg;
    private Texture texturemg;
    private Texture clouds;
    private TextureRegion paraclouds;
    private TextureRegion paraMG;
    private ParallaxBackground rbg;
    private TextureRegion paraBG;
    private Score score;
    private LifeCounter lifeCount;
    private TheLastBarcodeSymphony theLastBarcodeSymphony;
    private int oldLife = 0;
    private int timesChanged = 1;

    public PlayScreen(TheLastBarcodeSymphony theLastBarcodeSymphony) 
    {
        this.theLastBarcodeSymphony = theLastBarcodeSymphony;
    }

    public void create()
    {
        texturebg = new Texture(Gdx.files.internal("BGBC.png"));
        texturemg = new Texture(Gdx.files.internal("MGBC.png"));
        clouds = new Texture(Gdx.files.internal("Clouds.png"));
        paraBG = new TextureRegion(texturebg);
        paraMG = new TextureRegion(texturemg);
        paraclouds = new TextureRegion(clouds);
        score = Score.getInstance();
        lifeCount = LifeCounter.getInstance();
        batch = new LifeMeter();
        redShape = new NewShape();
        greenShape = new NewShape();
        blueShape = new NewShape();
        rbg = new ParallaxBackground(new ParallaxLayer[]
                                     {
                                         new ParallaxLayer(paraBG, new Vector2(0.01f, 0), new Vector2(0, 0)),
                                         //new ParallaxLayer(paraclouds, new Vector2(0.05f, 0), new Vector2(0, 0)),
                                         //new ParallaxLayer(paraMG, new Vector2(0.1f, 0), new Vector2(0, 0))
                                     },
                                     800,
                                     600,
                                     new Vector2(150, 0));
        batch.create();
        redShape.create(1, 0, 0);
        greenShape.create(0, 1, 0);
        blueShape.create(0, 0, 1);
    }

    @Override
    public void dispose()
    {
    }

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(1, 1, 1, 1); //White Screen
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT); // Clear screen
        rbg.render(delta);
        for(int i = lifeCount.getLifeCount(); i > 0; i--)
        {
            batch.render(delta, i);
        }
        if(score.getScore() != 0)
        {
            oldLife = lifeCount.getLifeCount();
            lifeCount.setLifeCount(lifeCount.getLifeCount() + (int)(score.getScore()/(25000*timesChanged)));
            if(lifeCount.getLifeCount() == (oldLife+1))
            {
                timesChanged += 1;
            }
        }
        redShape.render(delta);
        greenShape.render(delta);
        blueShape.render(delta);
        if(lifeCount.getLifeCount() == 0)
        {
            theLastBarcodeSymphony.setScreen(theLastBarcodeSymphony.losingScreen);
        }
        score.render(delta);
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

    @Override
    public void show() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub
        
    }

}
