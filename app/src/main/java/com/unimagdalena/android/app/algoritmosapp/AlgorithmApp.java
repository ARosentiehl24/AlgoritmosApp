package com.unimagdalena.android.app.algoritmosapp;

import android.app.Application;
import android.content.Context;

import com.unimagdalena.android.app.algoritmosapp.util.kisstools.KissTools;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by albert on 8/11/2017.
 */

public class AlgorithmApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //Typekit.getInstance().addNormal(Typekit.createFromAsset(this, "fonts/Typo_Round.otf")).addBold(Typekit.createFromAsset(this, "fonts/Typo_Round_Bold.otf")).addItalic(Typekit.createFromAsset(this, "fonts/Typo_Round_Italic.otf"));
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Rocko.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());

        KissTools.setContext(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(base));
    }
}
