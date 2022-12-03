package IIII_oscillation

import processing.core.PApplet
import processing.core.PConstants.CENTER
import processing.core.PVector

fun main(){
    AngleMover
}

object AngleMover : PApplet() {
    init {
        this.setSize(400, 400)
        this.runSketch()
    }

    override fun draw() {
        rectMode(CORNER)
        noStroke()
        fill(255f,5f)
        rect(0f,0f, width.toFloat(), height.toFloat())

        AM.update()
        AM.edges()
        AM.display()
    }
}


object AM{

    val loc = PVector(AngleMover.width/2f, AngleMover.height/2f)
    val velocity = PVector()
    var acceleration = PVector()
    lateinit var mouse: PVector

    fun update() {
        AngleMover.run {
        mouse= PVector(mouseX.toFloat(), mouseY.toFloat())
        mouse.sub(loc)
        mouse.setMag(.5f)
        acceleration = mouse

        velocity.add(acceleration)
        loc.add(velocity)
        velocity.limit(5f)
        }
    }
    fun edges() {
        AngleMover.run {
        if (loc.x > width) loc.x = 0f
        if (loc.x < 0) loc.x = width.toFloat()
        if (loc.y > height) loc.y = 0f
        if (loc.y < 0) loc.y = height.toFloat()
        }
    }
    fun display() {
        AngleMover.run {
            val angle = velocity.heading()
            stroke(0)
            strokeWeight(2f)
            fill(100f)
            pushMatrix()
            rectMode(CENTER)
            translate(loc.x,loc.y)
            rotate(angle)
            rect(0f,0f, 50f, 20f)
            popMatrix()
            //line(loc.x, loc.y, mouseX.toFloat(), mouseY.toFloat())
        }
    }

}