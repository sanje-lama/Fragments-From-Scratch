package com.example.stl.fragmentfromscratch.networks;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {

    private static Retrofit instance;

    public static Retrofit getInstance() {

        if(instance!=null){
            return instance;
        }else {
            instance=new Retrofit.Builder()
                    .baseUrl("https://raw.githubusercontent.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            return instance;

        }
    }
}
////DSADSADASDASDAKDINFIUNAFNSJKNSKJDNAJKNKJASNDJKNJKANDJKNASJKNSAFCJASKNDIDAndkjaNDKJASNDJKASN

