package com.reckordp.jihuian;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class JihuianActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jihuian);

        String nama = tertulis(R.id.nama);
        String pass = tertulis(R.id.pass);

        findViewById(R.id.ok_login).setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("User tidak ditemukan");
            builder.setMessage("Periksa Nama dan password, karena mungkin salah");
            builder.setPositiveButton(android.R.string.ok, (i, ii) -> { });
            builder.show();
        });
    }

    private String tertulis(int id) {
        return ((EditText)findViewById(id)).getText().toString();
    }
}