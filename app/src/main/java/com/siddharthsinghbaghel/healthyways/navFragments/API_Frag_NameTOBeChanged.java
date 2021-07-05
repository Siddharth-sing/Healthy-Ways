package com.siddharthsinghbaghel.healthyways.navFragments;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.preference.MultiSelectListPreference;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.siddharthsinghbaghel.healthyways.R;
import com.siddharthsinghbaghel.healthyways.adapter.api_recycler_adapter;
import com.siddharthsinghbaghel.healthyways.pojo.Item;
import com.siddharthsinghbaghel.healthyways.pojo.body_locations;
import com.siddharthsinghbaghel.healthyways.pojo.body_symptoms;
import com.siddharthsinghbaghel.healthyways.viewmodels.API_Frag_NameTOBeChanged_ViewModel;

import java.util.ArrayList;
import java.util.List;

public class API_Frag_NameTOBeChanged extends Fragment {

    private String TAG = "TAG";
    private ArrayAdapter<String> aa;
    private ArrayAdapter<String> aa1;
    private ArrayAdapter<String> aa2;

    private ArrayList<String> nameList;
    private ArrayList<body_locations> body_locationsArrayList;
    private ArrayList<body_locations> body_locationsArrayList1;
    private ArrayList<body_symptoms> body_locationsArrayList2;

    private RecyclerView recyclerView;

    private api_recycler_adapter api_recycler_adapter;

    private final ArrayList<Item> itemList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.api_name_to_be_changed,container,false);
        API_Frag_NameTOBeChanged_ViewModel mViewModel = new ViewModelProvider(getActivity()).get(API_Frag_NameTOBeChanged_ViewModel.class);

        recyclerView = view.findViewById(R.id.recyclerView);

        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(false);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(mLayoutManager);

        Spinner spin = (Spinner) view.findViewById(R.id.spinner);
        Spinner spin1 = (Spinner) view.findViewById(R.id.spinner1);
        Spinner spin2 = (Spinner) view.findViewById(R.id.spinner2);

        Observer<ArrayList<body_locations>> observer1 = new Observer<ArrayList<body_locations>>() {

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onChanged(ArrayList<body_locations> body_locations) {
                ArrayList<String> stringList = new ArrayList<>();

                body_locationsArrayList1 = body_locations;

                if(body_locations != null){
                    for (int i = 0 ; i < body_locations.size() ; i++) {
                        stringList.add(body_locations.get(i).getName());
                    }
                    Log.d(TAG, "onChanged: hello  " + stringList);
                    aa1 = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item,stringList);
                    aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin1.setAdapter(aa1);

                }

            }
        };

        Observer<ArrayList<body_symptoms>> observer2 = new Observer<ArrayList<body_symptoms>>() {
            @Override
            public void onChanged(ArrayList<body_symptoms> body_symptoms) {
                ArrayList<String> stringList = new ArrayList<>();

                body_locationsArrayList2 = body_symptoms;

                if(body_symptoms != null){
                    for (int i = 0 ; i < body_symptoms.size() ; i++) {
                        stringList.add(body_symptoms.get(i).getName());
                    }
                    Log.d(TAG, "onChanged: hello  " + stringList);
                    aa2 = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item,stringList);
                    aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(aa2);

                }
            }
        };

        Observer<ArrayList<Item>> observer3 = new Observer<ArrayList<Item>>() {
            @Override
            public void onChanged(ArrayList<Item> items) {
                itemList.clear();
                itemList.addAll(items);
                if (api_recycler_adapter == null){
                    api_recycler_adapter = new api_recycler_adapter(itemList,getContext());
                    recyclerView.setAdapter(api_recycler_adapter);
                } else {
                    api_recycler_adapter.notifyDataSetChanged();
                }
            }
        };

        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(body_locationsArrayList != null){
                    mViewModel.GET_BODY_DIAG(body_locationsArrayList2.get(i).getID()).observe(getViewLifecycleOwner(), observer3);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(body_locationsArrayList != null){
                    mViewModel.GET_BODY_SYMPTOMS(body_locationsArrayList1.get(i).getID()).observe(getViewLifecycleOwner(), observer2);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (body_locationsArrayList != null) {
                    mViewModel.GET_BODY_LOCATION(body_locationsArrayList.get(i).getID()).observe(getViewLifecycleOwner(),observer1);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        Observer<ArrayList<body_locations>> observer = new Observer<ArrayList<body_locations>>() {

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onChanged(ArrayList<body_locations> body_locations) {
                ArrayList<String> stringList = new ArrayList<>();
                body_locationsArrayList = body_locations;

                if(body_locations != null){

                    for (int i = 0 ; i < body_locations.size() ; i++) {
                        stringList.add(body_locations.get(i).getName());
                    }
                    Log.d(TAG, "onChanged: " + stringList);
                    if (aa == null) {
                        aa = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item,stringList);
                        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spin.setAdapter(aa);
                    } else {
                        aa.notifyDataSetChanged();
                    }

                }

            }
        };
        //Setting the ArrayAdapter data on the Spinner
        mViewModel.GET_BODY_LOCATIONS().observe(getViewLifecycleOwner(),observer);
        return view;
    }

}
