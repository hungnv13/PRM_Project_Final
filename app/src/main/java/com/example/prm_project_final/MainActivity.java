package com.example.prm_project_final;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etPhone;
    private Button btnContinue;
    private ImageButton btnApple, btnGoogle, btnFacebook;
    private TextView tvGuest, tvSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hide action bar for full screen experience
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
                    // Handle phone login
                    showToast("Đăng nhập với số: +84" + phone);
                }
            }
        });

        btnApple.setOnClickListener(v -> {
            showToast("Đăng nhập với Apple");
            // TODO: Implement Apple login
        });

        btnGoogle.setOnClickListener(v -> {
            showToast("Đăng nhập với Google");
            // TODO: Implement Google login
        });

        btnFacebook.setOnClickListener(v -> {
            showToast("Đăng nhập với Facebook");
            // TODO: Implement Facebook login
        });

        tvGuest.setOnClickListener(v -> {
            showToast("Tiếp tục như khách");
            // TODO: Navigate to main app as guest
        });

        tvSignIn.setOnClickListener(v -> {
            showToast("Chuyển đến màn hình đăng nhập");
            // TODO: Navigate to sign in screen
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}