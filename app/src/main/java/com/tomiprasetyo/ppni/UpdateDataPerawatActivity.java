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

public class UpdateDataPerawatActivity extends AppCompatActivity {

    protected Cursor cursor;
    DBHelper dbHelper;
    Button updateDataButton;
    EditText editText1, editText2, editText3, editText4, editText5;
    String edit;
    TextView textView1, textView2, textView3, textView4, textView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data_perawat);
        dbHelper = new DBHelper(this);

        editText1 = findViewById(R.id.edit_text_1);
        editText2 = findViewById(R.id.edit_text_2);
        editText3 = findViewById(R.id.edit_text_3);
        editText4 = findViewById(R.id.edit_text_4);
        editText5 = findViewById(R.id.edit_text_5);

        textView1 = findViewById(R.id.text_view_1);
        textView2 = findViewById(R.id.text_view_2);
        textView3 = findViewById(R.id.text_view_3);
        textView4 = findViewById(R.id.text_view_4);
        textView5 = findViewById(R.id.text_view_5);

        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();

        cursor = sqLiteDatabase.rawQuery("SELECT * FROM perawat WHERE nama = '" + getIntent().getStringExtra("nama") + "'", null);
        cursor.moveToFirst();

        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            editText1.setText(cursor.getString(0).toString());
            editText2.setText(cursor.getString(1).toString());
            editText3.setText(cursor.getString(2).toString());
            editText4.setText(cursor.getString(3).toString());
            editText5.setText(cursor.getString(4).toString());
        }

        updateDataButton = findViewById(R.id.update_data_button);
        updateDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase sqLiteDatabase1 = dbHelper.getWritableDatabase();
                edit = editText1.getText().toString();
                edit = editText2.getText().toString();
                edit = editText3.getText().toString();
                edit = editText4.getText().toString();
                edit = editText5.getText().toString();

                if(edit.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Kolom tidak boleh kosong", Toast.LENGTH_SHORT).show();
                } else {
                    sqLiteDatabase1.execSQL("UPDATE perawat SET nama = '" +
                            editText2.getText().toString() + "', tanggal_lahir = '" +
                            editText3.getText().toString() + "', jenis_kelamin = '" +
                            editText4.getText().toString() + "', alamat = '" +
                            editText5.getText().toString() + "' WHERE nip = '" +
                            editText1.getText().toString() + "'");

                    Toast.makeText(getApplicationContext(), "Berhasil edit data", Toast.LENGTH_LONG).show();
                    finish();
                }

                DataPerawatActivity.dataPerawat.RefreshList();
            }
        });

    }
}