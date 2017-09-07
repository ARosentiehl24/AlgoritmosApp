package com.unimagdalena.android.app.algoritmosapp.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.unimagdalena.android.app.algoritmosapp.R;
import com.unimagdalena.android.app.algoritmosapp.view.fragment.BasicInstructionsFragment;
import com.unimagdalena.android.app.algoritmosapp.view.fragment.ConditionalsFragment;
import com.unimagdalena.android.app.algoritmosapp.view.fragment.IOFragment;
import com.unimagdalena.android.app.algoritmosapp.view.fragment.LoopsFragment;

import org.fingerlinks.mobile.android.navigator.Navigator;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.prefs.Prefs;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.navigation)
    BottomNavigationView navigation;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            item.setChecked(true);

            Context _this = MainActivity.this;
            Integer page = Prefs.with(_this).readInt("page");

            switch (item.getItemId()) {
                case R.id.navigation_basic_instructions:

                    getSupportActionBar().setTitle(R.string.title_basic_instructions);

                    Navigator.with(_this)
                            .build()
                            .goTo(new BasicInstructionsFragment(), R.id.fragmentContainer)
                            .animation(page < 1 ? R.anim.slide_in_from_left : R.anim.slide_in_from_right, page < 1 ? R.anim.slide_out_to_right : R.anim.slide_out_to_left)
                            .replace()
                            .commit();

                    Prefs.with(_this).writeInt("page", 1);
                    break;
                /*case R.id.navigation_input_output:
                    Navigator.with(MainActivity.this).build().goTo(new IOFragment(), R.id.fragmentContainer).replace().commit();
                    break;*/
                case R.id.navigation_conditionals:

                    getSupportActionBar().setTitle(R.string.title_conditionals);

                    Navigator.with(_this)
                            .build()
                            .goTo(new ConditionalsFragment(), R.id.fragmentContainer)
                            .animation(page < 2 ? R.anim.slide_in_from_left : R.anim.slide_in_from_right, page < 2 ? R.anim.slide_out_to_right : R.anim.slide_out_to_left)
                            .replace()
                            .commit();

                    Prefs.with(_this).writeInt("page", 2);
                    break;
                case R.id.navigation_loops:

                    getSupportActionBar().setTitle(R.string.title_loops);

                    Navigator.with(_this)
                            .build()
                            .goTo(new LoopsFragment(), R.id.fragmentContainer)
                            .animation(page < 3 ? R.anim.slide_in_from_left : R.anim.slide_in_from_right, page < 3 ? R.anim.slide_out_to_right : R.anim.slide_out_to_left)
                            .replace()
                            .commit();

                    Prefs.with(_this).writeInt("page", 3);
                    break;
            }

            return false;
        }
    };

    private BottomNavigationView.OnNavigationItemReselectedListener mOnNavigationItemReselectedListener = new BottomNavigationView.OnNavigationItemReselectedListener() {
        @Override
        public void onNavigationItemReselected(@NonNull MenuItem item) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setOnNavigationItemReselectedListener(mOnNavigationItemReselectedListener);

        getSupportActionBar().setTitle(R.string.title_basic_instructions);

        Navigator.with(MainActivity.this).build().goTo(new BasicInstructionsFragment(), R.id.fragmentContainer).replace().commit();

        Prefs.with(this).writeInt("page", 1);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
