package com.ianbabington.adapter.transport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.ianbabington.SearchStationsService;
import com.ianbabington.transport.R;
import com.ianbabington.transport.database.Station;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StationAutoCompleteAdapter extends BaseAdapter implements Filterable {

    private static final int MAX_RESULTS = 3;
    private Context mContext;
    private static List<Station> results = new ArrayList<Station>();
//    private static Station testStation1 = new Station(1, "5000", "Courtney");
//    private static Station testStation2 = new Station(2, "5020", "Albert");
//    private static Station testStation3 = new Station(3, "5040", "Dixon");
//    private static Station testStation4 = new Station(4, "5060", "Lampton");
//    private static Station testStation5 = new Station(5, "5080", "Queens");

//    private static List<Station> mStations = Arrays.asList(testStation1, testStation2, testStation3);
//            testStation4, testStation5);




    public StationAutoCompleteAdapter(Context context) {
        mContext = context;
    }

    final private List<Station> mStations = new ArrayList<Station>();

    @Override
    public int getCount() {
        return results.size();
    }

    @Override
    public Object getItem(int position) {
        return results.get(position);
    }

    @Override
    public long getItemId(int position) {
        return results.get(position).getStationID();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(android.R.layout.select_dialog_item, parent, false);
        }
        TextView tv = (TextView) convertView;
        Station station = (Station) getItem(position);
        tv.setText(station.getStationName());
        return convertView;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                if(constraint != null) {
                    List<Station> results = new ArrayList<Station>();
                    SearchStationsService.getStations(mContext, constraint.toString(), mStations);
                    filterResults.values = mStations;
                    filterResults.count = mStations.size();
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults filterResults) {
                if (filterResults != null && filterResults.count > 0) {
                    results = (List<Station>) filterResults.values;
                    notifyDataSetChanged();
                } else {
                    notifyDataSetInvalidated();
                }

            }
        };
        return filter;
    }
}
