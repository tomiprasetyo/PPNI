package com.tomiprasetyo.ppni;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class DataPerawatActivity extends AppCompatActivity {
    String[] daftar;
    ListView listView;
    Menu menu;
    protected Cursor cursor;
    DBHelper dbHelper;
    public static DataPerawatActivity dataPerawat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_perawat);

        Button inputDataButton = findViewById(R.id.input_data_button2);
        inputDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DataPerawatActivity.this, InputDataPerawatActivity.class);
                startActivity(intent);
            }
        });

        dataPerawat = this;
        dbHelper = new DBHelper(this);
        RefreshList();
    }

    public void RefreshList() {
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        cursor = sqLiteDatabase.rawQuery("SELECT * FROM perawat", null);
        daftar = new String[cursor.getCount()];
        cursor.moveToFirst();

        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToPosition(i);
            daftar[i] = cursor.getString(1).toString();
        }

        listView = findViewById(R.id.list_view_1);
        listView.setAdapter(new ArrayAdapter(DataPerawatActivity.this, android.R.layout.simple_list_item_1, daftar));
        listView.setSelected(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final String selection = daftar[i];
                final CharSequence[] dialogItem = {"Lihat Data", "Update Data", "Hapus Data"};

                AlertDialog.Builder builder = new AlertDialog.Builder(DataPerawatActivity.this);
                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int item) {
                        switch (item) {
                            case 0:
                                Intent intent = new Intent(getApplicationContext(), DetailDataPerawat.class);
                                intent.putExtra("nama", selection);
                                startActivity(intent);
                                break;
                            case 1:
                                Intent intent1 = new Intent(getApplicationContext(), UpdateDataPerawatActivity.class);
                                intent1.putExtra("nama", selection);
                                startActivity(intent1);
                                break;
                            case 2:
                                SQLiteDatabase sqLiteDatabase1 = dbHelper.getWritableDatabase();
                                sqLiteDatabase1.execSQL("DELETE FROM perawat WHERE nama = '" + selection + "'");
                                RefreshList();
                                break;
                        }
                    }
                });

                builder.create().show();
            }
        });

        ((ArrayAdapter)listView.getAdapter()).notifyDataSetInvalidated();
    }

}