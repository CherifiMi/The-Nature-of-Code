package IIII_oscillation

import processing.core.PApplet

fun main() {
    Astroids
}

object Astroids : PApplet() {
    init {
        this.setSize(400, 400)
        this.runSketch()
    }

    private val ship = Ship

    override fun draw() {
        ship.update()
        ship.edge()
        ship.display()
        if (keyPressed)
            when (keyCode) {
                LEFT -> ship.turn(-0.03f)
                RIGHT -> ship.turn(0.03f)
                Z -> ship.thrust()
            }
    }
}

object Ship {
    fun update() {

    }

    fun edge() {

    }

    fun display() {

    }

    fun turn(f: Float) {

    }

    fun thrust() {

    }

}