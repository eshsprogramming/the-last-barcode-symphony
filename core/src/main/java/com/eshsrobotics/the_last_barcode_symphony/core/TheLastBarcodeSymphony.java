package com.eshsrobotics.the_last_barcode_symphony.core;

import com.badlogic.gdx.Game;

public class TheLastBarcodeSymphony extends Game
{
    PlayScreen playScreen;
    
    @Override
    public void create() 
    {
        playScreen = new PlayScreen(this);
        playScreen.create();
        setScreen(playScreen);
    }
}
