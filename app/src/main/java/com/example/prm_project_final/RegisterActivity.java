package com.example.prm_project_final;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText etPhone;
    private Button btnContinue;
    private ImageButton btnApple, btnGoogle, btnFacebook;
    private TextView tvGuest, tvSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Hide action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        initViews();
        setupClickListeners();
    }

    private void initViews() {
        etPhone = findViewById(R.id.et_phone);
        btnContinue = findViewById(R.id.btn_continue);
        btnApple = findViewById(R.id.btn_apple);
        btnGoogle = findViewById(R.id.btn_google);
        btnFacebook = findViewById(R.id.btn_facebook);
        tvGuest = findViewById(R.id.tv_guest);
        tvSignIn = findViewById(R.id.tv_sign_in);
    }

    private void setupClickListeners() {
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = etPhone.getText().toString().trim();
                if (phone.isEmpty()) {
                    showToast("Vui lòng nhập số điện thoại");
                } else if (phone.length() < 9) {
                    showToast("Số điện thoại không hợp lệ");
                } else {
                    // Handle registration process
                    showToast("Đăng ký với số: +84" + phone);
                    // TODO: Navigate to OTP verification or complete registration
                    navigateToHomeScreen("Registered User: +84" + phone);
                }
            }
        });

        btnApple.setOnClickListener(v -> {
            showToast("Đăng ký với Apple");
            navigateToHomeScreen("Apple User");
        });

        btnGoogle.setOnClickListener(v -> {
            showToast("Đăng ký với Google");
            navigateToHomeScreen("Google User");
        });

        btnFacebook.setOnClickListener(v -> {
            showToast("Đăng ký với Facebook");
            navigateToHomeScreen("Facebook User");
        });

        tvGuest.setOnClickListener(v -> {
            showToast("Tiếp tục như khách");
            navigateToHomeScreen("Guest User");
        });

        // Navigate to Login Activity
        tvSignIn.setOnClickListener(v -> {
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
        });
    }

    private void navigateToHomeScreen(String userType) {
        Intent intent = new Intent(RegisterActivity.this, HomeActivity.class);
        intent.putExtra("user_info", userType);
        intent.putExtra("login_type", "registration");
        startActivity(intent);
        finish();
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        // Exit app when back pressed on register screen
        finishAffinity();
    }
}