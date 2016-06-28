package paularanas.com.capstone_project.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import paularanas.com.capstone_project.R;

public class GardenMapActivity extends AppCompatActivity
        implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private GoogleApiClient mGoogleApiClient;
    CameraPosition cameraPosition;
    GoogleMap mGoogleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garden_map);

        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);


        mapFragment.getMapAsync(this);


        // instance of GoogleAPIClient.
        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }
    }

    public void goToFullView(View view) {
        mapStartingPoint();

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;
        mapStartingPoint();


        googleMap.getUiSettings().setScrollGesturesEnabled(false);
        googleMap.getUiSettings().setMapToolbarEnabled(false);
        googleMap.getUiSettings().setZoomGesturesEnabled(false);
        googleMap.getUiSettings().setZoomControlsEnabled(false);
        googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        googleMap.getUiSettings().setMyLocationButtonEnabled(true);


        LatLng mainEntrance = new LatLng(44.9948,
                -122.78903);
        final Marker mainEntranceMarker = googleMap.addMarker(new MarkerOptions()
                .position(mainEntrance)
                .title("Main Entrance"));


        LatLng naturalResourceEducationCenter = new LatLng(44.99511,
                -122.7888);
        final Marker naturalResourceEdCenterMarker = googleMap.addMarker(new MarkerOptions()
                .position(naturalResourceEducationCenter)
                .title("Natural Resource Education Center"));


        LatLng conifer = new LatLng(44.99377,
                -122.7895);
        final Marker coniferMarker = googleMap.addMarker(new MarkerOptions()
                .position(conifer)
                .title("Conifer Garden"));


        LatLng aestheticPruningDemonstration = new LatLng(44.99359,
                -122.78984);
        final Marker aestheticPruningMarker = googleMap.addMarker(new MarkerOptions()
                .position(aestheticPruningDemonstration)
                .title("Aesthetic Pruning Demonstration Garden"));

        LatLng axis = new LatLng(44.99298,
                -122.78983);
        final Marker axisMarker = googleMap.addMarker(new MarkerOptions()
                .position(axis)
                .title("Axis Garden"));


        LatLng silvertonMarket = new LatLng(44.99302,
                -122.7902);
        final Marker silvertonMarketMarker = googleMap.addMarker(new MarkerOptions()
                .position(silvertonMarket)
                .title("Silverton Market Garden"));


        LatLng craftedVegetableDemonstration = new LatLng(44.99287,
                -122.79048);
        final Marker craftedVegetableMarker = googleMap.addMarker(new MarkerOptions()
                .position(craftedVegetableDemonstration)
                .title("Crafted Vegetable Demonstration Garden"));


        LatLng foundersSquare = new LatLng(44.99267,
                -122.79073);
        final Marker foundersSquareMarker = googleMap.addMarker(new MarkerOptions()
                .position(foundersSquare)
                .title("Founder's Square"));

        LatLng rediscoveryForest = new LatLng(44.99221,
                -122.79077);
        final Marker rediscoveryForestMarker = googleMap.addMarker(new MarkerOptions()
                .position(rediscoveryForest)
                .title("Rediscovery Forest"));


        LatLng lewisAndClark = new LatLng(44.99238,
                -122.79177);
        final Marker lewisAndClarkMarker = googleMap.addMarker(new MarkerOptions()
                .position(lewisAndClark)
                .title("Lewis and Clark Garden"));


        LatLng oakGrove = new LatLng(44.99303,
                -122.792);
        final Marker oakGroveMarker = googleMap.addMarker(new MarkerOptions()
                .position(oakGrove)
                .title("Oak Grove"));


        LatLng northwestGarden = new LatLng(44.99333,
                -122.79191);
        final Marker northwestGardenMarker = googleMap.addMarker(new MarkerOptions()
                .position(northwestGarden)
                .title("Northwest Garden"));


        LatLng childrensGarden = new LatLng(44.99317,
                -122.79076);
        final Marker childrensGardenMarker = googleMap.addMarker(new MarkerOptions()
                .position(childrensGarden)
                .title("Children's Garden"));

        LatLng trainGarden = new LatLng(44.99339,
                -122.79095);
        final Marker trainGardenMarker = googleMap.addMarker(new MarkerOptions()
                .position(trainGarden)
                .title("Train Garden"));

        LatLng bosque = new LatLng(44.99401,
                -122.79067);
        final Marker bosqueMarker = googleMap.addMarker(new MarkerOptions()
                .position(bosque)
                .title("Bosque"));


        LatLng homeCompostingCenter = new LatLng(44.99549,
                -122.78965);
        final Marker homeCompostingMarker = googleMap.addMarker(new MarkerOptions()
                .position(homeCompostingCenter)
                .title("Home Composting Center"));


        LatLng provenWinners = new LatLng(44.99557,
                -122.78953);
        final Marker provenWinnersMarker = googleMap.addMarker(new MarkerOptions()
                .position(provenWinners)
                .title("Proven Winners Trial Garden"));


        LatLng edible = new LatLng(44.99528,
                -122.78944);
        final Marker edibleMarker = googleMap.addMarker(new MarkerOptions()
                .position(edible)
                .title("Edible Garden"));

        LatLng amazingWater = new LatLng(44.99424,
                -122.78979);
        final Marker amazingWaterMarker = googleMap.addMarker(new MarkerOptions()
                .position(amazingWater)
                .title("Amazing Water Garden"));

//recheck exit coordinates
       /* LatLng exit = new LatLng(44.99493,
                -122.789918);
        googleMap.addMarker(new MarkerOptions()
                .position(exit)
                .title("Exit")
                .snippet("Garden fun for the whole family")); */
        googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {

            @Override
            public boolean onMarkerClick(Marker arg0) {

                switch (arg0.getTitle()) {

                    case "Main Entrance":
                        zoomToSelectedPosition(arg0, 44.9948, -122.78903, mainEntranceMarker);
                        break;

                    case "Natural Resource Education Center":
                        zoomToSelectedPosition(arg0, 44.99511,
                                -122.7888, naturalResourceEdCenterMarker);
                        break;

                    case "Conifer Garden":
                        zoomToSelectedPosition(arg0, 44.99377,
                                -122.7895, coniferMarker);
                        break;
                    case "Aesthetic Pruning Demonstration Garden":
                        zoomToSelectedPosition(arg0,44.99359,
                                -122.78984 , aestheticPruningMarker);
                        break;
                    case "Axis Garden":
                        zoomToSelectedPosition(arg0,44.99298,
                                -122.78983 , axisMarker);
                        break;

                    case "Silverton Market Garden":
                        zoomToSelectedPosition(arg0,44.99302,
                                -122.7902, silvertonMarketMarker);
                        break;
                    case "Crafted Vegetable Demonstration Garden":
                        zoomToSelectedPosition(arg0,44.99287,
                                -122.79048, craftedVegetableMarker);
                        break;

                    case "Founder's Square":
                        zoomToSelectedPosition(arg0,44.99267,
                                -122.79073, foundersSquareMarker);
                        break;
//TODO: add latlng starting from here lat long
                    case "Rediscovery Forest":
                        zoomToSelectedPosition(arg0, 44.9948, -122.78903, rediscoveryForestMarker);
                        break;

                    case "Lewis and Clark Garden":
                        zoomToSelectedPosition(arg0, 44.9948, -122.78903, lewisAndClarkMarker);
                        break;
                    case "Oak Grove":
                        zoomToSelectedPosition(arg0, 44.9948, -122.78903, oakGroveMarker);
                        break;
                    case "Northwest Garden":
                        zoomToSelectedPosition(arg0, 44.9948, -122.78903, northwestGardenMarker);
                        break;

                    case "Children's Garden":
                        zoomToSelectedPosition(arg0, 44.9948, -122.78903, childrensGardenMarker);
                        break;

                    case "Train Garden":
                        zoomToSelectedPosition(arg0, 44.9948, -122.78903, trainGardenMarker);
                        break;

                    case "Bosque":
                        zoomToSelectedPosition(arg0, 44.9948, -122.78903, bosqueMarker);
                        break;

                    case "Home Composting Center":
                        zoomToSelectedPosition(arg0, 44.9948, -122.78903, homeCompostingMarker);
                        break;
                    case "Proven Winners Trial Garden":
                        zoomToSelectedPosition(arg0, 44.9948, -122.78903, provenWinnersMarker);
                        break;

                    case "Edible Garden":
                        zoomToSelectedPosition(arg0, 44.9948, -122.78903, edibleMarker);
                        break;

                    case "Amazing Water Garden":
                        zoomToSelectedPosition(arg0, 44.9948, -122.78903, amazingWaterMarker);
                        break;


                }

                return true;
            }

        });


    }

    public void zoomToSelectedPosition(Marker arg0, Double lat, Double lon, Marker locMark) {
        if (arg0.getTitle().equals("Main Entrance")) {
            LatLng center = new LatLng(lat,
                    lon);
            cameraPosition =
                    new CameraPosition.Builder()
                            .target(center)
                            .zoom(20.00f)
                            .tilt(40)
                            .build();
            mGoogleMap.animateCamera(
                    CameraUpdateFactory.newCameraPosition(cameraPosition),
                    500,
                    null);

            locMark.showInfoWindow();
        }
    }


    public void mapStartingPoint() {
        LatLng center = new LatLng(44.99359,
                -122.78984);
        cameraPosition =
                new CameraPosition.Builder()
                        .target(center)
                        .zoom(17.25f)
                        .tilt(40)
                        .build();

        mGoogleMap.animateCamera(
                CameraUpdateFactory.newCameraPosition(cameraPosition),
                500,
                null);

    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
     /*   mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                mGoogleApiClient);
        if (mLastLocation != null) {
            mLatitudeText.setText(String.valueOf(mLastLocation.getLatitude()));
            mLongitudeText.setText(String.valueOf(mLastLocation.getLongitude()));
        }*/
    }

    protected void onStart() {
        mGoogleApiClient.connect();
        super.onStart();
    }

    protected void onStop() {
        mGoogleApiClient.disconnect();
        super.onStop();
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }


}
