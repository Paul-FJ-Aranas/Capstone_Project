/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.Paul.myapplication.backend;

import com.example.GardenData;
import com.example.OregonGardenLibrary;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "gardensApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.Paul.example.com",
                ownerName = "backend.myapplication.Paul.example.com",
                packagePath = ""
        )
)
public class GardensEndpoint {

    @ApiMethod(name = "getGardens")
    public List<Gardens> getGardens() {

        OregonGardenLibrary libraryData = new OregonGardenLibrary();
        ArrayList<GardenData> gardenObjects = libraryData.getGardenDataList();
        ArrayList<Gardens> gardens = new ArrayList<>();

        for (GardenData data : gardenObjects) {

            Gardens garden = new Gardens();
            garden.setTitle(data.getTitle());
            garden.setPhoto(data.getPhoto());
            garden.setThumbnail(data.getThumbnail());
            garden.setCreator(data.getCreator());
            garden.setTextBody(data.getTextBody());
            gardens.add(garden);
        }
        return gardens;
    }

}
