package com.reckordp.jihuian;

public class User {
    public static int JENIS_MURID = 0;
    public static int JENIS_GURU = 1;

    String nama;
    int jenis;

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
}
