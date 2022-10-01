package II_vectors

import processing.core.PApplet
import processing.core.PVector

fun main(){
    Vector
}

object Vector : PApplet() {
    //region
    init {
        this.setSize(400, 400)
        this.runSketch()
    }
    //endregion
    var pos= PVector()

    override fun draw() {
        background(255f)

        stroke(0)
        strokeWeight(2f)
        fill(125f)
        ellipse(pos.x, pos.y, 48f, 48f)

        pos = pos.add(1f, 1f)
    }
}