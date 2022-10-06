package III_force

import III_force.ForceMover.ellipse
import III_force.ForceMover.height
import III_force.ForceMover.line
import III_force.ForceMover.mouseX
import III_force.ForceMover.mouseY
import III_force.ForceMover.width
import processing.core.PApplet
import processing.core.PVector
import kotlin.math.absoluteValue

fun main() {
    ForceMover
}

object ForceMover : PApplet() {
    init {
        this.setSize(400, 400)
        this.runSketch()
    }

    override fun draw() {
        background(255)
        FM.applyForce()
        FM.update()
        FM.edges()
        FM.display()
    }
}


object FM {

    val loc = PVector(width / 2f, height / 2f)
    val velocity = PVector()
    var acceleration = PVector()
    var force = PVector(0.2f, 0.3f)

    fun update() {
        velocity.add(acceleration)
        loc.add(velocity)
    }

    fun display() {
        ellipse(loc.x, loc.y, 50f, 50f)
    }

    fun edges() {
        when {
            loc.x > width -> {
                loc.x = width.toFloat()
                velocity.x *= -1
            }
            loc.x < 0 -> {
                velocity.x *= -1
                loc.x = 0f
            }
            loc.y > height -> {
                velocity.y *= -1
                loc.y = height.toFloat()
            }
        }

    }

    fun applyForce() {
        acceleration = force
    }

}