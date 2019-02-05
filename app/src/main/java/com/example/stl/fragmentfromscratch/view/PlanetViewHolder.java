package com.example.stl.fragmentfromscratch.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.stl.fragmentfromscratch.DisplayActivity;
import com.example.stl.fragmentfromscratch.R;
import com.example.stl.fragmentfromscratch.model.Planets;
import com.squareup.picasso.Picasso;

public class PlanetViewHolder extends RecyclerView.ViewHolder {
    private TextView nameTextView;
    private TextView numberTextView;
    private ImageView imageView;


    public PlanetViewHolder(@NonNull View itemView) {
        super(itemView);

        nameTextView=itemView.findViewById(R.id.name_text_view);
        numberTextView=itemView.findViewById(R.id.number_text_view);
        imageView=itemView.findViewById(R.id.image_image_view);
    }

    public void onBind(final Planets planets){

        nameTextView.setText(planets.getName());
        numberTextView.setText(String.valueOf(planets.getNumber()));

        Picasso.get()
                .load(planets.getImage())
                .into(imageView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), DisplayActivity.class);
                intent.putExtra("name",planets.getName());
                intent.putExtra("number",planets.getNumber());
                intent.putExtra("image",planets.getImage());
                v.getContext().startActivity(intent);

            }
        });


    }
}
