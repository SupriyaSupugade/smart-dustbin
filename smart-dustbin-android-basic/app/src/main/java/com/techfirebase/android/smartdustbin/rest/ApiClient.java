package com.techfirebase.android.smartdustbin.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
  private static Retrofit retrofit = null;
  //   private static final String BASE_URL = "http://172.16.89.125:8080/";

  private static final String BASE_URL = "http://10.0.2.2:8080/";
  //private static final String BASE_URL =
      //"http://ec2-52-14-42-109.us-east-2.compute.amazonaws.com:8080/";

  public static Retrofit getClient() {

    /*HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
    */

    retrofit =
        new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    return retrofit;
  }
}
