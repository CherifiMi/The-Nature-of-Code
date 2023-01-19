package IIII_oscillation

import processing.core.PApplet
import processing.core.PVector

fun main(){
    SHM
}

object SHM : PApplet() {
    init {
        this.setSize(400, 400)
        this.runSketch()
    }

    val loc = PVector()
    val amp = 100f
    val per = 120f

    override fun draw() {
        with(SHM){
            background(100f)

            translate(width/2f,height/2f)

            strokeWeight(3f)
            ellipse(loc.x,loc.y,50f,50f)
            line(loc.x,loc.y,0f,0f)


            loc.y = amp * sin(PI * frameCount / per)
            loc.x = amp * cos(TWO_PI * frameCount / per)
        }
    }
}