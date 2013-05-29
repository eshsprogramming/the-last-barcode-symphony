package com.eshsrobotics.the_last_barcode_symphony.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.FPSLogger;

public class TheLastBarcodeSymphony extends Game
{
    public static final String TAG = TheLastBarcodeSymphony.class.getSimpleName();
    public static final FPSLogger FPS_LOGGER = new FPSLogger();

    PlayScreen playScreen;
    PauseScreen pauseScreen;
    QuitScreen quitScreen;
    ResetScreen resetScreen;
    MainMenu mainMenu;
    LosingScreen losingScreen;
    HighscoreScreen highscoreScreen;

    Music music;
    Highscores highscore;

    @Override
    public void create() 
    {
        playScreen = new PlayScreen(this);
        losingScreen = new LosingScreen(this);
        quitScreen = new QuitScreen(this);
        mainMenu = new MainMenu(this);
        pauseScreen = new PauseScreen(this);
        highscoreScreen = new HighscoreScreen(this);
        Gdx.app.log(TAG, "Instantiated screens!");

        playScreen.create();
        pauseScreen.create();
        Gdx.app.log(TAG, "Called mysterious create method on appropriate screens.");

        mainMenu.create();

        highscore = Highscores.getInstance();
        highscore.loadHighscores();

        music = Gdx.audio.newMusic(Gdx.files.internal("Beethoven5th.mp3"));
        music.play();
        music.pause();
        Gdx.app.log(TAG, "Started playing music.");

        setScreen(mainMenu);
        Gdx.app.log(TAG, "Set screen to main menu.");
    }

    public void render()
    {
        getScreen().render(Gdx.graphics.getDeltaTime());
        FPS_LOGGER.log();

        if(Gdx.input.isKeyPressed(Keys.ESCAPE) && getScreen() == playScreen)
        {
            setScreen(pauseScreen);
            Gdx.app.log(TAG, "Set screen to pause screen.");
        }
    }

    public void setTheScreen(Screen screen)
    {
        setScreen(screen);
    }
}
