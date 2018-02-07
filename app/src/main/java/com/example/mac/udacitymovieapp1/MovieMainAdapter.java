package com.example.mac.udacitymovieapp1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.mac.udacitymovieapp1.model.Movie;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by mac on 6/02/18.
 */

public class MovieMainAdapter extends ArrayAdapter<Movie> {

    /** Constructor*/

    public MovieMainAdapter(Context context, List<Movie> objects) {
        super(context, 0, objects);
    }


    @Override
    public View getView(int position, View convertView,ViewGroup parent) {

        View view=convertView;

        if(view == null){
            view= LayoutInflater.from(getContext()).inflate(R.layout.card_design,parent,false);

        }

        Movie moviePosition = getItem(position);

        ImageView movieImage = (ImageView)view.findViewById(R.id.iCard_design);
        Log.e("TAG","Identificador"+moviePosition.getImage_link());

        if(!TextUtils.isEmpty(moviePosition.getImage_link())){
            Picasso.with(getContext()).load(moviePosition.getImage_link()).into(movieImage);
        }

        TextView movieTitle=(TextView)view.findViewById(R.id.movie_design_layout_title);
        movieTitle.setText(moviePosition.getMovieName());

        return view;

    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

}
