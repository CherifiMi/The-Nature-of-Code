package IIII_oscillation

import IIII_oscillation.Oscillator.random
import IIII_oscillation.SHM2.aVelocity
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
        for (i in 1..20){
            oscs.add(Osc())
        }
    }

    override fun draw() {
        with(Oscillator){
            rectMode(CORNER)
            noStroke()
            fill(100f,20f)
            rect(0f,0f, width.toFloat(), height.toFloat())

            ellipseMode(CENTER)
            stroke(0)
            strokeWeight(2f)
            fill(175)
            translate(width / 2f, height / 2f)

            for (osc in oscs){
                osc.oscillate()
                osc.display()
            }
        }
    }
}

class Osc(){

    val angle = PVector()
    val velocity = PVector(random(-0.05f,0.05f),random(-0.05f,0.05f))
    val amp = 120f
    val loc = PVector()

    fun display(){
        with(Oscillator){
            loc.x = amp * cos(angle.x)
            loc.y = amp * cos(angle.y)

            line(0f, 0f, loc.x, loc.y)
            ellipse(loc.x, loc.y, 30f, 30f)
        }
    }
    fun oscillate(){
        angle.add(velocity)
    }
}