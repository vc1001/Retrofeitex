package com.example.retrofeitex.Services;

import com.example.retrofeitex.model.CountryModel;
import com.example.retrofeitex.model.ResultModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetCountryDataService {


    @GET ("countries")
    Call<CountryModel> getData();
}
