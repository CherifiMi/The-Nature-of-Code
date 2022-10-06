package III_force

import III_force.ForceMover.ellipse
import III_force.ForceMover.height
import III_force.ForceMover.width
import processing.core.PApplet
import processing.core.PVector

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

        var force = PVector(0.02f, 0.3f)
        FM.applyForce(force)

        FM.update()
        FM.edges()
        FM.display()
    }
}


object FM {

    val loc = PVector(width / 2f, height / 2f)
    val velocity = PVector()
    var acceleration = PVector()

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

    fun applyForce(force: PVector) {
        acceleration = force
    }

}