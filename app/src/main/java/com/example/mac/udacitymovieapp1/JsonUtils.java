package com.example.mac.udacitymovieapp1;

import android.util.Log;

import com.example.mac.udacitymovieapp1.model.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mac on 5/02/18.
 */

public class JsonUtils {

    private static final String LOG_TAG= JsonUtils.class.getName();

    public JsonUtils() throws JSONException{
    }

    /**
     * Returns new URL object from the given string URL.
     */
    public static URL createUrl(String stringUrl){
        URL url=null;
        try{
            url=new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e("LOG_TAG", "Problem building the url", e);

        }
        return url;
    }


    public static List<String> parseMovieJson(String json) {

        String image_link = null;
        String movieName = null;
        List<String> extraction = null;

        try {
            JSONObject rootObject = new JSONObject(json);
            JSONArray jsonResultsArray = new JSONArray("results");
            extraction = new ArrayList<>();

            for (int i = 0; i < jsonResultsArray.length(); i++) {
                image_link = jsonResultsArray.getString(i);

                if (rootObject.has("poster_path")) {
                    JSONObject image = rootObject.getJSONObject("poster_path");
                }

                if (rootObject.has("original_title")) {
                    JSONObject movieTitle = rootObject.getJSONObject("original_title");

                }

                Movie movie = new Movie(image_link, movieName);
                extraction.add(String.valueOf(movie));

            }
        } catch (JSONException e) {
            Log.e("QueryUtils", "Problem parsing the news JSON results", e);
        }
        return extraction;
    }

    public static List<String> fetchMovieList(String urlString){
        URL url = createUrl(urlString);
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parseMovieJson(jsonResponse);
    }

    /**
     * Make an HTTP request to the given URL and return a String as the response.
     */
    public static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";

        // If the URL is null, then return early.
        if (url == null) {
            return jsonResponse;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // If the request was successful (response code 200),
            // then read the input stream and parse the response.
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem retrieving the earthquake JSON results.", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                // Closing the input stream could throw an IOException, which is why
                // the makeHttpRequest(URL url) method signature specifies than an IOException
                // could be thrown.
                inputStream.close();
            }
        }
        return jsonResponse;
    }


    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }



}
