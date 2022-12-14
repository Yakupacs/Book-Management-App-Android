package com.example.bookmanagementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.bookmanagementapp.databinding.ActivityLoginBinding;
import com.example.bookmanagementapp.databinding.ActivityMainBinding;

public class LoginActivity extends AppCompatActivity {

    private String email = "", password = "";

    private ActivityLoginBinding binding;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Lütfen bekleyiniz");
        progressDialog.setCanceledOnTouchOutside(true);

        binding.noAccountTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View  view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateData();
            }
        });
    }

    private void validateData(){
        email = binding.emailText.getText().toString().trim();
        password = binding.passwordText.getText().toString().trim();

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Toast.makeText(this, "Lütfen e-mailinizi giriniz!", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(password)){
            Toast.makeText(this, "Lütfen şifrenizi tekrar giriniz!", Toast.LENGTH_SHORT).show();
        }
        else{
            login();
        }
    }

    private void login(){
        progressDialog.setTitle("Giriş yapılıyor...");
        progressDialog.show();
        startActivity(new Intent(LoginActivity.this, DashboardAdminActivity.class));
    }
}