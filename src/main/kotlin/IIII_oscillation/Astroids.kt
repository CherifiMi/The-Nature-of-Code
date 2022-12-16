package IIII_oscillation

import processing.core.PApplet
import processing.core.PVector

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

    var position: PVector
    var velocity: PVector
    var acceleration: PVector

    var damping = 0.995.toFloat()
    var topspeed = 6f
    var heading = 0f
    var r = 16f
    var thrusting = false

    init {
        with(Astroids){
            position = PVector(width/2f,width/2f)
            velocity = PVector()
            acceleration = PVector()
        }
    }

    fun update() {
        velocity.add(acceleration)
        velocity.mult(damping)
        velocity.limit(topspeed)
        position.add(velocity)
        acceleration.mult(0f)
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
