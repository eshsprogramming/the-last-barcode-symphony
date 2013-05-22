package com.eshsrobotics.the_last_barcode_symphony.core;

public final class LifeCounter 
{
    public static LifeCounter instance = new LifeCounter();
    
    private int lifeCount = 3;
    
    public static LifeCounter getInstance()
    {
        return instance;
    }

    public int getLifeCount() 
    {
        return lifeCount;
    }

    public void setLifeCount(int lifeCount) 
    {
        this.lifeCount = lifeCount;
    }
}
