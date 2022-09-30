import VectorstBounsingBall.random
import VectorstBounsingBall.background
import VectorstBounsingBall.ellipse
import VectorstBounsingBall.fill
import VectorstBounsingBall.height
import VectorstBounsingBall.stroke
import VectorstBounsingBall.width
import processing.core.PApplet
import processing.core.PVector

fun main(){
    VectorstBounsingBall
}

object VectorstBounsingBall : PApplet() {
    init {
        this.setSize(400, 400)
        this.runSketch()
    }
    lateinit var balls: MutableList<Ball>

    override fun setup() {
        balls = mutableListOf(Ball)
    }

    override fun draw() {
        for (b in balls){
            b.move()
            b.bounce()
            b.draw()
        }
    }
}

object Ball{
    //var pos = PVector(width/2f, height/2f)
    var pos = PVector(width/2f + random(-50f, 50f), height/2f+ random(-50f, 50f))
    var velocity = PVector(2.5f+ random(-3f,3f), -2f+ random(-3f,3f))

    fun move() {
        pos = pos.add(velocity)
    }

    fun draw() {
        background(100f)
        fill(255f)
        stroke(0f)
        ellipse(pos.x, pos.y, 20f, 20f)
    }

    fun bounce() {
        if (pos.x >= width.toFloat() || pos.x <= 0f){
            velocity.x = velocity.x*-1
        }
        if (pos.y >= height.toFloat() || pos.y <= 0f){
            velocity.y = velocity.y*-1
        }
    }
}