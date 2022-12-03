package IIII_oscillation

import processing.core.PApplet
import processing.core.PApplet.constrain
import processing.core.PConstants.CENTER
import processing.core.PVector

fun main(){
    AMUR
}

object AMUR : PApplet() {
    init {
        this.setSize(400, 400)
        this.runSketch()
    }

    var ms = mutableListOf<Mover>()

    override fun setup() {
        ms.add(Mover(width / 2f, height / 2f, 20f, true))

        for (i in 1..20){
            ms.add(Mover(random(width.toFloat()), random(height.toFloat()), random(.1f, 2f)))
        }
    }

    override fun draw() {

        rectMode(CORNER)
        noStroke()
        fill(255f,5f)
        rect(0f,0f,width.toFloat(),height.toFloat())
        for (m in ms) {
            val gravity = PVector.sub(ms[0].loc, m.loc)
            val distance = constrain(gravity.mag(), 5f, 25f)
            val p = (.4f * m.mass * ms[0].mass) / (distance * distance)
            gravity.normalize()
            gravity.mult(p)

            if (!m.isAttractor){
                m.applyForce(gravity)
            }
            m.update()
            m.display()
        }

    }
}

class Mover(x: Float, y: Float, m: Float, b: Boolean = false) {
    val loc = PVector(x, y)
    val velocity = PVector()
    var acceleration = PVector()

    var angle = 0f
    var aVelocity = 0f
    var aAcceleration = 0f

    val mass = m
    val isAttractor = b

    fun update() {
        velocity.add(acceleration)
        loc.add(velocity)

        aAcceleration = acceleration.x/10
        aVelocity += aAcceleration
        aVelocity = constrain(aVelocity,-0.1f,0.1f)
        angle += aVelocity


        acceleration.mult(0f)
    }

    fun display() {

        AMUR.strokeWeight(2f)
        if (isAttractor){
            AMUR.stroke(0)
            AMUR.fill(175f,200f)
            AMUR.ellipse(loc.x, loc.y,  mass,  mass)
        }else{
            AMUR.stroke(0)
            AMUR.fill(175f,200f)
            AMUR.rectMode(CENTER)
            AMUR.pushMatrix()
            AMUR.translate(loc.x ,loc.y)
            AMUR.rotate(angle)
            AMUR.rect(0f,0f,mass*16,mass*16)
            AMUR.popMatrix()
        }
    }


    fun applyForce(force: PVector) {
        val f = PVector.div(force,mass)
        acceleration.add(f)
    }

}