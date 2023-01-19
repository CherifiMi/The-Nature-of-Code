package IIII_oscillation

import IIII_oscillation.Angles.angle
import processing.core.PApplet

fun main(){
    SHM2
}

object SHM2 : PApplet() {
    init {
        this.setSize(400, 400)
        this.runSketch()
    }

    var angle = 0f
    val aVelocity = 0.05f

    override fun draw() {
        with(SHM2){
            background(255)
            val amp = 120f
            val x = amp * cos(angle)
            angle += aVelocity

            ellipseMode(CENTER)
            stroke(0)
            fill(175)
            translate(width/2f,height/2f)
            line(0f,0f,x,0f)
            ellipse(x,0f,20f,20f)
        }
    }
}