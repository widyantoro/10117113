package com.example.ekawidyantoro;

/**
 * Tanggal Pengerjaan : 12 Mei 2020
 * NIM : 10117113
 * Nama : Eka Widyantoro
 * Kelas : IF-3
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class DBMahasiswa extends SQLiteOpenHelper{

    //InnerClass, untuk mengatur artibut seperti Nama Tabel, nama-nama kolom dan Query
    static abstract class MyColumns implements BaseColumns{
        //Menentukan Nama Table dan Kolom
        static final String NamaTabel = "Mahasiswa";
        static final String NIM = "NIM";
        static final String Nama = "Nama_Mahasiswa";
        static final String Jurusan = "Jurusan";
        static final String Kelas = "Kelas";
        static final String Telepon = "Telepon";
        static final String Email = "Email";
        static final String Instagram = "Instagram";
    }

    private static final String NamaDatabse = "unpi.db";
    private static final int VersiDatabase = 14;

    //Query yang digunakan untuk membuat Tabel
    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE "+MyColumns.NamaTabel+
            "("+MyColumns.NIM+" TEXT PRIMARY KEY, "+MyColumns.Nama+" TEXT NOT NULL, "+MyColumns.Jurusan+
            " TEXT NOT NULL, "+MyColumns.Kelas+" TEXT NOT NULL, "+MyColumns.Telepon+
            " TEXT NOT NULL, "+MyColumns.Email+" TEXT NOT NULL, "+MyColumns.Instagram+" TEXT NOT NULL)";

    //Query yang digunakan untuk mengupgrade Tabel
    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS "+MyColumns.NamaTabel;

    DBMahasiswa(Context context) {
        super(context, NamaDatabse, null, VersiDatabase);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}