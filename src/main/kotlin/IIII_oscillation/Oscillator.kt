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
        for (i in 1..10){
            oscs.add(Osc())
        }
    }

    override fun draw() {
        with(Oscillator){
            rectMode(CORNER)
            noStroke()
            fill(255f,2f)
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
    val amp = PVector(random(50f,150f),random(50f,150f))
    val velocity = PVector(random(-0.05f,0.05f),random(-0.05f,0.05f))

    val loc = PVector()

    fun display(){
        with(Oscillator){
            loc.x = amp.x * cos(angle.x)
            loc.y = amp.y * cos(angle.y)

            line(0f, 0f, loc.x, loc.y)
            ellipse(loc.x, loc.y, 40f, 40f)
        }
    }
    fun oscillate(){
        angle.add(velocity)
    }
}