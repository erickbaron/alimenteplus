package com.example.doevida;

// AddPostActivity.java
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class AddPostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);

        EditText editTextPostContent = findViewById(R.id.editTextPostContent);
        Button buttonBack = findViewById(R.id.buttonBack);
        Button buttonPost = findViewById(R.id.buttonPost);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed(); // Volta para a atividade anterior
            }
        });

        buttonPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed(); // Volta para a atividade anterior
            }
        });
    }
}
