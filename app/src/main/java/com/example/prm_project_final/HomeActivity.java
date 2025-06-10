package com.example.prm_project_final;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    private TextView tvWelcome;
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Hide action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        initViews();
        setupWelcomeMessage();
        setupClickListeners();
    }

    private void initViews() {
        tvWelcome = findViewById(R.id.tv_welcome);
        btnLogout = findViewById(R.id.btn_logout);
    }

    private void setupWelcomeMessage() {
        String userInfo = getIntent().getStringExtra("user_info");
        String loginType = getIntent().getStringExtra("login_type");
        boolean rememberMe = getIntent().getBooleanExtra("remember_me", false);

        String welcomeMessage = "Chào mừng đến với Highlands Coffee!";
        if (userInfo != null) {
            welcomeMessage += "\n\nThông tin: " + userInfo;
        }
        if (loginType != null) {
            welcomeMessage += "\nLoại: " + loginType;
        }
        if (rememberMe) {
            welcomeMessage += "\n(Đã ghi nhớ đăng nhập)";
        }

        tvWelcome.setText(welcomeMessage);
    }

    private void setupClickListeners() {
        btnLogout.setOnClickListener(v -> {
            Toast.makeText(this, "Đăng xuất thành công", Toast.LENGTH_SHORT).show();

            // Navigate back to splash screen
            Intent intent = new Intent(HomeActivity.this, MainAppActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });
    }

    @Override
    public void onBackPressed() {
        // Prevent going back to login screen
        Toast.makeText(this, "Sử dụng nút đăng xuất để thoát", Toast.LENGTH_SHORT).show();
    }
}