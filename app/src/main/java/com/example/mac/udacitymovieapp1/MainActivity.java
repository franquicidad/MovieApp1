package com.example.mac.udacitymovieapp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static String BASE_KEY= "https://api.themoviedb.org/3/movie/popular?api_key=7d51874568317dfd0c91db399be2bdec";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
