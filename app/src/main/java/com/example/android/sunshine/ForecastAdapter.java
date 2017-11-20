package com.example.android.sunshine;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.sql.Array;

/**
 * Created by BodaSadalla on 11/19/2017.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder> {
   private  String[] mWeatherData;

 final private ListItemClickListnerInterface mOnClickListner;

    public  interface ListItemClickListnerInterface{
        void onClickListner(int clickedItemIndex);

    }

    public ForecastAdapter(ListItemClickListnerInterface listner){
        mOnClickListner=listner;

    }

    public class ForecastAdapterViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{
        public  final TextView mWeatherTextView;

       public ForecastAdapterViewHolder(View view){
            super(view);
            mWeatherTextView = (TextView) view.findViewById(R.id.tv_weather_data);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int clickedPosition=getAdapterPosition();
            mOnClickListner.onClickListner(clickedPosition);
        }
    }

    @Override
    public ForecastAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        int layoutIdForForecastListItem=R.layout.forecast_list_item;
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
         View view= inflater.inflate(layoutIdForForecastListItem,parent,false);
         ForecastAdapterViewHolder viewHolder=new ForecastAdapterViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ForecastAdapterViewHolder holder, int position) {
        holder.mWeatherTextView.setText(mWeatherData[position]);
    }

    @Override
    public int getItemCount() {
        if(mWeatherData==null)return 0;
        else
            return mWeatherData.length;
    }

    void  setmWeatherData(String[] weatherData){
        mWeatherData=weatherData;
        notifyDataSetChanged();

    }





}

