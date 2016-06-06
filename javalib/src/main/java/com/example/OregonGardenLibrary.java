package com.example;

import java.util.ArrayList;
/**
 * Created by Paul Aranas on 6/4/2016.
 */
public class OregonGardenLibrary {

    private ArrayList<GardenData> gardenInfo;
    private String[] gardenArray = new String[23];

    //Todo: Add Garden Data
    public OregonGardenLibrary() {
        //garden titles
        gardenArray[0] = "array";
        //garden photos
        gardenArray[1] = "array";
        //garden thumbnails
        gardenArray[2] = "array";
        //garden creators
        gardenArray[3] = "array";
        //garden text bodies
        gardenArray[4] = "array";


        gardenInfo = new ArrayList();
        for (int i = 0; i < gardenArray.length; i++) {
            GardenData data = new GardenData(gardenArray[0], gardenArray[1], gardenArray[2], gardenArray[3], gardenArray[4]);
            gardenInfo.add(data);
        }

    }

    public ArrayList<GardenData> getGardenDataList() {

        return gardenInfo;
    }
}