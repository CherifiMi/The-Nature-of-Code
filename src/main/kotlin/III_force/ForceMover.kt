package III_force

import III_force.ForceMover.ellipse
import III_force.ForceMover.height
import III_force.ForceMover.line
import III_force.ForceMover.mouseX
import III_force.ForceMover.mouseY
import III_force.ForceMover.width
import processing.core.PApplet
import processing.core.PVector

fun main(){
    ForceMover
}

object ForceMover : PApplet() {
    init {
        this.setSize(400, 400)
        this.runSketch()
    }
    override fun draw() {
        background(255)
        FM.update()
        FM.display()
    }
}


object FM{
    val loc = PVector(width/2f, height/2f)
    val velocity = PVector()
    var acceleration = PVector()
    lateinit var mouse: PVector

    fun update() {
        mouse= PVector(mouseX.toFloat(), mouseY.toFloat())
        mouse.sub(loc)
        mouse.setMag(.5f)
        //acceleration = mouse

        velocity.add(acceleration)
        loc.add(velocity)
        velocity.limit(5f)
    }
    fun display() {
        ellipse(loc.x, loc.y, 50f, 50f)
        line(loc.x, loc.y, mouseX.toFloat(), mouseY.toFloat())
    }

}