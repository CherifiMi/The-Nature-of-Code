import RandomWalker.fill
import RandomWalker.height
import RandomWalker.point
import RandomWalker.random
import RandomWalker.width
import processing.core.PApplet

fun main(){
    RandomWalker
}


object RandomWalker : PApplet() {
    init {
        this.setSize(400, 400)
        this.runSketch()
    }

    override fun setup() {
        Walker.render()
    }

    override fun draw() {
        Walker.render()
        Walker.walk()
    }
}

object Walker {
    var x = width/2f
    var y = height/2f

    fun render(){
        fill(0)
        point(x, y)
    }
    fun walk(){
        x += random(-1f, 1f)
        y += random(-1f, 1f)
    }
}