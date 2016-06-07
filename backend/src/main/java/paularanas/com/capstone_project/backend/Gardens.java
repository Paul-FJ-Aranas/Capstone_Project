package paularanas.com.capstone_project.backend;

import com.example.GardenData;

import java.util.ArrayList;

/** The object model for the data we are sending through endpoints */
public class Gardens {

    private ArrayList<GardenData> gardenData;

    public ArrayList<GardenData> getData() {
        return gardenData;
    }

    public void setData(ArrayList<GardenData> data) {
        gardenData = data;
    }
}