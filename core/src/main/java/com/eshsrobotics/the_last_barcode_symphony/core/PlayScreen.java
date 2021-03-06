package com.eshsrobotics.the_last_barcode_symphony.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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
    private Highscores highscore = Highscores.getInstance();
    private int oldLife = 0;
    private int timesChanged = 1;
    private Button pauseButton;

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
        pauseButton = new Button();
        pauseButton.create(30, 30, "PauseButton.png", TheLastBarcodeSymphony.getInstance().pauseScreen);
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
        pauseButton.render(batch);
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
            timesChanged = 1;
            TheLastBarcodeSymphony.getInstance().setScreen(TheLastBarcodeSymphony.getInstance().losingScreen);
        }

        if(score.getScore() != 0)
        {
            oldLife = lifeCount.getLifeCount();
            lifeCount.setLifeCount(lifeCount.getLifeCount() + (int)(score.getScore() / (25000 * timesChanged)));

            if(lifeCount.getLifeCount() == (oldLife + 1))
            {
                timesChanged += 1;
            }
        }

        if((shapeA.isTouched() || shapeB.isTouched() || shapeC.isTouched() || shapeD.isTouched()) && (!TheLastBarcodeSymphony.getInstance().music.isPlaying() || TheLastBarcodeSymphony.getInstance().music.getVolume() < 1))
        {
            TheLastBarcodeSymphony.getInstance().music.play();
            if (TheLastBarcodeSymphony.getInstance().music.getVolume() != 1)
            {
                TheLastBarcodeSymphony.getInstance().music.setVolume(TheLastBarcodeSymphony.getInstance().music.getVolume()+0.1f);
            }
            Gdx.app.log(TheLastBarcodeSymphony.class.getSimpleName(), "playing music.");
        }

        else if(!(shapeA.isTouched() || shapeB.isTouched() || shapeC.isTouched() || shapeD.isTouched()) && TheLastBarcodeSymphony.getInstance().music.isPlaying())
        {
            TheLastBarcodeSymphony.getInstance().music.setVolume(TheLastBarcodeSymphony.getInstance().music.getVolume()-0.1f);
            if (TheLastBarcodeSymphony.getInstance().music.getVolume() == 0)
            {
                TheLastBarcodeSymphony.getInstance().music.pause();
            }
            Gdx.app.log(TheLastBarcodeSymphony.class.getSimpleName(), "stopping music.");
        }

        if(Gdx.input.isKeyPressed(Input.Keys.NUM_1))
        {
            lifeCount.setLifeCount(0);
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
