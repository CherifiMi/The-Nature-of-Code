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

    var r = 0f
    val x = 50f
    var y = 30f

    override fun draw() {
        background(100)

        translate(width/2f, height/2f)
        var angle = radians(r)
        rotate(angle)
        r++


        rect(-50f, -50f, 100f, 100f)

        line(-x, -x,x, x)

        ellipse(-x, -x, y, y)
        ellipse(x, x, y, y)

    }
}