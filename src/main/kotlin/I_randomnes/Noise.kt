package I_randomnes

import processing.core.PApplet
import RandomWalker.height
import RandomWalker.width

fun main() {
    Noise
}


object Noise : PApplet() {
    var tx = 0f
    var ty = 0f
    var x = width / 2f
    var y = height / 2f


    init {
        this.setSize(400, 400)
        this.runSketch()
    }

    override fun setup() {

    }

    override fun draw() {
        background(0.4f)
        x = map(noise(tx), 0f, 1f, 0f, width.toFloat())
        y = map(noise(ty), 0f, 1f, 0f, height.toFloat())
        ellipse(x, y, 50f, 50f)
        tx += 0.05f
        ty += 0.01f
    }
}