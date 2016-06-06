package com.example;

/**
 * Created by Paul Aranas on 6/4/2016.
 */
public class GardenData {
    private String titles;
    private String photos;
    private String thumbnails;
    private String creators;
    private String textBodies;

    public GardenData(String gardenTitles, String gardenPhotos, String gardenThumbnails, String gardenCreators, String gardenTextBodies) {
        titles = gardenTitles;
        photos = gardenPhotos;
        thumbnails = gardenThumbnails;
        creators = gardenCreators;
        textBodies = gardenTextBodies;
    }
}
