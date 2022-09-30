import processing.core.PApplet
import processing.core.PVector

fun main(){
    VectorsMath
}

object VectorsMath : PApplet() {
    init {
        this.setSize(400, 400)
        this.runSketch()
    }
    var pos = PVector()

    override fun setup() {

    }

    override fun draw() {
        background(255f)
        strokeWeight(2f)
        stroke(0)
        translate(width/2f, height/2f)
        ellipse(pos.x, pos.y,4f,4f)

        val mouse= PVector(mouseX.toFloat(), mouseY.toFloat())
        val center = PVector(width/2f, height/2f)
        mouse.sub(center)

        line(0f, 0f, mouse.x, mouse.y)
    }
}