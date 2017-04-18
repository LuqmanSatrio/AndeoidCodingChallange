package com.example.luqmansatriowicaksono.androidcodingchallange;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String SimpsonsURL = "https://api.myjson.com/bins/10pvr7";

    private SimpsonsCharacterAdapter sAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView SimpsonsListView = (ListView) findViewById(R.id.simpsonslistview);

        sAdapter = new SimpsonsCharacterAdapter(this, new ArrayList<SimpsonsCharacter>());

        SimpsonsListView.setAdapter(sAdapter);

        // SimpsonsAsyncTask task = new SimpsonsAsnyctask();
        // task.execute(SimpsonsUL);
    }


    private class SimpsonsAsyncTask extends AsyncTask<String, Void, List<SimpsonsCharacter>>{

        @Override
        protected List<SimpsonsCharacter> doInBackground(String... params) {
            /* In this method the app will extract the JsonObject from the given URL and put it in a list.
            For overview purpose -> in a different class
             */
            return null;
        }

        @Override
        protected void onPostExecute(List<SimpsonsCharacter> result) {
            /* This method is for refreshing the UI.
            The onPostExecute method is needed because in the
            doInBackground method the UI cant be touched.(Different Thread)
             */
            sAdapter.addAll(result);
        }
    }

}
