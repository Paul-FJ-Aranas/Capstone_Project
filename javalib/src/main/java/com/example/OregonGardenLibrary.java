package com.example;

import java.util.ArrayList;

/**
 * Created by Paul Aranas on 6/4/2016.
 */
public class OregonGardenLibrary {

    private ArrayList<GardenData> gardenInfo;
    private String[] gardenTitlesArray = new String[1];
    private String[] gardenPhotosArray = new String[1];
    private String[] gardenThumbnailsArray = new String[1];
    private String[] gardenCreatorsArray = new String[1];
    private String[] gardenTextBodiesArray = new String[1];

    //Todo: Add Garden Data
    public OregonGardenLibrary() {
        //garden titles
        gardenTitlesArray[0] = "Sample Garden One";
        //garden photos
        gardenPhotosArray[0] = "https://storage.googleapis.com/capstoneproject_images/Oregon.jpg";
        //garden thumbnails
        gardenThumbnailsArray[0] = "https://storage.googleapis.com/capstoneproject_images/Oregon.jpg";
        //garden creators
        gardenCreatorsArray[0] = "Sample Garden Creator";
        //garden text bodies
        gardenTextBodiesArray[0] = "This is sample text for a garden body field.";


        gardenInfo = new ArrayList();
        for (int i = 0; i < gardenTitlesArray.length; i++) {
            GardenData data = new GardenData(gardenTitlesArray[i], gardenPhotosArray[i], gardenThumbnailsArray[i], gardenCreatorsArray[i], gardenTextBodiesArray[i]);
            gardenInfo.add(data);
        }

    }

    public ArrayList<GardenData> getGardenDataList() {

        return gardenInfo;
    }
}