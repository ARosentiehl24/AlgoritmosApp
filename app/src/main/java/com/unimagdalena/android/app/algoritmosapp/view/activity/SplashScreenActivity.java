package com.unimagdalena.android.app.algoritmosapp.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.unimagdalena.android.app.algoritmosapp.R;
import com.unimagdalena.android.app.algoritmosapp.view.custom.particleview.ParticleView;

import org.fingerlinks.mobile.android.navigator.Navigator;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class SplashScreenActivity extends AppCompatActivity {

    @BindView(R.id.ivLogo)
    ImageView ivLogo;
    @BindView(R.id.particleView)
    ParticleView particleView;
    @BindView(R.id.ivBottomBanner)
    ImageView ivBottomBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ButterKnife.bind(this);

        particleView.startAnim();
        particleView.clearAnimation();
        particleView.setOnParticleAnimListener(new ParticleView.ParticleAnimListener() {
            @Override
            public void onAnimationEnd() {
                Navigator.with(SplashScreenActivity.this).build().goTo(MainActivity.class).animation(R.anim.slide_in_from_left, R.anim.slide_out_to_right).commit();
                finish();
            }
        });
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
