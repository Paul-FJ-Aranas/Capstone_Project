package paularanas.com.capstone_project.ui;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import paularanas.com.capstone_project.R;

public class GardenMapFragment extends Fragment implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, View.OnClickListener, GoogleMap.OnCameraChangeListener, com.google.android.gms.location.LocationListener {

    private GoogleApiClient mGoogleApiClient;
    CameraPosition cameraPosition;
    GoogleMap mGoogleMap;
    private MapView mMapView;
    private static final LatLng NEBOUND = new LatLng(44.99728055, -122.78466111);
    private static final LatLng SWBOUND = new LatLng(44.9885833, -122.7846611);
    private static final LatLngBounds MAPBOUNDARY = new LatLngBounds(SWBOUND, NEBOUND);
    Marker locMark;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        MapsInitializer.initialize(getContext());


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_garden_map, container, false);

        Button startButton = (Button) view.findViewById(R.id.start_button);
        startButton.setOnClickListener(this);
        Typeface candaraFont = Typeface.createFromAsset(getContext().getAssets(), "fonts/Candara.ttf");
        startButton.setTypeface(candaraFont);


        mMapView = (MapView) view.findViewById(R.id.map);

        mMapView.onCreate(savedInstanceState);
        mMapView.getMapAsync(this);


        // instance of GoogleAPIClient.
        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(getContext())
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
            mGoogleApiClient.connect();
        }
        return view;
    }


    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }


    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();

        if (mGoogleApiClient != null && mGoogleApiClient.isConnected()) {
            mGoogleApiClient.disconnect();
            mGoogleApiClient = null;
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.setOnCameraChangeListener(this);
        mGoogleMap = googleMap;
        mapStartingPoint();


        googleMap.getUiSettings().setScrollGesturesEnabled(true);
        googleMap.getUiSettings().setMapToolbarEnabled(false);
        googleMap.getUiSettings().setZoomGesturesEnabled(true);
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        googleMap.getUiSettings().setMyLocationButtonEnabled(true);
        googleMap.getUiSettings().setCompassEnabled(true);


        LatLng mainEntrance = new LatLng(44.9948,
                -122.78903);
        googleMap.addMarker(new MarkerOptions()
                .position(mainEntrance).flat(true)
                .title("Main Entrance / Visitor Center"));


        LatLng naturalResourceEducationCenter = new LatLng(44.99511,
                -122.7888);
        googleMap.addMarker(new MarkerOptions()
                .position(naturalResourceEducationCenter).flat(true)
                .title("Natural Resource Education Center"));


        LatLng conifer = new LatLng(44.99377,
                -122.7895);
        googleMap.addMarker(new MarkerOptions()
                .position(conifer).flat(true)
                .title("Conifer Garden"));


        LatLng aestheticPruningDemonstration = new LatLng(44.99359,
                -122.78984);
        googleMap.addMarker(new MarkerOptions()
                .position(aestheticPruningDemonstration).flat(true)
                .title("Aesthetic Pruning Demonstration Garden"));

        LatLng axisGarden = new LatLng(44.9932138,
                -122.7899972);
        googleMap.addMarker(new MarkerOptions()
                .position(axisGarden).flat(true)
                .title("Axis Garden"));


        LatLng silvertonMarket = new LatLng(44.99277,
                -122.79021);
        googleMap.addMarker(new MarkerOptions()
                .position(silvertonMarket).flat(true)
                .title("Silverton Market Garden"));


        LatLng craftedVegetableDemonstration = new LatLng(44.99287,
                -122.79048);
        googleMap.addMarker(new MarkerOptions()
                .position(craftedVegetableDemonstration).flat(true)
                .title("Crafted Vegetable Demonstration Garden"));


        LatLng foundersSquare = new LatLng(44.99267,
                -122.79073);
        googleMap.addMarker(new MarkerOptions()
                .position(foundersSquare).flat(true)
                .title("Founder's Square"));

        LatLng rediscoveryForest = new LatLng(44.99221,
                -122.79077);
        googleMap.addMarker(new MarkerOptions()
                .position(rediscoveryForest).flat(true)
                .title("Rediscovery Forest"));


        LatLng lewisAndClark = new LatLng(44.99238,
                -122.79177);
        googleMap.addMarker(new MarkerOptions()
                .position(lewisAndClark).flat(true)
                .title("Lewis and Clark Garden"));


        LatLng oakGrove = new LatLng(44.99303,
                -122.792);
        googleMap.addMarker(new MarkerOptions()
                .position(oakGrove).flat(true)
                .title("Oak Grove"));


        LatLng northwestGarden = new LatLng(44.99333,
                -122.79191);
        googleMap.addMarker(new MarkerOptions()
                .position(northwestGarden).flat(true)
                .title("Northwest Garden"));


        LatLng childrensGarden = new LatLng(44.99317,
                -122.79076);
        googleMap.addMarker(new MarkerOptions()
                .position(childrensGarden).flat(true)
                .title("Children's Garden"));

        LatLng trainGarden = new LatLng(44.99339,
                -122.79095);
        googleMap.addMarker(new MarkerOptions()
                .position(trainGarden).flat(true)
                .title("Train Garden"));

        LatLng bosque = new LatLng(44.99401,
                -122.79067);
        googleMap.addMarker(new MarkerOptions()
                .position(bosque).flat(true)
                .title("Bosque"));


        LatLng homeCompostingCenter = new LatLng(44.99549,
                -122.78965);
        googleMap.addMarker(new MarkerOptions()
                .position(homeCompostingCenter).flat(true)
                .title("Home Composting Center"));


        LatLng provenWinners = new LatLng(44.99563,
                -122.78948);
        googleMap.addMarker(new MarkerOptions()
                .position(provenWinners).flat(true)
                .title("Proven Winners Trial Garden"));


        LatLng edible = new LatLng(44.99528,
                -122.78944);
        googleMap.addMarker(new MarkerOptions()
                .position(edible).flat(true)
                .title("Edible Garden"));

        LatLng amazingWater = new LatLng(44.99424,
                -122.78979);
        googleMap.addMarker(new MarkerOptions()
                .position(amazingWater).flat(true)
                .title("Amazing Water Garden"));


        LatLng exit = new LatLng(44.99497,
                -122.78906);
        googleMap.addMarker(new MarkerOptions()
                .position(exit).flat(true)
                .title("Exit"));
//
        LatLng handicappedParking = new LatLng(44.99487, -122.78804);
        googleMap.addMarker(new MarkerOptions()
                .position(handicappedParking).flat(true)
                .title("Handicapped Parking"));

        LatLng parking = new LatLng(44.99507, -122.78808);
        googleMap.addMarker(new MarkerOptions()
                .position(parking).flat(true)
                .title("Parking Lot"));

        LatLng resortEntrance = new LatLng(44.99176,
                -122.7881);
        googleMap.addMarker(new MarkerOptions()
                .position(resortEntrance).flat(true)
                .title("Resort Entrance / Lobby"));

        LatLng resortParkingLot = new LatLng(44.99171, -122.78804);
        googleMap.addMarker(new MarkerOptions()
                .position(resortParkingLot).flat(true)
                .title("Resort Parking Lot"));

        LatLng gordonHouse = new LatLng(44.99631, -122.79168);
        googleMap.addMarker(new MarkerOptions()
                .position(gordonHouse).flat(true)
                .title("Gordon House"));


        LatLng gordonHouseParking = new LatLng(44.99575, -122.79262);
        googleMap.addMarker(new MarkerOptions()
                .position(gordonHouseParking).flat(true)
                .title("Gordon House Parking"));

        LatLng gordonHouseAndEventParking = new LatLng(44.99555, -122.79109);
        googleMap.addMarker(new MarkerOptions()
                .position(gordonHouseAndEventParking).flat(true)
                .title("Event and Gordon House Parking"));

        LatLng wetlands = new LatLng(44.99378, -122.78926);
        googleMap.addMarker(new MarkerOptions()
                .position(wetlands).flat(true)
                .title("Wetlands"));


        LatLng rosePetalFountain = new LatLng(44.99439, -122.79099);
        googleMap.addMarker(new MarkerOptions()
                .position(rosePetalFountain).flat(true)
                .title("Rose Petal Fountain"));


        LatLng honorGarden = new LatLng(44.99453, -122.7905);
        googleMap.addMarker(new MarkerOptions()
                .position(honorGarden).flat(true)
                .title("Honor Garden"));

        LatLng homeDemoGardens = new LatLng(44.99506, -122.78954);
        googleMap.addMarker(new MarkerOptions()
                .position(homeDemoGardens).flat(true)
                .title("Home Demo Gardens"));
        LatLng fuchsiaDisplayGarden = new LatLng(44.99494, -122.78959);
        googleMap.addMarker(new MarkerOptions()
                .position(fuchsiaDisplayGarden).flat(true)
                .title("Fuchsia Display Garden"));

        LatLng medicinalGarden = new LatLng(44.99558, -122.78925);
        googleMap.addMarker(new MarkerOptions()
                .position(medicinalGarden).flat(true)
                .title("Medicinal Garden"));

        LatLng schmidtPavilion = new LatLng(44.99516, -122.79047);
        googleMap.addMarker(new MarkerOptions()
                .position(schmidtPavilion).flat(true)
                .title("Frank Schmidt Jr. Pavilion"));

        LatLng tropicalHouse = new LatLng(44.99532, -122.79083);
        googleMap.addMarker(new MarkerOptions()
                .position(tropicalHouse).flat(true)
                .title("Tropical House"));

        LatLng roseGarden = new LatLng(44.99516, -122.79145);
        googleMap.addMarker(new MarkerOptions()
                .position(roseGarden).flat(true)
                .title("Rose Garden"));

        LatLng petFriendlyGarden = new LatLng(44.99484, -122.79164);
        googleMap.addMarker(new MarkerOptions()
                .position(petFriendlyGarden).flat(true)
                .title("Pet Friendly Garden"));

        LatLng fireSafetyHouse = new LatLng(44.99442, -122.79133);
        googleMap.addMarker(new MarkerOptions()
                .position(fireSafetyHouse).flat(true)
                .title("Fire Safety House"));

        LatLng droughtTolerantGarden = new LatLng(44.99429, -122.79116);

        googleMap.addMarker(new MarkerOptions()
                .position(droughtTolerantGarden).flat(true)
                .title("Drought Tolerant Garden"));

        LatLng axisFountain = new LatLng(44.99320, -122.78981);
        googleMap.addMarker(new MarkerOptions()
                .position(axisFountain).flat(true)
                .title("Axis Fountain"));

        LatLng sensoryGarden = new LatLng(44.99474, -122.79025);
        googleMap.addMarker(new MarkerOptions()
                .position(sensoryGarden).flat(true)
                .title("Sensory Garden"));


        LatLng ballHorticultureTrialGarden = new LatLng(44.99297, -122.79013);
        googleMap.addMarker(new MarkerOptions()
                .position(ballHorticultureTrialGarden).flat(true)
                .title("Ball Horticulture Trial Garden"));

        LatLng ecoRoof = new LatLng(44.99468, -122.78985);
        googleMap.addMarker(new MarkerOptions()
                .position(ecoRoof).flat(true)
                .title("Eco-Roof"));

        LatLng teufelAmphitheater = new LatLng(44.99462, -122.79207);
        googleMap.addMarker(new MarkerOptions()
                .position(teufelAmphitheater).flat(true)
                .title("Teufel Amphitheater"));


    }

    public void mapStartingPoint() {
        LatLng center = new LatLng(44.99487, -122.78979);

        cameraPosition =
                new CameraPosition.Builder()
                        .target(center)
                        .zoom(17.00f)
                        .tilt(90)
                        .build();
        mGoogleMap.animateCamera(
                CameraUpdateFactory.newCameraPosition(cameraPosition),
                500,
                null);


    }


    @Override
    public void onConnected(@Nullable Bundle bundle) {
        LocationRequest mLocationRequest = LocationRequest.create();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setInterval(1000);

        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(
                mGoogleApiClient, mLocationRequest, this);
    }


    public void onStart() {
        mGoogleApiClient.connect();
        super.onStart();
    }

    public void onStop() {
        mGoogleApiClient.disconnect();
        super.onStop();
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }


    @Override
    public void onClick(View view) {

        mapStartingPoint();

    }


    @Override
    public void onCameraChange(CameraPosition cameraPosition) {
        if (MAPBOUNDARY.contains(mGoogleMap.getCameraPosition().target)) {
            return;
        }

        double x = mGoogleMap.getCameraPosition().target.longitude;
        double y = mGoogleMap.getCameraPosition().target.latitude;

        double maxX = MAPBOUNDARY.northeast.longitude;
        double maxY = MAPBOUNDARY.northeast.latitude;
        double minX = MAPBOUNDARY.southwest.longitude;
        double minY = MAPBOUNDARY.southwest.latitude;

        if ((x < minX) || (x > maxX) || (y < minY) || (y > maxY)) {

            mGoogleMap.animateCamera(CameraUpdateFactory.newLatLng(new LatLng(44.99317,
                    -122.79076)));
        }

    }


    @Override
    public void onLocationChanged(Location location) {


        if (locMark != null) {
            locMark.remove();
        }
        Double lat = location.getLatitude();
        Double lng = location.getLongitude();
        LatLng latLng = new LatLng(lat, lng);

        MarkerOptions locationMarkOptions = new MarkerOptions()
                .position(latLng).title("You are here").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));

        locMark = mGoogleMap.addMarker(locationMarkOptions);
        locMark.setPosition(latLng);

    }



}



