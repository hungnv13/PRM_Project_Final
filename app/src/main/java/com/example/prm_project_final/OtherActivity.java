package com.example.prm_project_final;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class OtherActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupClickListeners();
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.content_other;
    }

    @Override
    protected int getCurrentTabIndex() {
        return 4; // Tab "Khác"
    }

    private void setupClickListeners() {
        // Language button
        findViewById(R.id.btn_language).setOnClickListener(v ->
                showToast("Chọn ngôn ngữ")
        );

        // Activate button
        findViewById(R.id.btn_activate).setOnClickListener(v ->
                showToast("Kích hoạt tài khoản")
        );

        // Logout button
        findViewById(R.id.btn_logout).setOnClickListener(v ->
                showToast("Đăng xuất")
        );

        // Menu items
        findViewById(R.id.menu_profile).setOnClickListener(v ->
                showToast("Hồ sơ")
        );

        findViewById(R.id.menu_settings).setOnClickListener(v ->
                showToast("Cài đặt")
        );

        findViewById(R.id.menu_terms).setOnClickListener(v ->
                showToast("Điều khoản dịch vụ")
        );

        findViewById(R.id.menu_privacy).setOnClickListener(v ->
                showToast("Chính sách bảo mật")
        );

        findViewById(R.id.menu_about).setOnClickListener(v ->
                showToast("Giới thiệu ứng dụng")
        );

        findViewById(R.id.menu_faq).setOnClickListener(v ->
                showToast("Câu hỏi thường gặp")
        );

        findViewById(R.id.menu_feedback).setOnClickListener(v ->
                showToast("Phản hồi & hỗ trợ")
        );
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
