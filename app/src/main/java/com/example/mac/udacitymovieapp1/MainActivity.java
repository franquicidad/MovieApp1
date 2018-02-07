package com.example.mac.udacitymovieapp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mac.udacitymovieapp1.model.Movie;
import com.wenchao.cardstack.CardStack;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static String BASE_KEY= "https://api.themoviedb.org/3/movie/popular?api_key=&language=en-US&page=1";

    private CardStack cardStack;
    private MovieMainAdapter movieAdapter;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initializeImages();
    }

    private void initializeImages() {

        cardStack=(CardStack)findViewById(R.id.card_stack);

        movieAdapter=new MovieMainAdapter(getApplicationContext(),new ArrayList<Movie>());

        cardStack.setAdapter(movieAdapter);
        cardStack.setContentResource(R.layout.card_design);
        cardStack.setStackMargin(20);

        cardStack.setListener(new CardStack.CardEventListener() {
            @Override
            public boolean swipeEnd(int i, float v) {
                return (v>300)?true:false;
            }

            @Override
            public boolean swipeStart(int i, float v) {
                return false;
            }

            @Override
            public boolean swipeContinue(int i, float v, float v1) {
                return false;
            }

            @Override
            public void discarded(int i, int i1) {

            }

            @Override
            public void topCardTapped() {

            }
        });

    }
}
