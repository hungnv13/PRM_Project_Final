package com.example.prm_project_final;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

public class MainAppActivity extends AppCompatActivity {

    private static final int SPLASH_DELAY = 100;
    private TextView tvWelcome;
    private Handler splashHandler;
    private Runnable splashRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_app);

        // Hide action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        initViews();
        startSplashTimer();
    }

    private void initViews() {
        tvWelcome = findViewById(R.id.tv_welcome);

        // Set welcome message
        tvWelcome.setText("Chào mừng đến với\nHighlands Coffee!");
    }

    private void startSplashTimer() {
        splashHandler = new Handler(Looper.getMainLooper());
        splashRunnable = new Runnable() {
            @Override
            public void run() {
                // Navigate to Register Activity
                Intent intent = new Intent(MainAppActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish(); // Close splash activity
            }
        };

        // Start timer
        splashHandler.postDelayed(splashRunnable, SPLASH_DELAY);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Cancel timer if activity is destroyed
        if (splashHandler != null && splashRunnable != null) {
            splashHandler.removeCallbacks(splashRunnable);
        }
    }

    @Override
    public void onBackPressed() {
        // Prevent back press on splash screen
        // Do nothing or exit app
        super.onBackPressed();
    }
}