package IIII_oscillation

import processing.core.PApplet
import processing.core.PConstants.CENTER
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
                SHIFT -> ship.thrust()
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
        when{
            position.x > width + buffer -> position.x = -buffer
            position.x < - buffer -> position.x = width+buffer
            position.y > height + buffer -> position.y = -buffer
            position.y < - buffer -> position.y = height+buffer
        }
    }

    fun display() {
        with(Astroids){
            strokeWeight(2f)
            stroke(0)

            pushMatrix()
            translate(position.x, position.y)
            rotate(heading)
            fill(175)
            if (thrusting) fill(255f, 0f, 0f)
            rect(-r/2, r, r/3, r/2)
            rect(r/2, r, r/3, r/2)
            fill(175)
            beginShape()
            vertex(-r,r)
            vertex(0f,-r)
            vertex(r,r)
            endShape()
            rectMode(CENTER)
            popMatrix()

            thrusting=false
        }
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
