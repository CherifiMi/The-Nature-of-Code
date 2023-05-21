package IIII_oscillation

import processing.core.PApplet
import processing.core.PVector
import kotlin.math.cos
import kotlin.math.sin

fun main(){
    RealPendulum
}

object RealPendulum : PApplet() {
    init {
        this.setSize(400, 400)
        this.runSketch()
    }

    val P = Pend(PVector(width/2f, 50f), 200f)

    override fun setup() {

    }

    override fun draw() {
        background(255)
        P.update()
        P.display()
    }
}

class Pend(var origin: PVector, var r : Float) {
    var angle = 10f
    var aVelocity = 0f
    var aAcceleration = 0f
    var gravity = 0.4
    var location = PVector()
    var dumping = 0.995f

    fun update(){
        aAcceleration = ((-1* gravity/r )* sin(angle)).toFloat()
        aVelocity += aAcceleration
        angle += aVelocity

        aVelocity *= dumping

        location.set(r* sin(angle), r* cos(angle))
        location.add(origin)
    }

    fun display() {
        with(RealPendulum){
            stroke(0)
            strokeWeight(2f)
            line(origin.x, origin.y,location.x, location.y)

            if (mousePressed && mouse_near_ball()) {
                fill(0)

                aVelocity = 0f

                if (location.x-mouseX > 10){
                    aVelocity = - 0.1f
                }


                if (mouseX- location.x > 10){
                    aVelocity = + 0.1f
                }

                /*if (location.x == mouseX.toFloat()){
                    aVelocity = 0f
                }
                else if (mouseX > location.x){
                    aVelocity -= 1f
                }
                else if (mouseX<location.x){
                    aVelocity -= 1f
                }*/

            }  else {
                fill(175)
            }


            ellipse(location.x, location.y, 40f,40f)
        }
    }

    private fun mouse_near_ball(): Boolean {
        with(RealPendulum){
            if (
                mouseX <= location.x + 25 && mouseX >= location.x -25
                &&
                mouseY <= location.y + 25 && mouseY >= location.y -25
            ){
                return true
            }
            return false
        }
    }
}