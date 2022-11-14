package com.tomiprasetyo.ppni;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tomiprasetyo.ppni.databinding.FragmentGithubBinding;
import com.tomiprasetyo.ppni.databinding.FragmentInstagramBinding;

public class InstagramFragment extends Fragment {
    private FragmentInstagramBinding binding;

    public InstagramFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentInstagramBinding.inflate(inflater, container, false);

        binding.instagramAzis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openUrl("https://www.instagram.com/abdlazs/");
            }
        });

        binding.instagramTomi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openUrl("https://www.instagram.com/tomiprasetyo95/");
            }
        });

        binding.instagramQibar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openUrl("https://www.instagram.com/qibar");
            }
        });

        return binding.getRoot();
    }

    private void openUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}