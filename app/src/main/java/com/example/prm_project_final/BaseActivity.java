package com.example.prm_project_final;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public abstract class BaseActivity extends AppCompatActivity {

    protected FrameLayout contentFrame;
    protected LinearLayout navHome, navOrder, navActivity, navStore, navOther;
    protected ImageView iconHome, iconOrder, iconActivity, iconStore, iconOther;
    protected TextView textHome, textOrder, textActivity, textStore, textOther;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        initViews();
        setupBottomNavigation();

        // Inflate content layout vào contentFrame
        LayoutInflater.from(this).inflate(getContentLayoutId(), contentFrame, true);

        // Highlight tab hiện tại
        highlightCurrentTab();
    }

    protected abstract int getContentLayoutId();
    protected abstract int getCurrentTabIndex(); // 0: Home, 1: Order, 2: Activity, 3: Store, 4: Other

    private void initViews() {
        contentFrame = findViewById(R.id.content_frame);

        navHome = findViewById(R.id.nav_home);
        navOrder = findViewById(R.id.nav_order);
        navActivity = findViewById(R.id.nav_activity);
        navStore = findViewById(R.id.nav_store);
        navOther = findViewById(R.id.nav_other);

        iconHome = findViewById(R.id.icon_home);
        iconOrder = findViewById(R.id.icon_order);
        iconActivity = findViewById(R.id.icon_activity);
        iconStore = findViewById(R.id.icon_store);
        iconOther = findViewById(R.id.icon_other);

        textHome = findViewById(R.id.text_home);
        textOrder = findViewById(R.id.text_order);
        textActivity = findViewById(R.id.text_activity);
        textStore = findViewById(R.id.text_store);
        textOther = findViewById(R.id.text_other);
    }

    private void setupBottomNavigation() {
        navHome.setOnClickListener(v -> navigateToTab(0));
        navOrder.setOnClickListener(v -> navigateToTab(1));
        navActivity.setOnClickListener(v -> navigateToTab(2));
        navStore.setOnClickListener(v -> navigateToTab(3));
        navOther.setOnClickListener(v -> navigateToTab(4));
    }

    private void navigateToTab(int tabIndex) {
        if (tabIndex == getCurrentTabIndex()) return;

        Intent intent = null;
        switch (tabIndex) {
            case 0:
                intent = new Intent(this, MainActivity.class);
                break;
            case 1:
                //intent = new Intent(this, OrderActivity.class);
                break;
            case 2:
                intent = new Intent(this, HistoryActivity.class);
                break;
            case 3:
                //intent = new Intent(this, HistoryActivity.class);
                break;
            case 4:
                intent = new Intent(this, OtherActivity.class);
                break;
            default:
                return;
        }

        startActivity(intent);
        finish();
    }

    private void highlightCurrentTab() {
        // Reset tất cả tab về trạng thái bình thường
        resetAllTabs();

        // Highlight tab hiện tại
        int currentTab = getCurrentTabIndex();
        switch (currentTab) {
            case 0:
                highlightTab(iconHome, textHome);
                break;
            case 1:
                highlightTab(iconOrder, textOrder);
                break;
            case 2:
                highlightTab(iconActivity, textActivity);
                break;
            case 3:
                highlightTab(iconStore, textStore);
                break;
            case 4:
                highlightTab(iconOther, textOther);
                break;
        }
    }

    private void resetAllTabs() {
        resetTab(iconHome, textHome);
        resetTab(iconOrder, textOrder);
        resetTab(iconActivity, textActivity);
        resetTab(iconStore, textStore);
        resetTab(iconOther, textOther);
    }

    private void resetTab(ImageView icon, TextView text) {
        icon.setColorFilter(ContextCompat.getColor(this, R.color.nav_icon_color));
        text.setTextColor(ContextCompat.getColor(this, R.color.nav_text_color));
    }

    private void highlightTab(ImageView icon, TextView text) {
        icon.setColorFilter(ContextCompat.getColor(this, R.color.nav_icon_selected));
        text.setTextColor(ContextCompat.getColor(this, R.color.nav_text_selected));
    }
}