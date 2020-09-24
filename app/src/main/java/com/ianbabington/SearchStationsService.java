package com.ianbabington;

import android.content.Context;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.ianbabington.transport.database.Station;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class SearchStationsService {

    /**
     * Gets from the rest api a list of stations which match the search
     * description entered by the user.
     * @param searchTerm
     * @return
     */
    public static synchronized List<Station> getStations(Context context, String searchTerm, List<Station> results){
        AndroidNetworking.initialize(context);
        AndroidNetworking.get("https://www.metlink.org.nz/api/v1/StopSearch/" + searchTerm)
            .build()
            .getAsJSONArray(new JSONArrayRequestListener() {
                @Override
                public void onResponse(JSONArray response) {
                    //TODO Replace with a stream when can find a way to convert into list
                    List<Station> searchResults = new ArrayList<Station>();
                    for(int i = 0; i<response.length(); i++){
                        try {
                            JSONObject jsonStation = response.getJSONObject(i);
                            Station station = new Station();
                            station.setStationID(jsonStation.getInt("ID"));
                            station.setStationNumber(jsonStation.getString("Sms"));
                            station.setStationName(jsonStation.getString("Name"));
                            searchResults.add(station);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    results.clear();
                    results.addAll(searchResults);
                }
                //TODO show toast or something?
                @Override
                public void onError(ANError anError) {
                    //Something
                    results.clear();
                }
            });
        return results;
    }

}
