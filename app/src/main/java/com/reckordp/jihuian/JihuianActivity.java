package com.reckordp.jihuian;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class JihuianActivity extends AppCompatActivity {
    public static String USER_APP = "USER APP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jihuian);

        Button login = findViewById(R.id.ok_login);
        login.setOnClickListener(v -> {
            String nama = tertulis(R.id.nama);
            String pass = tertulis(R.id.pass);
            login.setEnabled(false);

            User.temukan(nama, pass, dapat -> {
                if (dapat == null) {
                    noUser();
                } else if (dapat.jenis == User.JENIS_GURU) {
                    startActivity(buatIntent(dapat, MejaGuruActivity.class));
                } else {
                    startActivity(buatIntent(dapat, PKActivity.class));
                }
                login.setEnabled(true);
            });
        });
    }

    private Intent buatIntent(User user, Class<?> cls) {
        Intent intent = new Intent(this, cls);
        intent.putExtra(USER_APP, user);
        return intent;
    }

    private String tertulis(int id) {
        return ((EditText)findViewById(id)).getText().toString();
    }

    private void noUser() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("User tidak ditemukan");
        builder.setMessage("Periksa Nama dan password, karena mungkin salah");
        builder.setPositiveButton(android.R.string.ok, (i, ii) -> { });
        builder.show();
    }
}