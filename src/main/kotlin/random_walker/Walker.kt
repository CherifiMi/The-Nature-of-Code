package random_walker

import random_walker.RandomWalker.fill
import random_walker.RandomWalker.height
import random_walker.RandomWalker.point
import random_walker.RandomWalker.random
import random_walker.RandomWalker.width

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