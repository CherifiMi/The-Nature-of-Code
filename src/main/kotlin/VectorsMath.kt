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
    var scale = PVector(2f, 2f)

    override fun draw() {
        background(255f)
        strokeWeight(2f)
        stroke(0)
        translate(width/2f, height/2f)
        ellipse(pos.x, pos.y, scale.x, scale.y)

        val mouse= PVector(mouseX.toFloat(), mouseY.toFloat())
        val center = PVector(width/2f, height/2f)
        mouse.sub(center)


        scale.normalize().mult(mouse.mag()*2)

        line(0f, 0f, mouse.x, mouse.y)
    }
}