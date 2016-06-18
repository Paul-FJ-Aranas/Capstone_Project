package paularanas.com.capstone_project.data;

import android.app.IntentService;
import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.net.Uri;
import android.os.RemoteException;
import android.util.Log;

import com.example.paul.myapplication.backend.gardensApi.GardensApi;
import com.example.paul.myapplication.backend.gardensApi.model.Gardens;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


// Created by Paul Aranas on 6/5/2016.

public class FetchGardensService extends IntentService {

    public FetchGardensService() {
        super("FetchGardenService");

    }


    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d("TAG", "In onHandleIntent");
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

        try {
            List<Gardens> gardenDataResult = myApiService.getGardens().execute().getItems();

               ArrayList<ContentProviderOperation> gardencpbo = new ArrayList<ContentProviderOperation>();
             Uri dirUri = GardenContract.URI_GARDENS;
             gardencpbo.add(ContentProviderOperation.newDelete(dirUri).build());

            if (gardenDataResult != null) {
                ContentValues contentValues = new ContentValues();
                for (Gardens data : gardenDataResult) {

                    String title = (String) data.get("title");
                    String photo = (String) data.get("photo");
                    String thumbnail = (String) data.get("thumbnail");
                    String creator = (String) data.get("creator");
                    String textBody = (String) data.get("textBody");


                    contentValues.put(GardenContract.GardenTable.TITLE, title);
                    contentValues.put(GardenContract.GardenTable.PHOTO, photo);
                    contentValues.put(GardenContract.GardenTable.THUMBNAIL_PATH, thumbnail);
                    contentValues.put(GardenContract.GardenTable.CREATOR, creator);
                    contentValues.put(GardenContract.GardenTable.BODY, textBody);
                    gardencpbo.add(ContentProviderOperation.newInsert(dirUri).withValues(contentValues).build());
                }
                try {
                    getContentResolver().applyBatch(GardenContract.AUTHORITY, gardencpbo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                } catch (OperationApplicationException e) {
                    e.printStackTrace();
                }

            }




        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
