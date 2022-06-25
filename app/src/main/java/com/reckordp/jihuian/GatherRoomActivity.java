package com.reckordp.jihuian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class GatherRoomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gather_room);

        findViewById(R.id.edit).setOnClickListener(v -> {
            Intent intent = new Intent(this, PKActivity.class);
            intent.putExtra(PKActivity.MENGUBAH_PESAN, "");
            intent.putExtra(PKActivity.MENGUBAH_KESAN, "");
            startActivity(intent);
            finish();
        });

        findViewById(R.id.kembali).setOnClickListener(v -> finish());
    }
}