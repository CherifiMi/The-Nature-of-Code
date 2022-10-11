package III_force


import processing.core.PApplet
import processing.core.PGraphics.G
import processing.core.PVector
import processing.event.KeyEvent

fun main() {
    GravitationalAttraction
}


// P = m*g  =>  g = 9.81m/s
// G = ((G*m1*m2)/d*d)*r^
object GravitationalAttraction : PApplet() {

    //region
    init {
        this.setSize(400, 400)
        this.runSketch()
    }
    //endregion

    var ms = mutableListOf<M>()

    override fun setup() {
        ms.add(M(width / 2f, height / 2f, 20f))
    }

    var filter = true

    override fun draw() {
        //background(255)

        if (filter) {
            filter(BLUR, 1f)
            filter(ERODE)
        } else {
            filter(BLUR, 1f)
            filter(DILATE)
        }

        for (m in ms) {

            val gravity = PVector.sub(ms[0].loc, m.loc)
            val distance = constrain(gravity.mag(), 5f, 25f)
            val p = (.1f * m.mass * ms[0].mass) / (distance * distance)
            gravity.normalize()
            gravity.mult(p)

            if (ms.indexOf(m) != 0) {
                m.applyForce(gravity)
            }

            m.applyMass()
            m.update()
            m.display()
        }
    }

    override fun mouseClicked() {
        ms.add(M(mouseX.toFloat(), mouseY.toFloat(), random(5f, 10f)))
    }

    override fun keyPressed() {
        filter = !filter
    }
}


class M(x: Float, y: Float, m: Float) {
    val loc = PVector(x, y)
    val velocity = PVector()
    var acceleration = PVector()
    var color = PVector(
        GravitationalAttraction.random(50f, 255f),
        GravitationalAttraction.random(50f, 200f),
        GravitationalAttraction.random(100f, 255f)
    )
    val mass = m

    fun update() {
        velocity.add(acceleration)
        loc.add(velocity)
        acceleration.mult(0f)
    }

    fun display() {
        if (mass <= 10f) {
            GravitationalAttraction.fill(color.x, color.y, color.z)
            GravitationalAttraction.stroke(color.x, color.y, color.z)
            GravitationalAttraction.strokeWeight(5f)
        }else{
            GravitationalAttraction.noFill()
            GravitationalAttraction.noStroke()
        }
        GravitationalAttraction.ellipse(loc.x, loc.y, 2f * mass, 2f * mass)
    }


    fun applyForce(force: PVector) {
        acceleration.add(force)
    }

    fun applyMass() {
        acceleration.mult(mass)
    }

}