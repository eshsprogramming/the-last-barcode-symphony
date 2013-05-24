package com.eshsrobotics.the_last_barcode_symphony.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.FPSLogger;

public class TheLastBarcodeSymphony extends Game
{
    public static final String TAG = TheLastBarcodeSymphony.class.getSimpleName();
    public static final FPSLogger FPS_LOGGER = new FPSLogger();

    PlayScreen playScreen;
    PauseScreen pauseScreen;
    MainMenu mainMenu;
    LosingScreen losingScreen;

    Music music;
    Highscores highscore;

    @Override
    public void create() 
    {
        playScreen = new PlayScreen(this);
        losingScreen = new LosingScreen(this);
        mainMenu = new MainMenu(this);
        pauseScreen = new PauseScreen(this);
        Gdx.app.log(TAG, "Instantiated screens!");

        playScreen.create();
        Gdx.app.log(TAG, "Called mysterious create method on appropriate screens.");
        
        highscore = Highscores.getInstance();
        highscore.loadHighscores();

        music = Gdx.audio.newMusic(Gdx.files.internal("Beethoven5th.mp3"));
        music.play();
        Gdx.app.log(TAG, "Started playing music.");

        setScreen(mainMenu);
        Gdx.app.log(TAG, "Set screen to main menu.");
    }
    
    @Override
    public void render()
    {
        getScreen().render(Gdx.graphics.getDeltaTime());
        FPS_LOGGER.log();

        if(getScreen() == pauseScreen)
        {
            if(Gdx.input.isKeyPressed(Keys.P))
            {
                setScreen(playScreen);
                Gdx.app.log(TAG, "Set screen to play screen.");
            }
        }
        else
        {
            if(Gdx.input.isKeyPressed(Keys.P) && getScreen() != mainMenu)
            {
                setScreen(pauseScreen);
                Gdx.app.log(TAG, "Set screen to pause screen.");
            }
        }

        if(Gdx.input.isKeyPressed(Keys.ENTER))
        {
            setScreen(playScreen);
            Gdx.app.log(TAG, "Set screen to play screen.");
        }
    }
}
