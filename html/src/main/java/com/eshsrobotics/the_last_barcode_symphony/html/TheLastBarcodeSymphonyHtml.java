package com.eshsrobotics.the_last_barcode_symphony.html;

import com.eshsrobotics.the_last_barcode_symphony.core.PlayScreen;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;

public class TheLastBarcodeSymphonyHtml extends GwtApplication
{
    @Override
    public ApplicationListener getApplicationListener()
    {
        return new PlayScreen();
    }

    @Override
    public GwtApplicationConfiguration getConfig()
    {
        return new GwtApplicationConfiguration(480, 320);
    }
}
