package com.eshsrobotics.the_last_barcode_symphony.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;

public class TheLastBarcodeSymphony extends Game
{
    PlayScreen playScreen;
    PauseScreen pauseScreen;
    LosingScreen losingScreen;
    LifeCounter lifeCount;
    float delta = 0.1f;
    boolean isPaused = false;
    Music music;
    
    @Override
    public void create() 
    {
        playScreen = new PlayScreen(this);
        losingScreen = new LosingScreen(this);
        lifeCount = LifeCounter.getInstance();
        playScreen.create();
        losingScreen.create();
        setScreen(playScreen);
        music = Gdx.audio.newMusic(Gdx.files.internal("Beethoven5th.mp3"));
        music.play();

        pauseScreen = new PauseScreen(this);
    }
    
    @Override
    public void render()
    {
        getScreen().render(delta);
        /*if(lifeCount.getLifeCount() == 0)
        {
            setScreen(losingScreen);
        }*/
        if(Gdx.input.isKeyPressed(Keys.P))
        {
            playScreen.pause();
        }
    }
}
