package com.tomiprasetyo.ppni;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class InformasiActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    String title[], description[];
    int images[] = {R.drawable.ppni_1, R.drawable.ppni_2, R.drawable.ppni_3};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informasi);

        recyclerView = findViewById(R.id.recycler_view);

        title = getResources().getStringArray(R.array.informasi_kegiatan);
        description = getResources().getStringArray(R.array.description);

        Adapter adapter = new Adapter(this, title, description, images);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }



}