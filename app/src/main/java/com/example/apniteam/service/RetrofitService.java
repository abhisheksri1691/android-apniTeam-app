package com.example.apniteam.service;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private static Retrofit.Builder retrofit = new Retrofit.Builder();

    public static <S> S createService(Class<S> serviceClass) {

        System.out.println("inside RetrofitService createService ");
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit bulder= retrofit.baseUrl("https://mapps.cricbuzz.com/cbzios/match/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return bulder.create(serviceClass);
    }
}
