package com.example.bookmanagementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.bookmanagementapp.databinding.ActivityCategoryAddBinding;

public class CategoryAddActivity extends AppCompatActivity {

    private ActivityCategoryAddBinding binding;

    private ProgressDialog progressDialog;

    private String category = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoryAddBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Lütfen bekleyiniz...");
        progressDialog.setCanceledOnTouchOutside(false);

        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        binding.submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateData();
            }
        });
    }

    private void validateData(){
        category = binding.categoryText.getText().toString().trim();

        if (TextUtils.isEmpty(category)){
            Toast.makeText(this,"Lütfen kategori giriniz!", Toast.LENGTH_SHORT).show();
        }
        else{
            addCategory();
        }
    }

    private void addCategory(){
        progressDialog.setTitle("Kategori ekleniyor...");
        progressDialog.show();
        Toast.makeText(this,"Kategori ekleme başarılı!", Toast.LENGTH_SHORT).show();
        progressDialog.dismiss();
    }
}