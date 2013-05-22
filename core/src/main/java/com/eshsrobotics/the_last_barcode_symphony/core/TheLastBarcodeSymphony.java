package com.eshsrobotics.the_last_barcode_symphony.core;

import com.badlogic.gdx.Game;

public class TheLastBarcodeSymphony extends Game
{
    PlayScreen playScreen;
    LosingScreen losingScreen;
    LifeCounter lifeCount;
    float delta = 0.1f;
    
    @Override
    public void create() 
    {
        playScreen = new PlayScreen(this);
        losingScreen = new LosingScreen(this);
        lifeCount = LifeCounter.getInstance();
        playScreen.create();
        losingScreen.create();
        setScreen(playScreen);
    }
    
    @Override
    public void render()
    {
        getScreen().render(delta);
        if(lifeCount.getLifeCount() == 0)
        {
            setScreen(losingScreen);
        }
    }
}
