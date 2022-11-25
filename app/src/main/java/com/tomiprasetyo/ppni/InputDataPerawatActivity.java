package com.tomiprasetyo.ppni;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class InputDataPerawatActivity extends AppCompatActivity {

    protected Cursor cursor;
    DBHelper dbHelper;
    Button simpanDatabutton;
    EditText editText1, editText2, editText3, editText4, editText5, editText6;
    String edit;
    TextView textView1, textView2, textView3, textView4, textView5, textView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data_perawat);
        dbHelper = new DBHelper(this);

        editText1 = findViewById(R.id.edit_text_1);
        editText2 = findViewById(R.id.edit_text_2);
        editText3 = findViewById(R.id.edit_text_3);
        editText4 = findViewById(R.id.edit_text_4);
        editText5 = findViewById(R.id.edit_text_5);
        editText6 = findViewById(R.id.edit_text_6a);

        textView1 = findViewById(R.id.text_view_1);
        textView2 = findViewById(R.id.text_view_2);
        textView3 = findViewById(R.id.text_view_3);
        textView4 = findViewById(R.id.text_view_4);
        textView5 = findViewById(R.id.text_view_5);
        textView6 = findViewById(R.id.text_view_6a);

        simpanDatabutton = findViewById(R.id.simpan_data_button);
        simpanDatabutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();

                edit = editText1.getText().toString();
                edit = editText2.getText().toString();
                edit = editText3.getText().toString();
                edit = editText4.getText().toString();
                edit = editText5.getText().toString();
                edit = editText6.getText().toString();

                if (edit.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Kolom tidak boleh kosong", Toast.LENGTH_SHORT).show();
                } else {
                    sqLiteDatabase.execSQL("INSERT INTO perawat(nip, nama, tanggal_lahir, jenis_kelamin, alamat, unit_kerja) VALUES('" +
                            editText1.getText().toString() + "','" +
                            editText2.getText().toString() + "','" +
                            editText3.getText().toString() + "','" +
                            editText4.getText().toString() + "','" +
                            editText5.getText().toString() + "','" +
                            editText6.getText().toString() + "')");
                    Toast.makeText(getApplicationContext(), "Sukses simpan data", Toast.LENGTH_LONG).show();
                    finish();
                }

                DataPerawatActivity.dataPerawat.RefreshList();
            }
        });
    }
}