package IIII_oscillation

import processing.core.PApplet
import processing.core.PVector
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

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

    val width = Astroids.width
    val height = Astroids.height

    var position = PVector(width /2f, width /2f)
    var velocity = PVector()
    var acceleration = PVector()

    var damping = 0.995.toFloat()
    var topspeed = 6f
    var heading = 0f
    var r = 16f
    var thrusting = false

    fun update() {
        velocity.add(acceleration)
        velocity.mult(damping)
        velocity.limit(topspeed)
        position.add(velocity)
        acceleration.mult(0f)
    }

    // Newton's law: F = M * A
    fun applyForce(force: PVector) {
        val f = force.get()
        //f.div(mass); // ignoring mass right now
        acceleration.add(f)
    }

    fun edge() {
        val buffer = r*2

    }

    fun display() {

    }

    fun turn(f: Float) {
        heading+=f
    }

    fun thrust() {
        val angle = heading - PI.toFloat()/2
        val force = PVector(cos(angle), sin(angle))
        force.mult(0.1f)
        applyForce(force)
        thrusting = true
    }

}
