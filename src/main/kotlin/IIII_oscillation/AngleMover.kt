package IIII_oscillation

import processing.core.PApplet
import processing.core.PConstants.CENTER
import processing.core.PConstants.CORNER
import processing.core.PVector
import kotlin.math.atan

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
        //AM.edges()
        AM.display()
    }
}


object AM{
    val loc = PVector(AngleMover.width/2f, AngleMover.height/2f)
    val velocity = PVector()
    var acceleration = PVector()
    lateinit var mouse: PVector

    fun update() {
        mouse= PVector(AngleMover.mouseX.toFloat(), AngleMover.mouseY.toFloat())
        mouse.sub(loc)
        mouse.setMag(.5f)
        acceleration = mouse

        velocity.add(acceleration)
        loc.add(velocity)
        velocity.limit(5f)
    }
    fun edges() {
        if (loc.x > AngleMover.width) loc.x = 0f
        if (loc.x < 0) loc.x = AngleMover.width.toFloat()
        if (loc.y > AngleMover.height) loc.y = 0f
        if (loc.y < 0) loc.y = AngleMover.height.toFloat()
    }
    fun display() {
        val angle = atan(velocity.y/ velocity.x)
        AngleMover.stroke(0)
        AngleMover.strokeWeight(2f)
        AngleMover.fill(100f)
        AngleMover.pushMatrix()
        AngleMover.rectMode(CENTER)
        AngleMover.translate(loc.x,loc.y)
        AngleMover.rotate(angle)
        AngleMover.rect(0f,0f, 50f, 20f)
        AngleMover.popMatrix()
    }

}