package IIII_oscillation

import IIII_oscillation.Ship.height
import IIII_oscillation.Ship.width
import processing.core.PApplet

fun main(){
    StaticWave
}

object StaticWave : PApplet() {
    init {
        this.setSize(400, 400)
        this.runSketch()
    }

    override fun setup() {

    }

    var angle = 0f
    val anglevel = 0.2f
    val amp = 100f
    var x = 0


    override fun draw() {
        with(StaticWave){
            //background(255)
            smooth()
            strokeWeight(2f)
            stroke(0)
            noFill()

            beginShape()

            while (x <= width) {
                x += 5
                val y = map( sin(angle), -1f, 1f,0f, height.toFloat())
                vertex(x.toFloat(),y)
                angle+= anglevel
            }
            endShape()
        }
    }
}

