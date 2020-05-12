package com.example.ekawidyantoro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Toolbar;

/**
 * Tanggal Pengerjaan : 12 Mei 2020
 * NIM : 10117113
 * Nama : Eka Widyantoro
 * Kelas : IF-3
 */

public class UpdateActivity extends AppCompatActivity {

    private DBMahasiswa MyDatabase;
    private EditText NewNIM, NewNama;
    private Spinner NewJurusan;
    private String getNewNIM, getNewNama, getNewJurusan;
    private Button Update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        MyDatabase = new DBMahasiswa(getBaseContext());
        NewNIM = findViewById(R.id.new_nim);
        NewNama = findViewById(R.id.new_nama);
        NewJurusan = findViewById(R.id.new_jurusan);
        Update = findViewById(R.id.new_data);
        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setUpdateData();
                startActivity(new Intent(UpdateActivity.this, MainActivity.class));
                finish();
            }
        });
    }

    private void setUpdateData(){
        getNewNIM = NewNIM.getText().toString();
        getNewNama = NewNama.getText().toString();
        getNewJurusan = NewJurusan.getSelectedItem().toString();

        //Menerima Data NIM yang telah dipilih Oleh User untuk diposes
        String GetNIM = getIntent().getExtras().getString("SendNIM");

        SQLiteDatabase database = MyDatabase.getReadableDatabase();

        //Memasukan Data baru pada 3 kolom (NIM, Nama dan Jurusan)
        ContentValues values = new ContentValues();
        values.put(DBMahasiswa.MyColumns.Nama, getNewNama);
        values.put(DBMahasiswa.MyColumns.Jurusan, getNewJurusan);
        values.put(DBMahasiswa.MyColumns.NIM, getNewNIM);

        //Untuk Menentukan Data/Item yang ingin diubah, berdasarkan NIM
        String selection = DBMahasiswa.MyColumns.NIM + " LIKE ?";
        String[] selectionArgs = {GetNIM};
        database.update(DBMahasiswa.MyColumns.NamaTabel, values, selection, selectionArgs);
        Toast.makeText(getApplicationContext(), "Berhasil Diubah", Toast.LENGTH_SHORT).show();
    }
}
