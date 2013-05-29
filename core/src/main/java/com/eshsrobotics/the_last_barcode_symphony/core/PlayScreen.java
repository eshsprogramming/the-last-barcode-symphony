package com.eshsrobotics.the_last_barcode_symphony.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PlayScreen implements Screen
{
    private LifeMeter lifeMeter;
    private SpriteBatch batch;
    private NewShape shapeA;
    private NewShape shapeB;
    private NewShape shapeC;
    private NewShape shapeD;
    private Texture texturebg;
    private ParallaxBackground rbg;
    private TextureRegion paraBG;
    private Score score;
    private LifeCounter lifeCount;
    private TheLastBarcodeSymphony theLastBarcodeSymphony;
    private Highscores highscore = Highscores.getInstance();
    private int oldLife = 0;
    private int timesChanged = 1;

    public PlayScreen(TheLastBarcodeSymphony theLastBarcodeSymphony) 
    {
        this.theLastBarcodeSymphony = theLastBarcodeSymphony;
    }

    public void create()
    {
        texturebg = new Texture(Gdx.files.internal("BGBC.png"));
        paraBG = new TextureRegion(texturebg);
        rbg = new ParallaxBackground(new ParallaxLayer[]
                                     {
                                         new ParallaxLayer(paraBG, new Vector2(0.01f, 0), new Vector2(0, 0)),
                                     },
                                     800,
                                     600,
                                     new Vector2(150, 0));
        
        score = Score.getInstance();
        
        lifeCount = LifeCounter.getInstance();
        lifeMeter = new LifeMeter();

        shapeA = new NewShape();
        shapeB = new NewShape();
        shapeC = new NewShape();
        shapeD = new NewShape();
        
        batch = new SpriteBatch();
        
        lifeMeter.create();

        shapeA.create();
        shapeB.create();
        shapeC.create();
        shapeD.create();

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

        shapeA.render(delta);
        shapeB.render(delta);
        shapeC.render(delta);
        shapeD.render(delta);

        score.render(delta);
        
        batch.begin();
        for(int i = lifeCount.getLifeCount(); i > 0; i--)
        {
            lifeMeter.render(delta, i, batch);
        }
        batch.end();
        
        if(lifeCount.getLifeCount() <= 0)
        {
            highscore.writeHighscore((int)(score.getScore()));
            highscore.saveHighscore();
            theLastBarcodeSymphony.setScreen(theLastBarcodeSymphony.losingScreen);

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

        if((shapeA.isTouched() || shapeB.isTouched() || shapeC.isTouched()) && !theLastBarcodeSymphony.music.isPlaying())
        {
            theLastBarcodeSymphony.music.play();
            Gdx.app.log(TheLastBarcodeSymphony.class.getSimpleName(), "playing music.");
        }
        else if(!(shapeA.isTouched() || shapeB.isTouched() || shapeC.isTouched()) && theLastBarcodeSymphony.music.isPlaying())
        {
            theLastBarcodeSymphony.music.pause();
            Gdx.app.log(TheLastBarcodeSymphony.class.getSimpleName(),"stopping music.");
        }
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
    public void show() 
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void hide() 
    {
        // TODO Auto-generated method stub
        
    }

    public void reset()
    {
        score.setScore(0);
        shapeA.reset();
        shapeB.reset();
        shapeC.reset();
        shapeD.reset();
        lifeCount.setLifeCount(3);
    }
}
