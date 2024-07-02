package com.example.doevida;
// MainActivity.java
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class FeedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.addItemDecoration(new DividerItemDecoration(this));

        // Exemplo de dados
        List<FeedItem> feedList = new ArrayList<>();
        feedList.add(new FeedItem("user1", "Description 1"));
        feedList.add(new FeedItem("user2", "Description 2"));
        feedList.add(new FeedItem("user3", "Description 3"));
        feedList.add(new FeedItem("user4", "Description 1"));
        feedList.add(new FeedItem("user5", "Description 2"));
        feedList.add(new FeedItem("user6", "Description 3"));
        feedList.add(new FeedItem("user7", "Description 1"));
        feedList.add(new FeedItem("user8", "Description 2"));
        feedList.add(new FeedItem("user9", "Description 3"));
        feedList.add(new FeedItem("user10", "Description 1"));
        feedList.add(new FeedItem("user11", "Description 2"));
        feedList.add(new FeedItem("user12", "Description 2"));
        feedList.add(new FeedItem("user13", "Description 3"));
        feedList.add(new FeedItem("user14", "Description 1"));
        feedList.add(new FeedItem("user15", "Description 2"));
        feedList.add(new FeedItem("user16", "Description 3"));
        feedList.add(new FeedItem("user17", "Description 1"));
        feedList.add(new FeedItem("user18", "Description 2"));
        feedList.add(new FeedItem("user19", "Description 3"));

        FeedAdapter adapter = new FeedAdapter(feedList, this);
        recyclerView.setAdapter(adapter);

        ImageButton buttonChat = findViewById(R.id.buttonChat);



        // Configurar os botões do footbar
        ImageButton buttonAdd = findViewById(R.id.buttonAdd);

        buttonAdd.setOnClickListener(v -> {
            Intent intent = new Intent(FeedActivity.this, AddPostActivity.class);
            startActivity(intent);
        });
    }
}

