package com.example.aston_6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class DeteilActivity extends AppCompatActivity {

    ImageView imageViewTwo;
    TextView textViewNameTwo;
    TextView textViewNumberPhoneTwo;
    String name,numberPhone,Image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deteil);

        imageViewTwo = findViewById(R.id.imageViewTwo);
        textViewNameTwo = findViewById(R.id.textViewNameTwo);
        textViewNumberPhoneTwo = findViewById(R.id.textViewNumberPhoneTwo);

        getData();
        setData();
    }

    private void getData(){
        if(getIntent().hasExtra("Image") && getIntent().hasExtra("name") && getIntent().hasExtra("numberPhone")){

            name = getIntent().getStringExtra("name");
            numberPhone = getIntent().getStringExtra("numberPhone");
            Image = getIntent().getStringExtra("Image");
        }
    }

    private void setData(){
        textViewNumberPhoneTwo.setText(numberPhone);
        textViewNameTwo.setText(name);
        Glide.with(imageViewTwo)
                .load(Image)
                .circleCrop()
                // .skipMemoryCache(true)
               // .diskCacheStrategy(DiskCacheStrategy.NONE)
                .placeholder(R.drawable.ic_user)
                .error(R.drawable.ic_user)
                .into( imageViewTwo);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}