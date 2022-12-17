package com.example.booklibraryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    EditText title_input, author_input, pages_input;
    Button add_book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        title_input = findViewById(R.id.titleEt);
        author_input = findViewById(R.id.authorEt);
        pages_input = findViewById(R.id.pagesEt);
        add_book = findViewById(R.id.bookAddButton);

        add_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!title_input.getText().toString().isEmpty() && !author_input.getText().toString().isEmpty() && !pages_input.getText().toString().isEmpty()){
                    MyDatabaseHelper db = new MyDatabaseHelper(AddActivity.this);
                    db.addBook(title_input.getText().toString().trim(),
                            author_input.getText().toString().trim(),
                            Integer.parseInt(pages_input.getText().toString().trim()));
                    startActivity(new Intent(AddActivity.this, MainActivity.class));
                    finish();            
                }
                else{
                    Toast.makeText(AddActivity.this, "Lütfen gerekli yerleri doldurun!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}