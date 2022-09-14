package random_walker

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