package III_force

import III_force.ForceMover.ellipse
import III_force.ForceMover.height
import III_force.ForceMover.random
import III_force.ForceMover.width
import M.velocity
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


    val FMS = List(5){FM()}

    override fun draw() {
        background(255)

        var w = PVector(0.2f, 0f)
        var g = PVector(0f, 0.3f)

        for (FM in FMS){
            FM.applyForce(g.mult(FM.mass))
            if (mousePressed){
                FM.applyForce(w)
            }


            //var friction = FM.velocity.get()
            //friction.normalize()
            //var c = -0.01f
            //friction.mult(c)
            //FM.applyForce(friction)


            var drag = FM.velocity.get()
            drag.normalize()
            var c = -0.01f
            var speed = FM.velocity.magSq()
            drag.mult(c*speed)
            FM.applyForce(drag)

            FM.applyMass()
            FM.update()
            FM.edges()
            FM.display()
        }
    }
}


class FM {

    val loc = PVector(random(width.toFloat()), height / 2f)
    val velocity = PVector()
    var acceleration = PVector()
    var mass = random(1f, 2f)

    fun update() {
        velocity.add(acceleration)
        loc.add(velocity)
        acceleration.mult(0f)
    }

    fun display() {
        ellipse(loc.x, loc.y, 20f*mass, 20f* mass)
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
            loc.y < 0 -> {
                velocity.y *= -1
                loc.y = 0f
            }
        }

    }

    fun applyForce(force: PVector) {
        acceleration.add(force)
    }
    fun applyMass(){
        acceleration.mult(mass)
    }

}