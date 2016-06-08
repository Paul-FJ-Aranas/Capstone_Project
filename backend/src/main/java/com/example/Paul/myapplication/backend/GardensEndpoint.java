/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.Paul.myapplication.backend;

import com.example.OregonGardenLibrary;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

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

    @ApiMethod(name = "showGardens")
    public Gardens showGardens() {
        Gardens gardens = new Gardens();
        gardens.setData(new OregonGardenLibrary().getGardenDataList());

        return gardens;
    }

}
