package com.example.mac.udacitymovieapp1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;


import com.example.mac.udacitymovieapp1.model.Movie;

import java.util.List;

/**
 * Created by mac on 6/02/18.
 */

public class MovieMainAdapter extends ArrayAdapter<Movie> {

    /** Constructor*/

    public MovieMainAdapter(Context context, int resource, List<Movie> objects) {
        super(context, resource, objects);
    }


    @Override
    public View getView(int position, View convertView,ViewGroup parent) {

        View view=convertView;

        ImageView Img = (ImageView)view.findViewById(R.id.iCard_design);

        Picasso.

    }
}
