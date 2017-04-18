package com.example.luqmansatriowicaksono.androidcodingchallange;

import android.text.TextUtils;

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
 * Created by luqmansatriowicaksono on 18.04.17.
 */

public class HttpHandler {

    private void HttpHandler() {
    }

    public static List<SimpsonsCharacter> fetchSimpsonsData(String requestUrl) {

        // Create URL object
        URL url = createUrl(requestUrl);

        // Perform HTTP request to the URL and receive a JSON response back
        String jsonResponse = null;

        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
        }

        // Extract relevant fields from the JSON response and create a list of SimpsonsCharacters
        List<SimpsonsCharacter> simpsonscharacters = extractFeatureFromJson(jsonResponse);

        // Return the list of SimpsonsCharacters
        return simpsonscharacters;
    }

    private static URL createUrl(String stringUrl) {

        URL url = null;

        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
        }
        return url;
    }


    private static String makeHttpRequest(URL url) throws IOException {

        String jsonResponse = "";


        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;

        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            inputStream = urlConnection.getInputStream();
            jsonResponse = readFromStream(inputStream);

        } catch (IOException e) {
        } finally {
                urlConnection.disconnect();
                inputStream.close();

        }
        return jsonResponse;
    }

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }

        return output.toString();
    }


    private static List<SimpsonsCharacter> extractFeatureFromJson(String jsonResponse) {
        if (TextUtils.isEmpty(jsonResponse)) {
            return null;
        }

        List<SimpsonsCharacter> SimpsonsCharacters = new ArrayList<>();

        try {
            JSONObject baseJsonResponse = new JSONObject(jsonResponse);
            JSONArray SimpsonsCharactersArray = baseJsonResponse.getJSONArray("persons");

            for (int i = 0; i < SimpsonsCharactersArray.length(); i++) {

                // Get a single SimpsonsCharacter at position i within the list of SimpsonsCharacters
                JSONObject currentCharacter = SimpsonsCharactersArray.getJSONObject(i);


                String Vorname = currentCharacter.getString("firstname");
                String Nachname = currentCharacter.getString("lastname");
                String imgURL = currentCharacter.getString("image");


                SimpsonsCharacters.add(new SimpsonsCharacter(Vorname, Nachname, imgURL));

                // Add the new SimpsonsCharacter to the list of SimpsonsCharacters.

            }

        } catch (JSONException j) {
        }
        return SimpsonsCharacters;
    }
}
