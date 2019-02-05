package com.example.stl.fragmentfromscratch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.stl.fragmentfromscratch.controllers.PlanetAdapter;
import com.example.stl.fragmentfromscratch.model.PlanetList;
import com.example.stl.fragmentfromscratch.networks.PlanetService;
import com.example.stl.fragmentfromscratch.networks.RetrofitSingleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "planets";


    private RecyclerView recyclerView;
    private PlanetAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));


        Retrofit retrofit=RetrofitSingleton.getInstance();
        PlanetService retrofitServiceInterface=retrofit.create(PlanetService.class);
        Call<PlanetList> planetListCall=(retrofitServiceInterface).planetData();
        planetListCall.enqueue(new Callback<PlanetList>() {
            @Override
            public void onResponse(Call<PlanetList> call, Response<PlanetList> response) {
                PlanetList responseData=response.body();
                Log.d(TAG, "onResponse: "+responseData.getPlanets().get(0).getImage());

                adapter = new PlanetAdapter(response.body().getPlanets());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<PlanetList> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.toString());

            }
        });
    }

}

