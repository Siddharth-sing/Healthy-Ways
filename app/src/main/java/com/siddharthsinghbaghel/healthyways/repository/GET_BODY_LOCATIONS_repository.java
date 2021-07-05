package com.siddharthsinghbaghel.healthyways.repository;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.siddharthsinghbaghel.healthyways.pojo.Item;
import com.siddharthsinghbaghel.healthyways.pojo.body_locations;
import com.siddharthsinghbaghel.healthyways.pojo.body_symptoms;
import com.siddharthsinghbaghel.healthyways.tools.get_data_from_retrofit;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GET_BODY_LOCATIONS_repository {

//    String TAG = "TAG";

    private final Executor executor = Executors.newSingleThreadExecutor();
    private get_data_from_retrofit get_data_from_retrofit;

    public static final String TAG = "TAG";

    private MutableLiveData<ArrayList<body_locations>> body_locations_live_data = new MutableLiveData<>();
    private MutableLiveData<ArrayList<body_locations>> body_location_live_data = new MutableLiveData<>();
    private MutableLiveData<ArrayList<body_symptoms>> body_location_symptoms_live_data = new MutableLiveData<>();
    private MutableLiveData<ArrayList<Item>> body_diag_live_data = new MutableLiveData<>();

    public static GET_BODY_LOCATIONS_repository getInstance() {
        return new GET_BODY_LOCATIONS_repository(); }

    public MutableLiveData<ArrayList<body_locations>> GET_BODY_LOCATIONS(){
        executor.execute(() -> {

            get_data_from_retrofit = get_data_from_retrofit.retrofit.create(get_data_from_retrofit.class);
            Call<ArrayList<body_locations>> dataCall = get_data_from_retrofit.GET_BODY_LOCATIONS();

            dataCall.enqueue(new Callback<ArrayList<body_locations>>() {
                @Override
                public void onResponse(Call<ArrayList<body_locations>> call, Response<ArrayList<body_locations>> response) {
                    ArrayList<body_locations> arrayList = response.body();
                    body_locations_live_data.setValue(arrayList);
                }

                @Override
                public void onFailure(Call<ArrayList<body_locations>> call, Throwable t) {
                    Log.d(TAG, "onFailure: " + t);
                }
            });

        });

        return body_locations_live_data;
    }

    public MutableLiveData<ArrayList<body_locations>> GET_BODY_LOCATION(int body_part_id){
        executor.execute(() -> {

            get_data_from_retrofit = get_data_from_retrofit.retrofit.create(get_data_from_retrofit.class);
            Call<ArrayList<body_locations>> dataCall = get_data_from_retrofit.GET_BODY_LOCATION(body_part_id);

            dataCall.enqueue(new Callback<ArrayList<body_locations>>() {
                @Override
                public void onResponse(Call<ArrayList<body_locations>> call, Response<ArrayList<body_locations>> response) {
                    ArrayList<body_locations> arrayList = response.body();
                    body_location_live_data.setValue(arrayList);
                }

                @Override
                public void onFailure(Call<ArrayList<body_locations>> call, Throwable t) {
                    Log.d(TAG, "onFailure: " + t);
                }
            });

        });

        return body_location_live_data;
    }


    public MutableLiveData<ArrayList<body_symptoms>> GET_BODY_SYMPTOMS(int body_part_id){
        executor.execute(() -> {

            get_data_from_retrofit = get_data_from_retrofit.retrofit.create(get_data_from_retrofit.class);
            Call<ArrayList<body_symptoms>> dataCall = get_data_from_retrofit.GET_BODY_SYMPTOMS(body_part_id);

            dataCall.enqueue(new Callback<ArrayList<body_symptoms>>() {
                @Override
                public void onResponse(Call<ArrayList<body_symptoms>> call, Response<ArrayList<body_symptoms>> response) {
                    ArrayList<body_symptoms> arrayList = response.body();
                    body_location_symptoms_live_data.setValue(arrayList);
                }

                @Override
                public void onFailure(Call<ArrayList<body_symptoms>> call, Throwable t) {
                    Log.d(TAG, "onFailure: " + t);
                }
            });

        });

        return body_location_symptoms_live_data;
    }


    public MutableLiveData<ArrayList<Item>> GET_BODY_DIAG(int body_part_id){
        executor.execute(() -> {

            get_data_from_retrofit = get_data_from_retrofit.retrofit.create(get_data_from_retrofit.class);
//            ArrayList<Integer> list = new ArrayList<>();
//            list.add(body_part_id);\
            String symptoms = "[" + Integer.toString(body_part_id) +"]";
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6InNyYnZlcm1hMTBAZ21haWwuY29tIiwicm9sZSI6IlVzZXIiLCJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9zaWQiOiI5MzQ4IiwiaHR0cDovL3NjaGVtYXMubWljcm9zb2Z0LmNvbS93cy8yMDA4LzA2L2lkZW50aXR5L2NsYWltcy92ZXJzaW9uIjoiMjAwIiwiaHR0cDovL2V4YW1wbGUub3JnL2NsYWltcy9saW1pdCI6Ijk5OTk5OTk5OSIsImh0dHA6Ly9leGFtcGxlLm9yZy9jbGFpbXMvbWVtYmVyc2hpcCI6IlByZW1pdW0iLCJodHRwOi8vZXhhbXBsZS5vcmcvY2xhaW1zL2xhbmd1YWdlIjoiZW4tZ2IiLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL2V4cGlyYXRpb24iOiIyMDk5LTEyLTMxIiwiaHR0cDovL2V4YW1wbGUub3JnL2NsYWltcy9tZW1iZXJzaGlwc3RhcnQiOiIyMDIxLTA3LTAxIiwiaXNzIjoiaHR0cHM6Ly9zYW5kYm94LWF1dGhzZXJ2aWNlLnByaWFpZC5jaCIsImF1ZCI6Imh0dHBzOi8vaGVhbHRoc2VydmljZS5wcmlhaWQuY2giLCJleHAiOjE2MjU1MTkxMDIsIm5iZiI6MTYyNTUxMTkwMn0.p3_QK0_6D8-5fdTZ8zrAQRBx49ZinrgFwUh66-0PmS8";
            Call<ArrayList<Item>> dataCall = get_data_from_retrofit.GET_BODY_DIAG(symptoms,"male", 2000, token, "json", "en-gb");

            dataCall.enqueue(new Callback<ArrayList<Item>>() {
                @Override
                public void onResponse(Call<ArrayList<Item>> call, Response<ArrayList<Item>> response) {
                    ArrayList<Item> arrayList = response.body();
                    body_diag_live_data.setValue(arrayList);
                }

                @Override
                public void onFailure(Call<ArrayList<Item>> call, Throwable t) {
                    Log.d(TAG, "onFailure: " + t);
                }
            });

        });

        return body_diag_live_data;
    }


}
