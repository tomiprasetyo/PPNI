package com.tomiprasetyo.ppni;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private AppCompatEditText editTextEmail, editTextNama, editTextNoHP, editTextPassword, editTextConfirmPassword;
    private AppCompatButton registrasiButton;
    private TextView textViewLogin;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firebaseAuth = FirebaseAuth.getInstance();

        editTextEmail = findViewById(R.id.email_register);
        editTextNama = findViewById(R.id.nama);
        editTextNoHP = findViewById(R.id.no_hp);
        editTextPassword = findViewById(R.id.password);
        editTextConfirmPassword = findViewById(R.id.confirm_password);
        registrasiButton = findViewById(R.id.registrasi_button);
        textViewLogin = findViewById(R.id.login);

        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        registrasiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrasi();
            }
        });
    }

    private void registrasi() {
        String email, nama, noHP, password, confirmPassword;

        email = editTextEmail.getText().toString();
        nama = editTextNama.getText().toString();
        noHP = editTextNoHP.getText().toString();
        password = editTextPassword.getText().toString();
        confirmPassword = editTextConfirmPassword.getText().toString();

        if (email.isEmpty() || nama.isEmpty() || noHP.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Kolom tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }

        if (!password.equals(confirmPassword)) {
            Toast.makeText(getApplicationContext(), "Password harus match", Toast.LENGTH_SHORT). show();
        }

        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                {
                    if (task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "Sukses registrasi", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Gagal registrasi", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}