package com.example.prm_project_final;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmailPhone, etPassword;
    private ImageButton btnTogglePassword;
    private CheckBox cbRememberMe;
    private Button btnLogin;
    private ImageButton btnApple, btnGoogle, btnFacebook;
    private TextView tvForgotPassword, tvCreateAccount;
    private boolean isPasswordVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Hide action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        initViews();
        setupClickListeners();

        // Get phone number from previous activity if available
        String phoneNumber = getIntent().getStringExtra("phone_number");
        if (phoneNumber != null && !phoneNumber.isEmpty()) {
            etEmailPhone.setText(phoneNumber);
        }
    }

    private void initViews() {
        etEmailPhone = findViewById(R.id.et_email_phone);
        etPassword = findViewById(R.id.et_password);
        btnTogglePassword = findViewById(R.id.btn_toggle_password);
        cbRememberMe = findViewById(R.id.cb_remember_me);
        btnLogin = findViewById(R.id.btn_login);
        btnApple = findViewById(R.id.btn_apple);
        btnGoogle = findViewById(R.id.btn_google);
        btnFacebook = findViewById(R.id.btn_facebook);
        tvForgotPassword = findViewById(R.id.tv_forgot_password);
        tvCreateAccount = findViewById(R.id.tv_create_account);
    }

    private void setupClickListeners() {
        // Toggle password visibility
        btnTogglePassword.setOnClickListener(v -> togglePasswordVisibility());

        // Login button
        btnLogin.setOnClickListener(v -> handleLogin());

        // Social login buttons
        btnApple.setOnClickListener(v -> {
            showToast("Đăng nhập với Apple");
            navigateToHome("Apple User");
        });

        btnGoogle.setOnClickListener(v -> {
            showToast("Đăng nhập với Google");
            navigateToHome("Google User");
        });

        btnFacebook.setOnClickListener(v -> {
            showToast("Đăng nhập với Facebook");
            navigateToHome("Facebook User");
        });

        // Forgot password - Navigate to ForgotPasswordActivity
        tvForgotPassword.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
            startActivity(intent);
        });

        // Create account - navigate back to register
        tvCreateAccount.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void togglePasswordVisibility() {
        if (isPasswordVisible) {
            // Hide password
            etPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            btnTogglePassword.setImageResource(R.drawable.ic_visibility_off);
            isPasswordVisible = false;
        } else {
            // Show password
            etPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            btnTogglePassword.setImageResource(R.drawable.ic_visibility);
            isPasswordVisible = true;
        }
        // Move cursor to end
        etPassword.setSelection(etPassword.getText().length());
    }

    private void handleLogin() {
        String emailPhone = etEmailPhone.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (emailPhone.isEmpty()) {
            showToast("Vui lòng nhập email hoặc số điện thoại");
            return;
        }

        if (password.isEmpty()) {
            showToast("Vui lòng nhập mật khẩu");
            return;
        }

        if (password.length() < 6) {
            showToast("Mật khẩu phải có ít nhất 6 ký tự");
            return;
        }

        // Simulate login process
        showToast("Đăng nhập thành công!");
        navigateToHome(emailPhone);
    }

    private void navigateToHome(String userInfo) {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.putExtra("user_info", userInfo);
        intent.putExtra("remember_me", cbRememberMe.isChecked());
        intent.putExtra("login_type", "login");
        startActivity(intent);
        finish(); // Close login activity
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}