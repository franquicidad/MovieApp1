package com.example.mac.udacitymovieapp1;

import com.example.mac.udacitymovieapp1.model.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mac on 5/02/18.
 */

public class JsonUtils {

    private static final String LOG_TAG= JsonUtils.class.getName();

    public JsonUtils() throws JSONException{
    }

    public static Movie parseMovieJson(String json){

        String image=null;
        String movieName=null;

        try {
            JSONObject rootObject=new JSONObject(json);
            JSONArray jsonResultsArray=new JSONArray("results");
            List<String> extraction=new ArrayList<>();

            for(int i = 0; i<jsonResultsArray.length(); i++){
                image =jsonResultsArray.getString(i);
                JSONObject imageObject= rootObject.getJSONObject("poster_path");
                extraction.add(image);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
    return
}
