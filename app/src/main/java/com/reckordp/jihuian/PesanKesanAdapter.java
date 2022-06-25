package com.reckordp.jihuian;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class PesanKesanAdapter extends ArrayAdapter<User> {

    List<User> users;
    LayoutInflater mInflater;

    public PesanKesanAdapter(@NonNull Context context, int resource, @NonNull List<User> objects) {
        super(context, resource, R.id.nama_pk, objects);
        users = objects;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final View view;

        if (convertView == null) {
            view = mInflater.inflate(R.layout.pesan_kesan, parent, false);
        } else {
            view = convertView;
        }

        User user = users.get(position);
        ((TextView)view.findViewById(R.id.nama_pk)).setText(user.nama);
        ((TextView)view.findViewById(R.id.pesan_pk)).setText(user.pesan);
        ((TextView)view.findViewById(R.id.kesan_pk)).setText(user.kesan);

        return view;
    }
}
