package com.example.bookmanagementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bookmanagementapp.databinding.ActivityLoginBinding;
import com.example.bookmanagementapp.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

    private String name = "", email = "", password = "";

    private ActivityRegisterBinding binding;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // PROGRESS DIALOG
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Lütfen bekleyiniz");
        progressDialog.setCanceledOnTouchOutside(false);

        // BACK BUTTON
        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        // REGISTER BUTTON
        binding.registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateData();
            }
        });
    }

    private void validateData(){
        name = binding.nameText.getText().toString().trim();
        email = binding.emailText.getText().toString().trim();
        password = binding.passwordText.getText().toString().trim();
        String cPassword = binding.cPasswordText.getText().toString().trim();

        if (TextUtils.isEmpty(name)){
            Toast.makeText(this, "Lütfen adınızı giriniz!", Toast.LENGTH_SHORT).show();
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Toast.makeText(this, "Lütfen e-mailinizi giriniz!", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(password)){
            Toast.makeText(this, "Lütfen şifrenizi giriniz!", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(password)){
            Toast.makeText(this, "Lütfen şifrenizi tekrar giriniz!", Toast.LENGTH_SHORT).show();
        }
        else if (!password.equals(cPassword)){
            Toast.makeText(this, "Lütfen şifreleri aynı giriniz!", Toast.LENGTH_SHORT).show();
        }
        else{
            createUserAccount();
        }
    }

    private void createUserAccount(){
        // PROGRESS DIALOG SHOW
        progressDialog.setMessage("Hesap oluşturuluyor...");
        progressDialog.show();

        System.out.println("İsim: " + name + "\nEmail: " + email + "\nŞifre: " + password);
        Toast.makeText(this, "Kayıt Başarılı!", Toast.LENGTH_SHORT).show();
    }
}