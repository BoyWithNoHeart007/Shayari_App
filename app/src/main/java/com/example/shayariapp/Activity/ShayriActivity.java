package com.example.shayariapp.Activity;

import static com.example.shayariapp.R.drawable.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shayariapp.R;

public class ShayriActivity extends AppCompatActivity {


    int imgArray[] = {img1,img2,img3,img4,img5,img6,img7,img8,img9,img10};
    RecyclerView imgList;
    TextView txtShayri;
    ImageView backImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shayri);

        txtShayri = findViewById(R.id.txtShayri);
        imgList = findViewById(R.id.imgList);
        backImage = findViewById(R.id.backImage);

        String shayri = getIntent().getStringExtra("shayri");
        txtShayri.setText(shayri);

        ImageClick click = new ImageClick() {
            @Override
            public void getImage(int pos) {
                Glide.with(ShayriActivity.this).load(imgArray[pos]).into(backImage);
            }
        };


        RecyclerView.LayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        ImageListAdapter adapter = new ImageListAdapter(imgArray,click);
        imgList.setLayoutManager(manager);
        imgList.setAdapter(adapter);

    }
}