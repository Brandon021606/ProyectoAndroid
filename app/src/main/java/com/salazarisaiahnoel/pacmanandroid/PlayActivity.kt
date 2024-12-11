package com.salazarisaiahnoel.pacmanandroid

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageButton


class PlayActivity : AppCompatActivity() {

    private lateinit var pacMan2: Pacman2
    private lateinit var upButton: AppCompatImageButton
    private lateinit var downButton: AppCompatImageButton
    private lateinit var leftButton: AppCompatImageButton
    private lateinit var rightButton: AppCompatImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playmaps)

        // Inicializar los botones
        upButton = findViewById(R.id.up)
        downButton = findViewById(R.id.down)
        leftButton = findViewById(R.id.left)
        rightButton = findViewById(R.id.right)

        // Obtener los datos del Intent
        val cityName = intent.getStringExtra("city_name") ?: "Zona 1"
        val pacManPosX = intent.getDoubleExtra("pacman_pos_x", -18.471145518623608)
        val pacManPosY = intent.getDoubleExtra("pacman_pos_y", -70.30371105370016)

        // Inicializar PacMan en la posición recibida
        val map = Array(20) { IntArray(20) } // Crear un mapa de ejemplo
        pacMan2 = Pacman2(this, map, 10, 10, 5, pacManPosX, pacManPosY)

        // Configurar botones para mover PacMan
        setUpButtonListeners()
    }

    private fun setUpButtonListeners() {
        upButton.setOnClickListener {
            pacMan2.move(0, -pacMan2.speed)
        }

        downButton.setOnClickListener {
            pacMan2.move(0, pacMan2.speed)
        }

        leftButton.setOnClickListener {
            pacMan2.move(-pacMan2.speed, 0)
        }

        rightButton.setOnClickListener {
            pacMan2.move(pacMan2.speed, 0)
        }
    }


    // Método para actualizar la interfaz (puedes pasar la posición de PacMan a MapsActivity)
    fun updatePacManPosition() {
        val intent = Intent(this, MapsActivity::class.java)
        intent.putExtra("city_name", "Zona 1")
        intent.putExtra("pacman_pos_x", pacMan2.posicionX)
        intent.putExtra("pacman_pos_y", pacMan2.posicionY)
        startActivity(intent)
    }
}