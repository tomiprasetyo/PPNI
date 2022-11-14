package com.tomiprasetyo.ppni;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "data_perawat.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE perawat(nip INTEGER PRIMARY KEY, nama TEXT NULL, tanggal_lahir TEXT NULL, jenis_kelamin TEXT NULL, alamat TEXT NULL);";

        Log.d("Data", "onCreate: " + sql);

        sqLiteDatabase.execSQL(sql);

        sql = "INSERT INTO perawat(nip, nama, tanggal_lahir, jenis_kelamin, alamat) VALUES('1234567', 'Abdul Azis', '1996-07-11', 'Laki-laki', 'Bandung');";

        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
