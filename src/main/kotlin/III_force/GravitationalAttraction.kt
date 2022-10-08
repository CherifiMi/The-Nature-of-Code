package III_force

import processing.core.PApplet
import processing.core.PVector
import processing.event.MouseEvent

fun main() {
    GravitationalAttraction
}


// P = m*g  =>  g = 9.81m/s
// G = (G*m1*m2)/d*d
object GravitationalAttraction : PApplet() {

    //region
    init {
        this.setSize(400, 400)
        this.runSketch()
    }
    //endregion

    var ms = mutableListOf<M>()

    override fun setup() {
        ms.add(M(width / 2f, height / 2f, 2f))
    }

    override fun draw() {
        background(100f)

        for (m in ms) {
            m.applyMass()
            m.update()
            m.display()
        }
    }

    override fun mouseClicked() {
        ms.add(M(mouseX.toFloat(), mouseY.toFloat(), random(1f, 2f)))
    }
}


class M(x: Float, y: Float, m: Float) {
    val loc = PVector(x, y)
    val velocity = PVector()
    var acceleration = PVector()
    var mass = m

    fun update() {
        velocity.add(acceleration)
        loc.add(velocity)
        acceleration.mult(0f)
    }

    fun display() {
        GravitationalAttraction.ellipse(loc.x, loc.y, 20f * mass, 20f * mass)
    }


    fun applyForce(force: PVector) {
        acceleration.add(force)
    }

    fun applyMass() {
        acceleration.div(mass)
    }

}