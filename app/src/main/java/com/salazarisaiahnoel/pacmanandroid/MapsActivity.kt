package com.salazarisaiahnoel.pacmanandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.GoogleMapOptions
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.salazarisaiahnoel.pacmanandroid.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtener el fragmento del mapa y notificar cuando esté listo
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // TIPO DE MAPA
        mMap.mapType = GoogleMap.MAP_TYPE_NORMAL

        // MARCADORES EN EL MAPA

        val Santiago = LatLng(-33.55, -70.70)
        val Arica1 = LatLng(-18.470379, -70.303064)
        val Arica2 = LatLng(-18.482351, -70.303627)
        val Arica3 = LatLng(-18.477410, -70.316384)

        mMap.addMarker(MarkerOptions().position(Santiago).title("Santiago de Chile"))
        mMap.addMarker(MarkerOptions().position(Arica1).title("Zona 1"))
        mMap.addMarker(MarkerOptions().position(Arica2).title("Zona 2"))
        mMap.addMarker(MarkerOptions().position(Arica3).title("Zona 3"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Santiago))

        mMap.setOnMarkerClickListener { marker ->
            showStartGameDialog(marker.title.toString())
            true
        }
    }

    private fun showStartGameDialog(cityName: String) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("¿Deseas iniciar el juego en $cityName?")
            .setCancelable(false)
            .setPositiveButton("Iniciar Juego") { dialog, id ->
                startGame(cityName)
            }
            .setNegativeButton("Cancelar") { dialog, id ->
                dialog.dismiss()
            }
        // Mostrar el diálogo
        builder.create().show()
    }

    private fun startGame(cityName: String) {

        Toast.makeText(this, "Iniciando juego en $cityName", Toast.LENGTH_SHORT).show()

        // ZOOM AL INICIO DE JUEGO
        val location = when (cityName) {
            "Zona 1" -> LatLng(-18.470379, -70.303064)
            "Zona 2" -> LatLng(-18.482351, -70.303627)
            "Zona 3" -> LatLng(-18.477410, -70.316384)
            else -> LatLng(-18.470379, -70.303064) // Default
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 17f))


    }
}