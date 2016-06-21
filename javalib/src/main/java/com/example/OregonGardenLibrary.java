package com.example;

import java.util.ArrayList;

/**
 * Created by Paul Aranas on 6/4/2016.
 */
public class OregonGardenLibrary {

    private ArrayList<GardenData> gardenInfo;
    private String[] gardenTitlesArray = new String[23];
    private String[] gardenPhotosArray = new String[23];
    private String[] gardenThumbnailsArray = new String[23];
    private String[] gardenCreatorsArray = new String[23];
    private String[] gardenTextBodiesArray = new String[23];

    //Todo: Add Garden Data
    public OregonGardenLibrary() {
        //garden titles
        gardenTitlesArray[0] = "Amazing Water Garden";
        gardenTitlesArray[1] = "Axis Fountain";
        gardenTitlesArray[2] = "Axis Garden";
        gardenTitlesArray[3] = "Ball Horticulture Trial Garden";
        gardenTitlesArray[4] = "Bosque";
        gardenTitlesArray[5] = "Children's Garden";
        gardenTitlesArray[6] = "Conifer Garden";
        gardenTitlesArray[7] = "Home Demonstration Garden";
        gardenTitlesArray[8] = "Honor Garden";
        gardenTitlesArray[9] = "Lewis and Clark Garden ";
        gardenTitlesArray[10] = "Medicinal Garden";
        gardenTitlesArray[11] = "Northwest Garden";
        gardenTitlesArray[12] = "Oak Grove";
        gardenTitlesArray[13] = "Pet Friendly Garden";
        gardenTitlesArray[14] = "Proven Winners Trial Garden";
        gardenTitlesArray[15] = "Rediscovery Forest";
        gardenTitlesArray[16] = "Rose Garden";
        gardenTitlesArray[17] = "Rose Petal Fountain";
        gardenTitlesArray[18] = "Sensory Garden";
        gardenTitlesArray[19] = "Silverton Market Garden";
        gardenTitlesArray[20] = "Train Garden";
        gardenTitlesArray[21] = "Tropical House";
        gardenTitlesArray[22] = "Wetlands";


        //garden photos
        gardenThumbnailsArray[0] = "https://storage.googleapis.com/capstoneproject_images/amazing-water-garden488.png";
        gardenThumbnailsArray[1] = "https://storage.googleapis.com/capstoneproject_images/axisfountain449.png";
        gardenThumbnailsArray[2] = "https://storage.googleapis.com/capstoneproject_images/Axis-Garden488.png";
        gardenThumbnailsArray[3] = "https://storage.googleapis.com/capstoneproject_images/ball-trial-garden488.png";
        gardenThumbnailsArray[4] = "https://storage.googleapis.com/capstoneproject_images/bosque488.png";
        gardenThumbnailsArray[5] = "https://storage.googleapis.com/capstoneproject_images/children-garden488.png";
        gardenThumbnailsArray[6] = "https://storage.googleapis.com/capstoneproject_images/conifer-garden488.png";
        gardenThumbnailsArray[7] = "https://storage.googleapis.com/capstoneproject_images/home-demo-garden488.png";
        gardenThumbnailsArray[8] = "https://storage.googleapis.com/capstoneproject_images/honor-garden488.png";
        gardenThumbnailsArray[9] = "https://storage.googleapis.com/capstoneproject_images/lewis-clark-garden488.png";
        gardenThumbnailsArray[10] = "https://storage.googleapis.com/capstoneproject_images/medicinal-garden488.png";
        gardenThumbnailsArray[11] = "https://storage.googleapis.com/capstoneproject_images/northwest-garden488.png";
        gardenThumbnailsArray[12] = "https://storage.googleapis.com/capstoneproject_images/oak-grove488.png";
        gardenThumbnailsArray[13] = "https://storage.googleapis.com/capstoneproject_images/pet-friendly-garden488.png";
        gardenThumbnailsArray[14] = "https://storage.googleapis.com/capstoneproject_images/proven-winners-garden487.png";
        gardenThumbnailsArray[15] = "https://storage.googleapis.com/capstoneproject_images/rediscovery-forest488.png";
        gardenThumbnailsArray[16] = "https://storage.googleapis.com/capstoneproject_images/rose-garden.png";
        gardenThumbnailsArray[17] = "https://storage.googleapis.com/capstoneproject_images/rose-petal-fountain488.png";
        gardenThumbnailsArray[18] = "https://storage.googleapis.com/capstoneproject_images/sensory-garden488.png";
        gardenThumbnailsArray[19] = "https://storage.googleapis.com/capstoneproject_images/silverton-market-garden488.png";
        gardenThumbnailsArray[20] = "https://storage.googleapis.com/capstoneproject_images/train-garden488.png";
        gardenThumbnailsArray[21] = "https://storage.googleapis.com/capstoneproject_images/tropical-house488.png";
        gardenThumbnailsArray[22] = "https://storage.googleapis.com/capstoneproject_images/wetlands488.png";


        //garden thumbnails
        gardenPhotosArray[0] = "";
        gardenPhotosArray[1] = "";
        gardenPhotosArray[2] = "";
        gardenPhotosArray[3] = "";
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