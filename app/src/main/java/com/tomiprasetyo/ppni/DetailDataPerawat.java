package com.tomiprasetyo.ppni;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class DetailDataPerawat extends AppCompatActivity {

    protected Cursor cursor;
    DBHelper dbHelper;
    TextView textView2, textView4, textView6, textView8, textView10, textView12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_data_perawat);
        dbHelper = new DBHelper(this);

        textView2 = findViewById(R.id.text_view_2);
        textView4 = findViewById(R.id.text_view_4);
        textView6 = findViewById(R.id.text_view_6);
        textView8 = findViewById(R.id.text_view_8);
        textView10 = findViewById(R.id.text_view_10);
        textView12 = findViewById(R.id.text_view_12);

        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        cursor = sqLiteDatabase.rawQuery("SELECT * FROM perawat WHERE nama = '" +
                getIntent().getStringExtra("nama") + "'", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            textView2.setText(cursor.getString(0).toString());
            textView4.setText(cursor.getString(1).toString());
            textView6.setText(cursor.getString(2).toString());
            textView8.setText(cursor.getString(3).toString());
            textView10.setText(cursor.getString(4).toString());
            textView12.setText(cursor.getString(5).toString());
        }
    }
}