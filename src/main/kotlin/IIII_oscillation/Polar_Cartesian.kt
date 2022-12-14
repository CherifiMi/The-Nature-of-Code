package IIII_oscillation

import processing.core.PApplet

fun main(){
    Polar_Cartesian
}

object Polar_Cartesian : PApplet() {
    init {
        this.setSize(400, 400)
        this.runSketch()
    }

    override fun setup() {
        background(255);
    }

    var r = 75f
    var theta = 0f

    override fun draw() {

        fill(255f,10f)
        rect(0f,0f, width.toFloat(), height.toFloat())

        var x = r * cos(theta)
        var y = r * sin(theta)

        translate(width/2f,height/2f)

        fill(100)
        strokeWeight(5f)

        line(x,y,0f,0f)
        ellipse(x, y, 60f, 60f)

        theta+= 0.01f
    }
}