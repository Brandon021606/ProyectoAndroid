package com.salazarisaiahnoel.pacmanandroid

import android.content.Context

class Pacman2(
    private val context: Context,
    private val map: Array<IntArray>,
    private val posX: Int,
    private val posY: Int,
    val speed: Int,
    var posicionX: Double,
    var posicionY: Double
) {

    // Método para mover PacMan
    fun move(dx: Int, dy: Int) {
        // Actualizar las coordenadas de la celda en el mapa
        val newPosX = posX + dx
        val newPosY = posY + dy

        // Ajustar la posición en el mapa de acuerdo al movimiento
        posicionX += dx * 0.0001  // Ajuste ficticio para simular el movimiento en el mapa
        posicionY += dy * 0.0001  // Ajuste ficticio para simular el movimiento en el mapa
    }
}