package com.eshsrobotics.the_last_barcode_symphony.java;

import com.eshsrobotics.the_last_barcode_symphony.core.TheLastBarcodeSymphony;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class TheLastBarcodeSymphonyDesktop
{

    public static void main(String[] args)
    {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.useGL20 = true;
        config.title = "The Last Barcode Symphony";
        new LwjglApplication(new TheLastBarcodeSymphony(), config);
    }
}