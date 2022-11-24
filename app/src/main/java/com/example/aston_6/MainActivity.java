package com.example.aston_6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    String[] name, numberPhone,images;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        name = getResources().getStringArray(R.array.users);
        numberPhone = getResources().getStringArray(R.array.numberPhone);
        images = getResources().getStringArray(R.array.linkPhoto);

        Adapter adapter = new Adapter(this, name, numberPhone,images);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}


