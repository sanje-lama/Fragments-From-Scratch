package com.example.stl.fragmentfromscratch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.stl.fragmentfromscratch.fragments.BlankFragment;

public class DisplayActivity extends AppCompatActivity {

    private String name;
    private int number;
    private  String image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);


        Intent intent=getIntent();
        name=intent.getStringExtra("name");
        number=intent.getIntExtra("number",1);
        image=intent.getStringExtra("image");

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, BlankFragment.newInstance(name, number, image))
                .addToBackStack(null)
                .commit();
    }
}
