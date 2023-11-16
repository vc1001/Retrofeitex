package com.example.retrofeitex.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofeitex.R;
import com.example.retrofeitex.model.CountryModel;
import com.example.retrofeitex.model.ResultModel;

import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {

    ArrayList<ResultModel> resultList;

    public CountryAdapter(ArrayList<ResultModel> resultList) {
        this.resultList = resultList;
    }

    @NonNull
    @Override
    public CountryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
               View view=layoutInflater.inflate(R.layout.item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryAdapter.ViewHolder holder, int position) {

        ResultModel resultModel = resultList.get(position);
        holder.textView.setText(resultModel.getCode());
        holder.textView1.setText(resultModel.getName());
        holder.textView2.setText(resultModel.getRegion());
     // holder.textView3.setText(resultModel.getStates().toString());
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    //ViewHolder
    class ViewHolder extends RecyclerView.ViewHolder{


        TextView textView,textView1,textView2,textView3;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView= itemView.findViewById(R.id.textView);
            textView1= itemView.findViewById(R.id.textview1);
            textView2=itemView.findViewById(R.id.textview2);
        //    textView3=itemView.findViewById(R.id.states);

        }
    }
}
