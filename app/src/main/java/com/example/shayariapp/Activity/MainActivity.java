package com.example.shayariapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.example.shayariapp.R;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvList = findViewById(R.id.rcvList);

        ShayriClick click = new ShayriClick() {
            @Override
            public void getShayri(String quote) {
                Intent intent = new Intent(MainActivity.this, ShayriActivity.class);
                intent.putExtra("quote", quote);
                startActivity(intent);

            }
        };

        RecyclerView.LayoutManager manager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
        ShayriAdaptor adapter = new ShayriAdaptor(Util.shayri,click);
        rcvList.setLayoutManager(manager);
        rcvList.setAdapter(adapter);
    }
}