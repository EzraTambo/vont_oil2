package com.example.vontoil2

import android.location.Location
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.vontoil2.databinding.ActivityMaps2Binding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.Marker
import com.google.android.libraries.places.api.model.AutocompletePrediction
import com.google.android.libraries.places.api.net.PlacesClient
import com.mancj.materialsearchbar.MaterialSearchBar
import java.util.*

class servicedashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_servicedashboard)
    }

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMaps2Binding
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var placesClient: PlacesClient
    private lateinit var list: ArrayList<AutocompletePrediction>
    private val mLastKnownLocation: Location? = null

    private lateinit var locationCallback: LocationCallback
    private lateinit var button: Button
    private val lastSearches: List<String>? = null
    private val searchBar: MaterialSearchBar? = null
    private lateinit var view: MapView


    private lateinit var markerName: Marker

    private val DEFAULT_ZOOM = 15f



    }







