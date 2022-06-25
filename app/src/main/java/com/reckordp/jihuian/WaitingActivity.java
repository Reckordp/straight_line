package com.reckordp.jihuian;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class WaitingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting);

        findViewById(R.id.refresh_waiting).setOnClickListener(v -> {
//            File fl = new File(getCacheDir(), "dibuka");
//            try {
//                fl.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            finish();
        });
    }

    @Override
    public void onBackPressed() {
        // DISABLE
    }
}