package com.example.ekawidyantoro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Tanggal Pengerjaan : 12 Mei 2020
 * NIM : 10117113
 * Nama : Eka Widyantoro
 * Kelas : IF-3
 */

public class TambahActivity extends AppCompatActivity {

    private EditText NIM, Nama, Kelas, Telepon, Email, Instagram;
    private Spinner Jurusan;

    //Variable Untuk Menyimpan Input Dari Ueer
    private String setNIM, setNama, setKelas, setTelepon, setJurusan, setEmail, setInstagram;

    //Variable Untuk Inisialisasi Database DBMahasiswa
    private DBMahasiswa dbMahasiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambah_data);
        Button simpan = findViewById(R.id.save);
        NIM = findViewById(R.id.nim);
        Nama = findViewById(R.id.nama);
        Telepon = findViewById(R.id.telepon);
        Jurusan = findViewById(R.id.jurusan);
        Kelas = findViewById(R.id.kelas);
        Telepon = findViewById(R.id.telepon);
        Email = findViewById(R.id.email);
        Instagram = findViewById(R.id.instagram);

        //Inisialisasi dan Mendapatkan Konteks dari DBMahasiswa
        dbMahasiswa = new DBMahasiswa(getBaseContext());

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setData();
                saveData();
                Toast.makeText(getApplicationContext(),"Data Berhasil Disimpan", Toast.LENGTH_SHORT).show();
                clearData();
                startActivity(new Intent(TambahActivity.this, MainActivity.class));

            }
        });
    }

    //Berisi Statement-Statement Untuk Mendapatkan Input Dari User
    private void setData(){
        setNIM = NIM.getText().toString();
        setNama = Nama.getText().toString();
        setJurusan = Jurusan.getSelectedItem().toString();
        setKelas = Kelas.getText().toString();
        setTelepon = Telepon.getText().toString();
        setEmail = Email.getText().toString();
        setInstagram = Instagram.getText().toString();
    }

    //Berisi Statement-Statement Untuk Menyimpan Data Pada Database
    private void saveData(){
        //Mendapatkan Repository dengan Mode Menulis
        SQLiteDatabase create = dbMahasiswa.getWritableDatabase();

        //Membuat Map Baru, Yang Berisi Nama Kolom dan Data Yang Ingin Dimasukan
        ContentValues values = new ContentValues();
        values.put(DBMahasiswa.MyColumns.NIM, setNIM);
        values.put(DBMahasiswa.MyColumns.Nama, setNama);
        values.put(DBMahasiswa.MyColumns.Jurusan, setJurusan);
        values.put(DBMahasiswa.MyColumns.Kelas, setKelas);
        values.put(DBMahasiswa.MyColumns.Telepon, setTelepon);
        values.put(DBMahasiswa.MyColumns.Email, setEmail);
        values.put(DBMahasiswa.MyColumns.Instagram, setInstagram);

        //Menambahkan Baris Baru, Berupa Data Yang Sudah Diinputkan pada Kolom didalam Database
        create.insert(DBMahasiswa.MyColumns.NamaTabel, null, values);
    }

    private void clearData(){
        NIM.setText("");
        Nama.setText("");
        Kelas.setText("");
        Email.setText("");
    }
}
