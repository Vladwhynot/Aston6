package com.example.aston_6;

import static android.widget.Toast.LENGTH_SHORT;

import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    String[] name,numberPhone,images;
    Context context;
    int positionTree;


     public Adapter(Context ct, String[] n, String[] np, String[] img){

        context = ct;
        name = n;
        numberPhone = np;
        images = img;

    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
      View view = inflater.inflate(R.layout.contacts_user_list,parent,false);
      return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int positionTwo = position;
        positionTree = positionTwo;
        holder.textName.setText(name[positionTwo]);
        holder.textNumberPhone.setText(numberPhone[positionTwo]);
            Glide.with(holder.Image)
                    .load(images[positionTwo])
                    .circleCrop()
                    .placeholder(R.drawable.ic_user)
                    .error(R.drawable.ic_no)
                   // .skipMemoryCache(true)
                   // .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .into(holder.Image);


        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DeteilActivity.class);
                intent.putExtra("name", name[positionTwo]);
                intent.putExtra("numberPhone", numberPhone[positionTwo]);
                intent.putExtra("Image", images[positionTwo]);
                context.startActivity(intent);
            }
        });
    }



    @Override
    public int getItemCount() {
        return 100;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
       TextView textName, textNumberPhone;
       ImageView  Image;
       ConstraintLayout mainLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.textViewName);
            textNumberPhone = itemView.findViewById(R.id.textViewNumberPhone);
            Image = itemView.findViewById(R.id.imageView);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }

    }


}
