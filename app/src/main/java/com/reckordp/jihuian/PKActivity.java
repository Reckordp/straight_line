package com.reckordp.jihuian;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import java.io.File;
import java.nio.file.Files;

public class PKActivity extends AppCompatActivity {
    public static String MENGUBAH_PESAN_KESAN = "MELAKUKAN PERUBAHAN";

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pkactivity);

        EditText pesan = findViewById(R.id.pesan);
        EditText kesan = findViewById(R.id.kesan);

        if (!(new File(getCacheDir(), "dibuka")).exists()) {
            startActivity(new Intent(this, WaitingActivity.class));
        }

        Intent intent = getIntent();
        if (intent.hasExtra(JihuianActivity.USER_APP)) {
            user = intent.getParcelableExtra(JihuianActivity.USER_APP);
            pesan.setText(user.pesan);
            kesan.setText(user.kesan);
        } else {
            noUser();
        }

        findViewById(R.id.kirim).setOnClickListener(v -> {
            user.pesan = pesan.getText().toString();
            user.kesan = kesan.getText().toString();
            keGather();
            finish();
        });
    }

    private void keGather() {
        Intent intent = new Intent(this, GatherRoomActivity.class);
        intent.putExtra(JihuianActivity.USER_APP, user);
        startActivity(intent);
    }

    private void noUser() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Fatal");
        builder.setMessage("NO USER");
        builder.setPositiveButton(android.R.string.ok, (i, ii) -> { finish(); });
        builder.show();
    }
}