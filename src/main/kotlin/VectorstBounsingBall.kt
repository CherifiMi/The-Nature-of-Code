import VectorstBounsingBall.random
import VectorstBounsingBall.background
import VectorstBounsingBall.ellipse
import VectorstBounsingBall.fill
import VectorstBounsingBall.height
import VectorstBounsingBall.stroke
import VectorstBounsingBall.width
import processing.core.PApplet
import processing.core.PVector
import kotlin.math.absoluteValue

fun main() {
    VectorstBounsingBall
}

object VectorstBounsingBall : PApplet() {
    init {
        this.setSize(400, 400)
        this.runSketch()
    }

    lateinit var balls: MutableList<Ball>

    override fun setup() {
        background(255)
        balls = mutableListOf()
    }

    override fun draw() {
        for (b in balls) {
            b.move()
            b.bounce()
            b.draw()
        }
        filter(BLUR, 1f)
        filter(DILATE)
    }

    override fun mouseClicked() {
        balls.add(Ball())
        if (balls.size > 8) {
            balls.removeAt(0)
        }
    }
}

class Ball() {
    var pos = PVector(width / 2f + random(-50f, 50f), height / 2f + random(-50f, 50f))
    var velocity = PVector(2.5f + random(-3f, 3f), -2f + random(-3f, 3f))
    var color = PVector(random(50f, 255f), random(50f, 200f), random(100f, 255f))
    var unlimitid = false

    fun move() {
        pos = pos.add(velocity)
    }

    fun draw() {
        fill(color.x, color.y, color.z)
        stroke(color.x, color.y, color.z)
        ellipse(pos.x, pos.y, 20f, 20f)
    }

    fun bounce() {

        if (pos.x >= width.toFloat() || pos.x <= 0f) {
            velocity.x = velocity.x * -1
            if (unlimitid || velocity.x.absoluteValue < 20) {
                velocity.x += velocity.x * 0.05f
            }
        }
        if (pos.y >= height.toFloat() || pos.y <= 0f) {
            velocity.y = velocity.y * -1
            if (unlimitid ||  velocity.y.absoluteValue < 20){
                velocity.y += velocity.y * 0.05f
            }
        }
    }
}