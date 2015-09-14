package com.mviniciuspimenta.marketshoppinglist.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.mviniciuspimenta.marketshoppinglist.R;

/**
 * @author Marcus Pimenta
 * @email mvinicius.pimenta@gmail.com
 * @date 14/09/15 19:40
 */
public class SplashActivity extends Activity implements IActivity{

    private final int DELAY = 4000;
    private final int DELAY_ANIMATION = 2500;

    private ImageView splashImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        settingsAttributes();
        settingsView();
    }

    @Override
    protected void onResume() {
        super.onResume();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MenuActivity.class));
                finish();
            }
        }, DELAY);
    }

    @Override
    public void onBackPressed() {
        return;
    }

    @Override
    public void settingsAttributes() {

    }

    @Override
    public void settingsView() {
        Animation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(DELAY_ANIMATION);

        splashImageView = (ImageView) findViewById(R.id.splashImageView);
        splashImageView.startAnimation(animation);
    }


}
