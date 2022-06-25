package com.reckordp.jihuian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class PKActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pkactivity);

        findViewById(R.id.kirim).setOnClickListener(v -> {
            startActivity(new Intent(this, GatherRoomActivity.class));
            finish();
        });
    }
}