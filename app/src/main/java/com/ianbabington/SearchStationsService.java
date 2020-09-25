package com.ianbabington;

import android.content.Context;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
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
    private static final String TAG = "SearchStationsService";

    //Get stations by search term, API requires at least 3 characters
    public static synchronized List<Station> getStations(Context context, String searchTerm){
        List<Station> results = new ArrayList<Station>();
        AndroidNetworking.initialize(context);

        //Create a synchronous request and run
        ANRequest request = AndroidNetworking
                .get("https://www.metlink.org.nz/api/v1/StopSearch/" + searchTerm).build();
        ANResponse<JSONArray> response = request.executeForJSONArray();
        if (response.isSuccess()) {
            JSONArray jsonStations = response.getResult();
            //Parse data, explain why lambda and for each doesn't work here
            for(int i = 0; i<jsonStations.length(); i++){
                try {
                    JSONObject jsonStation = jsonStations.getJSONObject(i);
                    Station station = new Station();
                    station.setStationID(jsonStation.getInt("ID"));
                    station.setStationNumber(jsonStation.getString("Sms"));
                    station.setStationName(jsonStation.getString("Name"));
                    results.add(station);
                //Handle errors parsing data
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else {
            //Handle error scenarios
            results.clear();
        }

//        Log.d(TAG, "getStations returns " + results.size() + " elements. 1st is " + results.get(0).getStationName());
        return results;
    }

}
