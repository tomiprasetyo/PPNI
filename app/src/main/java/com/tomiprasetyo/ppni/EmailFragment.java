package com.tomiprasetyo.ppni;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tomiprasetyo.ppni.databinding.FragmentEmailBinding;


public class EmailFragment extends Fragment {

    private FragmentEmailBinding binding;

    public EmailFragment() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        binding = FragmentEmailBinding.inflate(inflater, container, false);

        binding.emailAzis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setData(Uri.parse("mailto:"));
                email.setType("text/plain");
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"abdlazs@gmail.com"});
                startActivity(Intent.createChooser(email, "Send mail"));
            }
        });

        binding.emailTomi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setData(Uri.parse("mailto:"));
                email.setType("text/plain");
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"tomi.prasetyo95@gmail.com"});
                startActivity(Intent.createChooser(email, "Send mail"));
            }
        });

        binding.emailQibar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setData(Uri.parse("mailto:"));
                email.setType("text/plain");
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"rizkiakbar@gmail.com"});
                startActivity(Intent.createChooser(email, "Send mail"));
            }
        });

        return binding.getRoot();
    }
}