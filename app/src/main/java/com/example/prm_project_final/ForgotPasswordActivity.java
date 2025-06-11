package com.example.prm_project_final;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class ForgotPasswordActivity extends AppCompatActivity {

    private ImageButton btnClose;
    private EditText etEmailPhone;
    private Button btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        // Hide action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        initViews();
        setupClickListeners();
        setupTextWatcher();
    }

    private void initViews() {
        btnClose = findViewById(R.id.btn_close);
        etEmailPhone = findViewById(R.id.et_email_phone);
        btnContinue = findViewById(R.id.btn_continue);
    }

    private void setupClickListeners() {
        // Close button
        btnClose.setOnClickListener(v -> {
            finish(); // Close activity and return to previous screen
        });

        // Continue button
        btnContinue.setOnClickListener(v -> handleForgotPassword());
    }

    private void setupTextWatcher() {
        etEmailPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Do nothing
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Enable/disable continue button based on input
                boolean hasText = s.toString().trim().length() > 0;
                btnContinue.setEnabled(hasText);

                if (hasText) {
                    btnContinue.setBackgroundResource(R.drawable.button_background);
                    btnContinue.setTextColor(getResources().getColor(R.color.white));
                } else {
                    btnContinue.setBackgroundResource(R.drawable.button_background_disabled);
                    btnContinue.setTextColor(getResources().getColor(R.color.dark_gray));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Do nothing
            }
        });
    }

    private void handleForgotPassword() {
        String emailPhone = etEmailPhone.getText().toString().trim();

        if (emailPhone.isEmpty()) {
            showToast("Vui lòng nhập email hoặc số điện thoại");
            return;
        }

        // Validate email or phone format
        if (!isValidEmailOrPhone(emailPhone)) {
            showToast("Email hoặc số điện thoại không hợp lệ");
            return;
        }

        // Simulate sending reset password request
        showToast("Đã gửi link đặt lại mật khẩu đến " + emailPhone);

        // TODO: Implement actual forgot password logic
        // For now, just close the activity
        finish();
    }

    private boolean isValidEmailOrPhone(String input) {
        // Simple validation for email or phone
        if (input.contains("@")) {
            // Basic email validation
            return input.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
        } else {
            // Basic phone validation (Vietnamese phone numbers)
            return input.matches("^[0-9+]{9,15}$");
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        // Same as close button
        finish();
    }
}