package com.example.retrofeitex.Services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofeitInstance {

    //Declare Retrofit and BASE_URL
    private static Retrofit retrofit = null;
    private static String BASE_URL ="https://api.printful.com/";

    // Singleton Pattern Used to Create an instance of Retrofit
    public static GetCountryDataService getService(){


        // instance is not created before
        if (retrofit == null){
            retrofit = new Retrofit.Builder() //Build retrofit
                    .baseUrl(BASE_URL) //attach base URL to retrofit
                    .addConverterFactory(GsonConverterFactory.create()).build(); //Convert json to gson

        }

        // if instance is already created
        return  retrofit.create(GetCountryDataService.class);

    }

}
