package com.tomiprasetyo.ppni;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailInformasiActivity extends AppCompatActivity {

    ImageView imageViewDetail;
    TextView textViewDetailTitle, textViewDetailDescription;

    String title, description;
    int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_informasi);

        imageViewDetail = findViewById(R.id.image_view_detail);
        textViewDetailTitle = findViewById(R.id.text_view_detail_title);
        textViewDetailDescription = findViewById(R.id.text_view_detail_description);

        getData();
        setData();
    }

    private void getData() {
        if (getIntent().hasExtra("Image") && getIntent().hasExtra("Data Title") && getIntent().hasExtra("Data Description")) {

            title = getIntent().getStringExtra("Data Title");
            description = getIntent().getStringExtra("Data Description");
            image = getIntent().getIntExtra("Image", 1);

        } else {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData() {
        textViewDetailTitle.setText(title);
        textViewDetailDescription.setText(description);
        imageViewDetail.setImageResource(image);
    }
}