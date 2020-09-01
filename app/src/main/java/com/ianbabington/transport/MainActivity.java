package com.ianbabington.transport;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

//    private AutoCompleteTextView autocompleteSearch;
//    private AutoCompleteTextView autocompleteSearch2;
//    private static String[] OPTTIONS = new String[] {"4550", "4600", "5900", "7800"};
//    String[] fruits = {"Apple", "Banana", "Cherry", "Date", "Grape", "Kiwi", "Mango", "Pear"};

//    String[] restaurants = {"KFC", "Dominos",
//            "Pizza Hut",
//            "Burger King",
//            "Subway",
//            "Dunkin' Donuts",
//            "Starbucks",
//            "Cafe Coffee Day"
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        //Setup main
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
////                android.R.layout.simple_dropdown_item_1line,
//                android.R.layout.select_dialog_item,
//                fruits);
//        autocompleteSearch = findViewById(R.id.thisThing);
//        autocompleteSearch.setThreshold(1);
//        autocompleteSearch.setAdapter(adapter);

        //Setup frag
//        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
////                android.R.layout.simple_dropdown_item_1line,
//                android.R.layout.select_dialog_item, fruits);
//        ViewGroup root = (ViewGroup) this.getLayoutInflater().inflate(R.layout.fragment_home, null);
//        autocompleteSearch2 = root.findViewById(R.id.autoCompleteTextView66);
//        autocompleteSearch2.setThreshold(1);
//        autocompleteSearch2.setHint("Try this one");
//        autocompleteSearch2.setAdapter(adapter);
    }



}
