package com.reckordp.jihuian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class PKActivity extends AppCompatActivity {
    public static String MENGUBAH_PESAN = "UBAH PESAN";
    public static String MENGUBAH_KESAN = "UBAH KESAN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pkactivity);

        EditText pesan = findViewById(R.id.pesan);
        EditText kesan = findViewById(R.id.kesan);

        Intent intent = getIntent();
        if (intent.hasExtra(MENGUBAH_PESAN)) {
            pesan.setText(intent.getStringExtra(MENGUBAH_PESAN));
        }

        if (intent.hasExtra(MENGUBAH_KESAN)) {
            kesan.setText(intent.getStringExtra(MENGUBAH_KESAN));
        }

        findViewById(R.id.kirim).setOnClickListener(v -> {
            startActivity(new Intent(this, GatherRoomActivity.class));
            finish();
        });
    }
}