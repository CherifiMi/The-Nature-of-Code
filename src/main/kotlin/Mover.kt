import Mover.ellipse
import Mover.height
import Mover.width
import processing.core.PApplet
import processing.core.PVector
import javax.swing.text.html.HTML.Tag.P

fun main(){
    Mover
}

object Mover : PApplet() {
    init {
        this.setSize(400, 400)
        this.runSketch()
    }

    override fun draw() {
        //background(255)
        M.update()
        M.ecc()
        M.edges()
        M.display()
    }
}

object M{
    val loc = PVector(width/2f, height/2f)
    val velocity = PVector()
    val acceleration = PVector()

    fun update() {
        velocity.add(acceleration)
        loc.add(velocity)
    }
    fun edges() {
        if (loc.x > width) loc.x = 0f
        if (loc.x < 0) loc.x = width.toFloat()
        if (loc.y > height) loc.y = 0f
        if (loc.x < 0) loc.y = height.toFloat()
    }
    fun display() {
        ellipse(loc.x, loc.y, 50f, 50f)
    }

}