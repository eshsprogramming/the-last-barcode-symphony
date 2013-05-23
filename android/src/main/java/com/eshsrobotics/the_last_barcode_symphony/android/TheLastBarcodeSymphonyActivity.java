package com.eshsrobotics.the_last_barcode_symphony.android;

import com.eshsrobotics.the_last_barcode_symphony.core.PlayScreen;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

public class TheLastBarcodeSymphonyActivity extends AndroidApplication
{

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        config.useGL20 = true;
        initialize(new TheLastBarcodeSymphony(), config);
    }
}
