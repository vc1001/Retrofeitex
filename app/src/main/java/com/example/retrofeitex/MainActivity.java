package com.example.retrofeitex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.retrofeitex.Services.GetCountryDataService;
import com.example.retrofeitex.Services.RetrofeitInstance;
import com.example.retrofeitex.adapter.CountryAdapter;
import com.example.retrofeitex.model.CountryModel;
import com.example.retrofeitex.model.ResultModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CountryAdapter countryAdapter;

    ArrayList<ResultModel> resultList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetCountries();

    }
    public Object GetCountries(){

        GetCountryDataService getCountryDataService = RetrofeitInstance.getService();
        Call<CountryModel> call = getCountryDataService.getData();

        call.enqueue(new Callback<CountryModel>() {
            @Override
            public void onResponse(Call<CountryModel> call, Response<CountryModel> response) {
                CountryModel countryModel = response.body();

                if ((countryModel != null) && (countryModel.getResultmodel()!= null)){
                    resultList = (ArrayList<ResultModel>) countryModel.getResultmodel();



                }
                ViewData();
            }

            @Override
            public void onFailure(Call<CountryModel> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();

            }
        });

        return resultList;
    }
    private void ViewData() {

        recyclerView = findViewById(R.id.recyclerview);
        countryAdapter = new CountryAdapter(resultList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(countryAdapter);
    }

}
