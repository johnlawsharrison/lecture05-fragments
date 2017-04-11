package edu.uw.fragmentdemo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import static edu.uw.fragmentdemo.MovieDownloader.downloadMovieData;
import static edu.uw.fragmentdemo.MoviesFragment.newInstance;
import static edu.uw.fragmentdemo.R.id.listView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //respond to search button clicking
    public void handleSearchClick(View v){
        EditText text = (EditText)findViewById(R.id.txtSearch);
        String searchTerm = text.getText().toString();

        // create the fragment
        MoviesFragment fragment = MoviesFragment.newInstance(searchTerm);

        // create a fragment manager, in order to access the fragment controller
        FragmentManager fm = getSupportFragmentManager();

        FragmentTransaction ft = fm.beginTransaction();
        // specify desired transactions
        ft.replace(R.id.container, fragment, "MovieFragment");
        // commit the transaction
        ft.commit();
    }

}
