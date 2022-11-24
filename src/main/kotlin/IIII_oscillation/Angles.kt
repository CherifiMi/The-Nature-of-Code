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

    var x = 0f

    override fun draw() {
        background(100)

        translate(width/2f, height/2f)



        var angle = radians(x)
        rotate(angle)

        x++

        rect(-50f, -50f, 100f, 100f)


    }
}