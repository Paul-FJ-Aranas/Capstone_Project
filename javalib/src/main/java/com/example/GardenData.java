package com.example;

/**
 * Created by Paul Aranas on 6/4/2016.
 */
public class GardenData {
    private int gardenId;
    private String title;
    private String photo;
    private String thumbnail;
    private String creator;
    private String textBody;

    public GardenData( String gardenTitle, String gardenPhoto, String gardenThumbnail, String gardenCreator, String gardenTextBodie,int ids ) {
        title = gardenTitle;
        photo = gardenPhoto;
        thumbnail = gardenThumbnail;
        creator = gardenCreator;
        textBody = gardenTextBodie;
        gardenId = ids;
    }


    public String getTitle() {
        return title;
    }

    public String getPhoto() {
        return photo;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getCreator() {
        return creator;
    }

    public String getTextBody() {
        return textBody;
    }

    public int getId() {
        return gardenId;
    }

}
