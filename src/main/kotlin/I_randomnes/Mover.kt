import Mover.ellipse
import Mover.height
import Mover.line
import Mover.mouseX
import Mover.mouseY
import Mover.width
import processing.core.PApplet
import processing.core.PVector

fun main(){
    Mover
}

object Mover : PApplet() {
    init {
        this.setSize(400, 400)
        this.runSketch()
    }

    override fun draw() {
        background(255)
        M.update()
        //M.edges()
        M.display()
    }
}

object M{
    val loc = PVector(width/2f, height/2f)
    val velocity = PVector()
    var acceleration = PVector()
    lateinit var mouse: PVector

    fun update() {
        mouse= PVector(mouseX.toFloat(), mouseY.toFloat())
        mouse.sub(loc)
        mouse.setMag(.5f)
        acceleration = mouse

        velocity.add(acceleration)
        loc.add(velocity)
        velocity.limit(5f)
    }
    fun edges() {
        if (loc.x > width) loc.x = 0f
        if (loc.x < 0) loc.x = width.toFloat()
        if (loc.y > height) loc.y = 0f
        if (loc.y < 0) loc.y = height.toFloat()
    }
    fun display() {
        ellipse(loc.x, loc.y, 50f, 50f)
        line(loc.x, loc.y, mouseX.toFloat(), mouseY.toFloat())
    }

}