package III_force

import processing.core.PApplet
import processing.core.PVector

fun main() {

    EverythingAttracts

}

object EverythingAttracts : PApplet() {
    init {
        this.setSize(400, 400)
        this.runSketch()
    }

    val balls = List(500) { Ball(random(width.toFloat()), random(height.toFloat()), random(1f, 10f)) }

    override fun draw() {
        background(255)
        balls.forEachIndexed { index, ball ->

            balls.forEachIndexed{i, b ->
                if (i!=index){
                    val gravity = PVector.sub(ball.loc, b.loc)
                    val distance = constrain(gravity.mag(), 5f, 25f)
                    val p = (.04f * b.mass * ball.mass) / (distance * distance)
                    gravity.normalize()
                    gravity.mult(p)
                    b.applyForce(gravity)
                }
            }

            ball.applyMass()
            ball.update()
            ball.display()
        }
    }
}


class Ball(x: Float, y: Float, m: Float) {
    val loc = PVector(x, y)
    val velocity = PVector()
    var acceleration = PVector()

    val mass = m

    fun update() {
        velocity.add(acceleration)
        loc.add(velocity)
        acceleration.mult(0f)
    }

    fun display() {
        EverythingAttracts.fill(100f, 90f)
        EverythingAttracts.noStroke()
        EverythingAttracts.stroke(0f)
        EverythingAttracts.strokeWeight(3f)

        EverythingAttracts.ellipse(loc.x, loc.y, 2f * mass, 2f * mass)
    }


    fun applyForce(force: PVector) {
        acceleration.add(force)
    }

    fun applyMass() {
        acceleration.div(mass)
    }
}