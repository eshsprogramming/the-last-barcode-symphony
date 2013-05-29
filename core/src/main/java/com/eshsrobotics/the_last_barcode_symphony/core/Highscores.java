package com.eshsrobotics.the_last_barcode_symphony.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class Highscores 
{
    private Preferences hS = Gdx.app.getPreferences("Highscores");
    public static Highscores instance = new Highscores();
    private int[] highscores = new int[5];
    private int isHighscore = -1;
    
    public static Highscores getInstance()
    {
        return instance;
    }
    
    public void loadHighscores()
    {
        for(int i = 0; i <= 4; i++)
        {
            highscores[i] = hS.getInteger(Integer.toString(i), 0);
        }
    }
    
    public void writeHighscore(int score)
    {
        for(int i = 4; i >= 0; i--)
        {
            if(score > highscores[i])
            {
                for(int index = 0; index < i; index++)
                {
                    highscores[index] = highscores[index+1];
                }
                highscores[i] = score;
                isHighscore = i;
                break;
            }
            else
            {
                isHighscore = -1;
            }
        }
    }
    
    public void saveHighscore()
    {
        for(int i = 0; i <= 4; i++)
        {
            hS.putInteger(Integer.toString(i), highscores[i]);
            System.out.println(highscores[i]);
        }
        hS.flush();
    }

    public int getIsHighscore() 
    {
        return isHighscore;
    }

    public void setIsHighscore(int isHighscore) 
    {
        this.isHighscore = isHighscore;
    }
}
