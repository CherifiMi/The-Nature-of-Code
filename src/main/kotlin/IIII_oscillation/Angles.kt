package IIII_oscillation

import processing.core.PApplet

fun main(){
    Angles
}
// radians = 2 * PI * (degrees / 360)


object Angles : PApplet() {
    init {
        this.setSize(400, 400)
        this.runSketch()
    }

    override fun setup() {


    }

    var angle = 0f
    var velocity = 0f
    var acceleration = 0.001f


    override fun draw() {
        background(100)

        fill(175)
        stroke(0)
        rectMode(CENTER)
        translate(width/2f,height/2f)
        rotate(angle)

        strokeWeight(3f)
        line(-50f,0f,50f,0f)
        ellipse(50f,0f,20f,20f)
        ellipse(-50f,0f,20f,20f)


        velocity += acceleration
        angle += velocity
    }
}