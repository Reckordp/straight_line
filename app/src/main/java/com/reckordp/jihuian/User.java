package com.reckordp.jihuian;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class User implements Parcelable {
    public static int JENIS_MURID = 0;
    public static int JENIS_GURU = 1;

    String nama;
    int jenis;
    String pesan;
    String kesan;

    protected User(Parcel in) {
        nama = in.readString();
        jenis = in.readInt();
        pesan = in.readString();
        kesan = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public User() {
    }

    interface OnUserDitemukan {
        void ditemukan(User user);
    }

    public static User temukan(String nama, String pass, OnUserDitemukan oud) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("jihuian").document("guru")
                .get().addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        DocumentSnapshot snap = task.getResult();
                        if (snap.get("nama").equals(nama) && snap.get("passw").equals(pass)) {
                            User ditemukan = new User();
                            ditemukan.nama = "GURU";
                            ditemukan.jenis = JENIS_GURU;
                            oud.ditemukan(ditemukan);
                        } else if (snap.get("pass").equals(Integer.parseInt(pass))) {
                            User ditemukan = new User();
                            ditemukan.nama = nama;
                            ditemukan.jenis = JENIS_MURID;
                            oud.ditemukan(ditemukan);
                        }
                    }
        });
        return null;
    }

    public static User temukan(String nama, String pass) {
        if (nama.equals("guru") && pass.equals("guru")) {
            User ditemukan = new User();
            ditemukan.nama = "GURU";
            ditemukan.jenis = JENIS_GURU;
            return ditemukan;
        } else if (nama.equals("murid") && pass.equals("murid")) {
            User ditemukan = new User();
            ditemukan.nama = "MURID";
            ditemukan.jenis = JENIS_MURID;
            return ditemukan;
        }
        return null;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeInt(jenis);
        dest.writeString(pesan);
        dest.writeString(kesan);
    }
}
