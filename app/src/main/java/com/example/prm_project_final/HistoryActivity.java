package com.example.prm_project_final;

import android.os.Bundle;

public class HistoryActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_history;
    }

    @Override
    protected int getCurrentTabIndex() {
        return 2;
    }

  }
