package com.salazarisaiahnoel.pacmanandroid
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolygonOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        // Obtener el fragmento del mapa y notificar cuando esté listo
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // TIPO DE MAPA
        mMap.mapType = GoogleMap.MAP_TYPE_TERRAIN

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

        addWalls()

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

    private fun addWalls() {
        // Coordenadas de las paredes del tablero
        val wallZones = listOf(
            //ZONA 1
            listOf(
                LatLng(-18.470376, -70.303183),
                LatLng(-18.469901, -70.303796),
                LatLng(-18.470908, -70.304662),
                LatLng(-18.471422, -70.304043)
            ),
            listOf(
                LatLng(-18.470298, -70.303098),
                LatLng(-18.469811, -70.303732),
                LatLng(-18.468716, -70.302815),
                LatLng(-18.469229, -70.302163)
            ),
            listOf(
                LatLng(-18.471488, -70.303958),
                LatLng(-18.470981, -70.303508),
                LatLng(-18.471648, -70.302617),
                LatLng(-18.472196, -70.303089)
            ),
            listOf(
                LatLng(-18.470913, -70.303478),
                LatLng(-18.470667, -70.303300),
                LatLng(-18.471377, -70.302357),
                LatLng(-18.471612, -70.302549)
            ),
            listOf(
                LatLng(-18.471307, -70.302339),
                LatLng(-18.471100, -70.302172),
                LatLng(-18.470406, -70.303081),
                LatLng(-18.470633, -70.303265)
            ),
            listOf(
                LatLng(-18.470372145374316, -70.30305290700606),
                LatLng(-18.470995434525637, -70.3021858829451),
                LatLng(-18.469972730313547, -70.30121492328719),
                LatLng(-18.46930618847234, -70.30208664120485)
            ),
            //malo
            listOf(
                LatLng(-18.47097299615326, -70.30474996143117),
                LatLng(-18.47127319179062, -70.30501147680648),
                LatLng(-18.471740020403214, -70.30442004972694),
                LatLng(-18.47144745766111, -70.30417060429204)
            ),
            listOf(
                LatLng(-18.47209954119143, -70.30464680968365),
                LatLng(-18.471479436085104, -70.30411305009714),
                LatLng(-18.47224327805563, -70.30314477265154),
                LatLng(-18.472786424234897, -70.3036128181194)
            ),
            listOf(
                LatLng(-18.472226245261574, -70.30301549702826),
                LatLng(-18.471983291708288, -70.30279153257862),
                LatLng(-18.472330549822843, -70.30230068833575),
                LatLng(-18.47256714286083, -70.30251124174049)
            ),
            listOf(
                LatLng(-18.471924779275867, -70.30274459391815),
                LatLng(-18.471340925934214, -70.30224972636138),
                LatLng(-18.471632216846412, -70.30179911525316),
                LatLng(-18.4722313332853, -70.3023194637947)
            ),
            listOf(
                LatLng(-18.47125824500961, -70.30223229199804),
                LatLng(-18.470060056837255, -70.30112891081407),
                LatLng(-18.470891587121013, -70.30008962331993),
                LatLng(-18.472040214752422, -70.30109545168821)
            ),
            listOf(
                LatLng(-18.46864519011301, -70.302736963584),
                LatLng(-18.469931847474854, -70.30113702592566),
                LatLng(-18.468752676916584, -70.30010638711778),
                LatLng(-18.467427849420396, -70.3016875493144)
            ),
            listOf(
                LatLng(-18.46737107237441, -70.3017512642644),
                LatLng(-18.471235110887882, -70.30507615952041),
                LatLng(-18.470434375817643, -70.30618122963507),
                LatLng(-18.46662214551969, -70.30285651309816)
            )
            // ZONA 2 PROXIMAMENTE
        )

        for (wallZone in wallZones) {
            val polygonOptions = PolygonOptions()
                .addAll(wallZone)
                .strokeColor(Color.BLACK)  // Color de la pared
                .fillColor(Color.GRAY)  // Color del relleno
            mMap.addPolygon(polygonOptions)
        }
    }

    private fun startGame(cityName: String) {

        Toast.makeText(this, "Iniciando juego en $cityName", Toast.LENGTH_SHORT).show()

        // Desactivar gestos del mapa (para no mover la cámara)
        mMap.getUiSettings().setAllGesturesEnabled(false)


        // ZOOM AL INICIO DE JUEGO
        val location = when (cityName) {
            "Zona 1" -> LatLng(-18.471145518623608, -70.30371105370016)
            "Zona 2" -> LatLng(-18.482351, -70.303627)
            "Zona 3" -> LatLng(-18.477410, -70.316384)
            else -> LatLng(-18.471145518623608, -70.30371105370016) // Default
        }

        // Crear el Intent para abrir PlayActivity con las coordenadas de PacMan
        val intent = Intent(this, PlayActivity::class.java)
        intent.putExtra("city_name", cityName)
        intent.putExtra("pacman_pos_x", location.latitude)
        intent.putExtra("pacman_pos_y", location.longitude)
        startActivity(intent)
    }
}