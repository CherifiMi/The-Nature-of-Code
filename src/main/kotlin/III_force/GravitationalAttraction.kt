package III_force


import processing.core.PApplet
import processing.core.PGraphics.G
import processing.core.PVector

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
        ms.add(M(width / 2f, height / 2f, 5f))
    }

    override fun draw() {
        background(100f)

        for (m in ms) {

            val gravity = PVector.sub(ms[0].loc,m.loc)
            val distance = constrain(gravity.mag(), 5f, 25f)

            val p = (0.4f * m.mass * ms[0].mass) / (distance * distance)
            gravity.normalize()
            gravity.mult(p)

            if (ms.indexOf(m)!=0){
                m.applyForce(gravity)
                val q = PVector(width/2f, height/2f).normalize()
                line(q.x, q.y, m.loc.x, m.loc.y)
            }

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
    val mass = m

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
        acceleration.mult(mass)
    }

}