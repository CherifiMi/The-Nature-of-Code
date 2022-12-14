package IIII_oscillation

import processing.core.PApplet

fun main(){
    spiral
}

object spiral : PApplet() {
    init {
        this.setSize(400, 400)
        this.runSketch()
    }

    override fun setup() {
        background(255)
        smooth()
    }

    var r = 0f
    var theta = 0f

    override fun draw() {
        var x = r * cos(theta)
        var y = r * sin(theta)

        translate(width /2f, height /2f)

        fill(0)
        ellipse(x, y, 16f, 16f)

        theta += 0.01f
        r += 0.05f
    }
}