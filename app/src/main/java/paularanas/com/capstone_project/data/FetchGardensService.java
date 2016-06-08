package paularanas.com.capstone_project.data;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.example.paul.myapplication.backend.gardensApi.GardensApi;
import com.example.paul.myapplication.backend.gardensApi.model.GardenData;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;
import java.util.ArrayList;


// Created by Paul Aranas on 6/5/2016.

public class FetchGardensService extends IntentService {

    public FetchGardensService(String name) {
        super(name);
    }


    @Override
    protected void onHandleIntent(Intent intent) {

        //set up app engine
        GardensApi.Builder builder = new GardensApi.Builder(AndroidHttp.newCompatibleTransport(),
                new AndroidJsonFactory(), null).setRootUrl("http://10.0.2.2:8080/_ah/api")
                .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                    @Override
                    public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                        abstractGoogleClientRequest.setDisableGZipContent(true);
                    }
                });


        GardensApi myApiService = builder.build();
        //Todo: send data result to MainGridFragment
        try {
            ArrayList<GardenData> result = (ArrayList<GardenData>) myApiService.showGardens().execute().getData();
        } catch (IOException e)

        {
            Log.e("tag", e.getMessage());
        }

    }
}

