package com.siddharthsinghbaghel.healthyways.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.siddharthsinghbaghel.healthyways.pojo.Item;
import com.siddharthsinghbaghel.healthyways.pojo.body_locations;
import com.siddharthsinghbaghel.healthyways.pojo.body_symptoms;
import com.siddharthsinghbaghel.healthyways.repository.GET_BODY_LOCATIONS_repository;

import java.util.ArrayList;

public class API_Frag_NameTOBeChanged_ViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<body_locations>> body_locations_live_data;
    private MutableLiveData<ArrayList<body_locations>> body_location_live_data;
    private MutableLiveData<ArrayList<body_symptoms>> body_symptoms_live_data;
    private MutableLiveData<ArrayList<Item>> body_diag_live_data;
    public static final String TAG = "TAG";
    private GET_BODY_LOCATIONS_repository mRepository;
    public API_Frag_NameTOBeChanged_ViewModel(@NonNull Application application) {
        super(application);
        mRepository = GET_BODY_LOCATIONS_repository.getInstance();
    }

    public MutableLiveData<ArrayList<body_locations>> GET_BODY_LOCATIONS(){
        body_locations_live_data = mRepository.GET_BODY_LOCATIONS();
        return body_locations_live_data;
    }

    public MutableLiveData<ArrayList<body_locations>> GET_BODY_LOCATION(int body_part_id){
        body_location_live_data = mRepository.GET_BODY_LOCATION(body_part_id);
        return body_location_live_data;
    }

    public MutableLiveData<ArrayList<body_symptoms>> GET_BODY_SYMPTOMS(int body_part_id){
        body_symptoms_live_data = mRepository.GET_BODY_SYMPTOMS(body_part_id);
        return body_symptoms_live_data;
    }

    public MutableLiveData<ArrayList<Item>> GET_BODY_DIAG(int body_part_id){
        body_diag_live_data = mRepository.GET_BODY_DIAG(body_part_id);
        return body_diag_live_data;
    }


}
