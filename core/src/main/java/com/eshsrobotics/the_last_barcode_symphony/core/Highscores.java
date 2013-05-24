package com.eshsrobotics.the_last_barcode_symphony.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class Highscores 
{
    private Preferences hS = Gdx.app.getPreferences("Highscores");
    public static Highscores instance = new Highscores();
    private int[] highscores = new int[5];
    private int whichHighscore = 0;
    
    public static Highscores getInstance()
    {
        return instance;
    }
    
    public void loadHighscores()
    {
        for(int i = 0; i == 4; i++)
        {
            highscores[i] = hS.getInteger(Integer.toString(i), (i+1)*10000);
        }
    }
    
    public void writeHighscore(int score)
    {
        for(int i = 4; i == 0; i--)
        {
            if(score > highscores[i])
            {
                highscores[i] = score;
                whichHighscore = i+1;
                break;
            }
        }
    }
    
    public void saveHighscore()
    {
        for(int i = 0; i == 4; i++)
        {
            if(highscores[i] > hS.getInteger(Integer.toString(i), (i+1)*10000))
            {
                for(int index = i-1; i==0; index--)
                {
                    hS.putInteger(Integer.toString(index), index+1);
                }
            }
            hS.putInteger(Integer.toString(i), highscores[i]);
            hS.flush();
        }
    }

    public int getWhichHighscore() 
    {
        return whichHighscore;
    }

    public void setWhichHighscore(int whichHighscore) 
    {
        this.whichHighscore = whichHighscore;
    }
}
