package test

import I_randomnes.RandomPerlinNoiseWalker
import processing.core.PApplet
import processing.core.PVector
import java.util.Random
import java.util.random.RandomGeneratorFactory.all
import kotlin.coroutines.ContinuationInterceptor
import kotlin.math.roundToInt

fun main(){
    snk
}

object snk : PApplet() {
    init {
        this.setSize(400, 400)
        this.runSketch()
    }

    val loc = PVector()
    var tale = 0
    val food = PVector( random(0f,19f).roundToInt().toFloat(), random(0f,19f).roundToInt().toFloat())
    var dir = 'd'

    override fun draw() {
        frameRate(5f+tale)
        background(0)

        when (dir) {
            'd' -> loc.x+=1
            'a' -> loc.x-=1
            's' -> loc.y+=1
            'w' -> loc.y-=1
        }


        fill(255f,0f,0f)
        rect(food.x*20f, food.y*20f, 20f,20f)

        fill(255)
        rect(loc.x*20f,loc.y*20f,20f,20f)

        for(i in 1..tale){
            fill(200)
            rect((loc.x)*20f,(loc.y+i)*20f,20f,20f)
        }

        for (i in 1..20){
            for (j in 1..20){
                stroke(0f,255f,0f)
                line(0f, i.toFloat()*20f, 400f,i.toFloat()*20f)
                line(j.toFloat()*20f,0f , j.toFloat()*20f,400f)
            }
        }

        edge()

        if (loc==food){
            food.x = random(0f,19f).roundToInt().toFloat()
            food.y = random(0f,19f).roundToInt().toFloat()

            tale++
        }




    }

    fun edge(){
        when {
            loc.x > 20 -> {
                loc.x = 0f
            }
            loc.x < 0 -> {
                loc.x = 20f
            }
            loc.y > 20 -> {
                loc.y = 0f
            }
            loc.y < 0 -> {
                loc.y = 20f
            }
        }
    }

    override fun keyPressed() {
        when (key) {
            'd' -> dir = 'd'
            'a' -> dir = 'a'
            's' -> dir = 's'
            'w' -> dir = 'w'
        }
    }


}