package com.tomiprasetyo.ppni;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tomiprasetyo.ppni.databinding.FragmentGithubBinding;

public class GithubFragment extends Fragment {
    private FragmentGithubBinding binding;

    public GithubFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentGithubBinding.inflate(inflater, container, false);

        binding.githubAzis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openUrl("https://github.com/abdlazs");
            }
        });

        binding.githubTomi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openUrl("https://github.com/tomiprasetyo");
            }
        });

        binding.githubQibar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openUrl("https://github.com/qibar");
            }
        });

        return binding.getRoot();
    }

    private void openUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}