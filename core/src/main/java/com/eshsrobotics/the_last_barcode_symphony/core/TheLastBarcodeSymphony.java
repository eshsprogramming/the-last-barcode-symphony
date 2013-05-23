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
    int userIdent = 0;
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
        userIdent = playScreen.getUserIdent();
        setScreen(mainMenu);
    }
    
    @Override
    public void render()
    {
        getScreen().render(delta);

        if(getScreen() == pauseScreen)
        {
            if(Gdx.input.isKeyPressed(Keys.P))
            {
                setScreen(playScreen);
            }
        }
        else
        {
            if(Gdx.input.isKeyPressed(Keys.P) && getScreen() != mainMenu)
            {
                setScreen(pauseScreen);
            }
        }

        if(Gdx.input.isKeyPressed(Keys.ENTER))
        {
            setScreen(playScreen);
        }
    }
}
