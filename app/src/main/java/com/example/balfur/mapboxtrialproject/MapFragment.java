package com.example.balfur.mapboxtrialproject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.Icon;
import com.mapbox.mapboxsdk.annotations.IconFactory;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;

public class MapFragment extends Fragment implements OnMapReadyCallback, MapboxMap.OnMarkerClickListener {

    private View view;
    private MapView mapView;

    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                                  Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Mapbox.getInstance(getActivity(), getString(R.string.access_token));
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_map, container, false);
        }
        mapView = (MapView) view.findViewById(R.id.mapView);
        mapView.getMapAsync(this);
        mapView.onCreate(savedInstanceState);

        return view;
    }

    public void onMapReady(MapboxMap mapboxMap) {

        mapboxMap.setOnMarkerClickListener(this);

        double lat = 40.73081;

        for(int i = 0; i < 10; i++) {
            lat += .001;

            Icon icon = IconFactory.getInstance(getContext()).fromResource(R.drawable.chimera_front);

            mapboxMap.addMarker(new MarkerOptions()
                    .position(new LatLng(lat, -73.99155))
                    .icon(icon)
                    .title("Marker: " + i)
                    .snippet("Snipped"));
        }
    }

    @Override
    public boolean onMarkerClick(@NonNull Marker marker) {
        Log.d("asdf", "onMarkerClick: " + marker.getTitle());
        return true;
    }

    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

}
