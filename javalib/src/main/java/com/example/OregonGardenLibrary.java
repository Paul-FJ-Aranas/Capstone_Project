package com.example;

import java.util.ArrayList;

/**
 * Created by Paul Aranas on 6/4/2016.
 */
public class OregonGardenLibrary {

    private ArrayList<GardenData> gardenInfo;
    private String[] gardenTitlesArray = new String[4];
    private String[] gardenPhotosArray = new String[4];
    private String[] gardenThumbnailsArray = new String[4];
    private String[] gardenCreatorsArray = new String[4];
    private String[] gardenTextBodiesArray = new String[4];

    //Todo: Add Garden Data
    public OregonGardenLibrary() {
        //garden titles
        gardenTitlesArray[0] = "Sample Garden One";
        gardenTitlesArray[1] = "Sample Garden Two";
        gardenTitlesArray[2] = "Sample Garden Three";
        gardenTitlesArray[3] = "Sample Garden Four";
        //garden photos
        gardenPhotosArray[0] = "https://storage.googleapis.com/capstoneproject_images/Oregon.jpg";
        gardenPhotosArray[1] = "https://storage.googleapis.com/capstoneproject_images/Oregon.jpg";
        gardenPhotosArray[2] = "https://storage.googleapis.com/capstoneproject_images/Oregon.jpg";
        gardenPhotosArray[3] = "https://storage.googleapis.com/capstoneproject_images/Oregon.jpg";
        //garden thumbnails
        gardenThumbnailsArray[0] = "https://storage.googleapis.com/capstoneproject_images/Oregon.jpg";
        gardenThumbnailsArray[1] = "https://storage.googleapis.com/capstoneproject_images/Oregon.jpg";
        gardenThumbnailsArray[2] = "https://storage.googleapis.com/capstoneproject_images/Oregon.jpg";
        gardenThumbnailsArray[3] = "https://storage.googleapis.com/capstoneproject_images/Oregon.jpg";
        //garden creators
        gardenCreatorsArray[0] = "Sample Garden Creator1";
        gardenCreatorsArray[1] = "Sample Garden Creator2";
        gardenCreatorsArray[2] = "Sample Garden Creator3";
        gardenCreatorsArray[3] = "Sample Garden Creator4";
        //garden text bodies
        gardenTextBodiesArray[0] = "This is sample text for a garden body field1.";
        gardenTextBodiesArray[1] = "This is sample text for a garden body field2.";
        gardenTextBodiesArray[2] = "This is sample text for a garden body field3.";
        gardenTextBodiesArray[3] = "This is sample text for a garden body field4.";


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