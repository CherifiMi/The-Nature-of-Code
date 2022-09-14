package noise

import processing.core.PApplet
import random_walker.RandomWalker.height
import random_walker.RandomWalker.width

fun main() {
    Noise
}

var t = 0f
var x = width / 2f
var y = height / 2f

object Noise : PApplet() {
    init {
        this.setSize(400, 400)
        this.runSketch()
    }

    override fun setup() {

    }

    override fun draw() {
        background(0.4f)
        x = map(noise(t), 0f, 1f, 0f, width.toFloat())
        ellipse(x, y, 50f, 50f)
        t += 0.05f
    }
}