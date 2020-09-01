package com.ianbabington.transport.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.widget.AutoCompleteTextView;


import com.ianbabington.adapter.transport.StationAutoCompleteAdapter;
import com.ianbabington.transport.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private static AutoCompleteTextView autocompleteSearch;
    private static AutoCompleteTextView autocompleteSearchPlaces;
    private static String[] fruits = {"Apple", "Banana", "Cherry", "Date", "Grape", "Kiwi", "Mango", "Pear"};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        return root;
    }

    public void onViewCreated (View view,  Bundle savedInstanceState){
        //Setup fruit
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.select_dialog_item, fruits);
        autocompleteSearch = getView().findViewById(R.id.searchStopsHome);
        autocompleteSearch.setThreshold(1);
        autocompleteSearch.setAdapter(adapter);

        //Setup places
        StationAutoCompleteAdapter adapterPlaces = new StationAutoCompleteAdapter(getActivity());
        autocompleteSearchPlaces = getView().findViewById(R.id.searchStopsHomeAdapterTest);
        autocompleteSearchPlaces.setThreshold(1);
        autocompleteSearchPlaces.setAdapter(adapterPlaces);

    }

}
