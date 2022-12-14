package com.example.bookmanagementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.bookmanagementapp.databinding.ActivityDashboardUserBinding;
import com.example.bookmanagementapp.databinding.ActivityLoginBinding;

public class DashboardUserActivity extends AppCompatActivity {

    private ActivityDashboardUserBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}