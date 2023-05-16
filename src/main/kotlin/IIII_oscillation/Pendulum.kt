package IIII_oscillation
import I_randomnes.RandomPerlinNoiseWalker
import processing.core.PApplet
import processing.core.PVector
import kotlin.math.absoluteValue

fun main(){
    Pendulum
}

object Pendulum
 : PApplet() {
    init {
        this.setSize(400, 400)
        this.runSketch()
    }

    val loc = PVector()
    var amp = 100f
    var per = 120f

    override fun draw() {
        background(100f)

        translate(width /2f, height /2f)

        strokeWeight(3f)
        line(loc.x,loc.y,0f,0f)
        ellipse(loc.x, loc.y,50f,50f)

        update()
    }
    private fun update() {
            loc.y = amp * sin(TWO_PI * frameCount / per).absoluteValue
            loc.x = amp * cos(TWO_PI * frameCount / per)
    }
}