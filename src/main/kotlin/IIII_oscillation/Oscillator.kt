package IIII_oscillation

import IIII_oscillation.Oscillator.random
import processing.core.PApplet
import processing.core.PApplet.cos
import processing.core.PVector

fun main(){
    Oscillator
}

object Oscillator : PApplet() {
    init {
        this.setSize(400, 400)
        this.runSketch()
    }

    val oscs = mutableListOf<Osc>()

    override fun setup() {
        for (i in 1..10){
            oscs.add(Osc())
        }
    }

    override fun draw() {
        with(Oscillator){
            rectMode(CORNER)
            noStroke()
            fill(100f,50f)
            rect(0f,0f, width.toFloat(), height.toFloat())

            ellipseMode(CENTER)
            stroke(0)
            fill(175)
            translate(width / 2f, height / 2f)

            for (osc in oscs){
                osc.update()
                osc.display()
            }
        }
    }
}

class Osc(){
    var angle = 0f
    val aVelocity = 0.05f + random(0.04f)
    var angle2 = 0f
    val aVelocity2 = 0.05f + random(0.04f)
    val loc = PVector()

    fun display(){
        with(Oscillator){
            line(0f, 0f, loc.x, loc.y)
            ellipse(loc.x, loc.y, 40f, 40f)
        }
    }
    fun update(){
        val amp = 100f
        loc.x = amp * cos(angle)
        loc.y = amp * cos(angle2)
        angle += aVelocity
        angle2 += aVelocity2
    }
}