package com.eshsrobotics.the_last_barcode_symphony.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;

public class TheLastBarcodeSymphony extends Game
{
    PlayScreen playScreen;
    PauseScreen pauseScreen;
    MainMenu mainMenu;
    LosingScreen losingScreen;

    LifeCounter lifeCount;
    float delta = 0.1f;
    Music music;
    
    @Override
    public void create() 
    {
        playScreen = new PlayScreen(this);
        losingScreen = new LosingScreen(this);
        lifeCount = LifeCounter.getInstance();
        playScreen.create();
        losingScreen.create();
        music = Gdx.audio.newMusic(Gdx.files.internal("Beethoven5th.mp3"));
        music.play();
        mainMenu = new MainMenu(this);
        pauseScreen = new PauseScreen(this);

        setScreen(mainMenu);
    }
    
    @Override
    public void render()
    {
        getScreen().render(delta);

        if(Gdx.input.isKeyPressed(Keys.P))
        {
            setScreen(pauseScreen);
        }

        if(Gdx.input.isKeyPressed(Keys.ENTER))
        {
            setScreen(playScreen);
        }
    }
}
