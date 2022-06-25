package com.reckordp.jihuian;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class GatherRoomActivity extends AppCompatActivity {

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gather_room);

        Intent fromPrev = getIntent();
        if (fromPrev.hasExtra(JihuianActivity.USER_APP)) {
            user = fromPrev.getParcelableExtra(JihuianActivity.USER_APP);
        } else {
            noUser();
        }

        findViewById(R.id.edit).setOnClickListener(v -> {
            Intent intent = new Intent(this, PKActivity.class);
            intent.putExtra(PKActivity.MENGUBAH_PESAN_KESAN, true);
            intent.putExtra(JihuianActivity.USER_APP, user);
            startActivity(intent);
            finish();
        });

        findViewById(R.id.kembali).setOnClickListener(v -> finish());
    }

    private void noUser() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Fatal");
        builder.setMessage("NO USER");
        builder.setPositiveButton(android.R.string.ok, (i, ii) -> { finish(); });
        builder.show();
        finish();
    }
}