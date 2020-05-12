package com.example.ekawidyantoro;

/**
 * Tanggal Pengerjaan : 12 Mei 2020
 * NIM : 10117113
 * Nama : Eka Widyantoro
 * Kelas : IF-3
 */

class DataFilter {

    private String Nama;
    private String NIM;
    private String Jurusan;

    DataFilter(String NIM, String Nama, String Jurusan) {
        this.Nama = Nama;
        this.NIM = NIM;
        this.Jurusan = Jurusan;
    }

    String getNama() {
        return Nama;
    }

    public String getNIM() {
        return NIM;
    }

    public String getJurusan() {
        return Jurusan;
    }
}