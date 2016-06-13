package com.example.Paul.myapplication.backend;

/** The object model for the data we are sending through endpoints */
public class Gardens {

    private String title;
    private String photo;
    private String thumbnail;
    private String creator;
    private String textBody;

    public Gardens() {

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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setTextBody(String textBody) {
        this.textBody = textBody;
    }
}