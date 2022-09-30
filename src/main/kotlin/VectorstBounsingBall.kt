import VectorstBounsingBall.random
import VectorstBounsingBall.background
import VectorstBounsingBall.ellipse
import VectorstBounsingBall.fill
import VectorstBounsingBall.height
import VectorstBounsingBall.stroke
import VectorstBounsingBall.width
import processing.core.PApplet
import processing.core.PVector

fun main() {
    VectorstBounsingBall
}

object VectorstBounsingBall : PApplet() {
    init {
        this.setSize(400, 400)
        this.runSketch()
    }

    lateinit var balls: ArrayList<Ball>

    override fun setup() {
        background(100f)
        balls = arrayListOf(Ball(), Ball())
        println(balls)
    }

    override fun draw() {
        background(100f)
        for(b in balls){
            b.move()
            b.bounce()
            b.draw()
        }
    }
}

class Ball() {
    var pos = PVector(width / 2f + random(-50f, 50f), height / 2f + random(-50f, 50f))
    var velocity = PVector(2.5f + random(-3f, 3f), -2f + random(-3f, 3f))

    fun move() {
        pos = pos.add(velocity)
    }

    fun draw() {
        fill(255f)
        stroke(0f)
        ellipse(pos.x, pos.y, 20f, 20f)
    }

    fun bounce() {
        if (pos.x >= width.toFloat() || pos.x <= 0f) {
            velocity.x = velocity.x * -1
            velocity.x += velocity.x * 0.05f
        }
        if (pos.y >= height.toFloat() || pos.y <= 0f) {
            velocity.y = velocity.y * -1
            velocity.y += velocity.y * 0.05f
        }
    }
}