package com.example.vontoil2

import android.content.Intent
import android.location.Location
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.example.vontoil2.databinding.ActivityMaps2Binding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.libraries.places.api.model.AutocompletePrediction
import com.google.android.libraries.places.api.net.PlacesClient
import com.google.android.material.navigation.NavigationView
import com.mancj.materialsearchbar.MaterialSearchBar
import java.util.*


class MapsActivity2 : AppCompatActivity(), OnMapReadyCallback {

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

    lateinit var toggle: ActionBarDrawerToggle



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = ActivityMaps2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        var myPlace = LatLng(-1.286389, 36.817223)

        var longitude = -1.286389
        var latitude = 36.817223


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.googleMap) as SupportMapFragment
        mapFragment.getMapAsync(this)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)


        val drawerLayout : DrawerLayout = findViewById(R.id.drawerlayout)
        val navView: NavigationView =findViewById(R.id.nav_view)

        //val navController =findNavController(R.id.)

        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.navigation_drawer_open,R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()



        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {

            when(it.itemId){

                R.id.Map -> startActivity(Intent(this, MapsActivity2::class.java))
                R.id.signOut -> drawerLayout.closeDrawer(drawerLayout)
                R.id.socialhandle1 -> Toast.makeText( applicationContext,"Clicked Instagram", Toast.LENGTH_SHORT).show()
                R.id.socialhandle -> Toast.makeText( applicationContext,"Clicked Facebook", Toast.LENGTH_SHORT).show()
                R.id.RateUs -> Toast.makeText( applicationContext,"Clicked Rate Us", Toast.LENGTH_SHORT).show()
                R.id.action_settings -> Toast.makeText(applicationContext, "Clicked Settings", Toast.LENGTH_SHORT).show()




            }
            true
        }



    }




    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val Nairobi = LatLng(-1.286389, 36.817223)
        val zoomLevel = 15f
        mMap.addMarker(
            MarkerOptions().position(Nairobi).title("Marker in Nairobi").icon(
                BitmapDescriptorFactory.defaultMarker(
                    BitmapDescriptorFactory.HUE_GREEN
                )
            )
        )
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Nairobi, zoomLevel))

    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }





}













