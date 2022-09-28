import processing.core.PApplet
import processing.core.PVector

fun main(){
    Vector
    // hi git cmd
}

object Vector : PApplet() {
    init {
        this.setSize(400, 400)
        this.runSketch()
    }

    var pos= PVector(0f, 0f)

    override fun draw() {
        stroke(0)
        strokeWeight(2f)
        fill(125f)
        ellipse(pos.x, pos.y, 48f, 48f)

        pos.x ++
        pos.y ++
    }
}