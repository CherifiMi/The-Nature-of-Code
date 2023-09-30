package IIII_oscillation

import processing.core.PApplet
import processing.core.PApplet.radians
import processing.core.PVector
import kotlin.math.*

fun main(){
    RealPendulum
}

object RealPendulum : PApplet() {
    init {
        this.setSize(400, 400)
        this.runSketch()
    }

    var originM = PVector(width/2f, 100f)
    val P = Pend(originM, 200f)

    override fun setup() {

    }

    override fun draw() {
        background(255)
        P.go()
    }

    override fun mousePressed() {
        if (mousePressed && P.mouse_near_ball()){
            P.isStuck = true
        }
    }
    override fun mouseReleased() {
        P.isStuck = false
    }
}

class Pend(var origin: PVector, var r : Float) {
    var angle = 300f
    var aVelocity = 0f
    var aAcceleration = 0f
    var gravity = 0.4f
    var location = PVector()
    var dumping = 0.997f

    var isStuck = false

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

            if (isStuck) {
                fill(0)

                //aVelocity = 0f

                var c2 = PVector.sub(origin,PVector(mouseX.toFloat(), mouseY.toFloat()))
                angle = atan2(-1*c2.y,c2.x) - radians(90f)

            }  else {
                fill(175)
            }


            ellipse(location.x, location.y, 40f,40f)
        }
    }

    fun mouse_near_ball(): Boolean {
        with(RealPendulum){
            var x = abs(mouseX-location.x)
            var y = abs(mouseY-location.y)

            if (x<24 && y<25){
                return true
            }
            return false
        }
    }

    fun go() {
        update()
        display()
    }
}