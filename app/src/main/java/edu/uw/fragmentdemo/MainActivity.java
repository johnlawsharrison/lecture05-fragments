package edu.uw.fragmentdemo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import static edu.uw.fragmentdemo.MovieDownloader.downloadMovieData;
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

        // create a fragment manager, in order to access the movies fragment controller
        FragmentManager fm = getSupportFragmentManager();

        // find the right fragment by its id (id of the containing FrameLayout)
        MoviesFragment fragment = (MoviesFragment)fm.findFragmentById(R.id.movieFragment);
        // call the download function on the fragment
        fragment.downloadMovieData(searchTerm);
    }

}
