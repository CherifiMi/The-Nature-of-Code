import processing.core.PApplet


fun main() {
    RandomPerlinNoiseWalker
}

object RandomPerlinNoiseWalker : PApplet() {
    init {
        this.setSize(400, 400)
        this.runSketch()
    }

    var filter: MutableList<Int> = mutableListOf(5)

    var x = width / 2f
    var y = height / 2f
    var rx = 255f
    var gx = 255f
    var bx = 255f

    var tx = random(500f, 5000f)
    var ty = random(500f, 5000f)
    var tr = random(500f, 5000f)
    var tg = random(500f, 5000f)
    var tb = random(500f, 5000f)

    override fun setup() {
        background(255)
    }

    override fun draw() {

        x = map(noise(tx), 0f, 1f, 0f, width.toFloat())
        y = map(noise(ty), 0f, 1f, 0f, height.toFloat())

        rx = map(noise(tr), 0f, 1f, 0f, 255f)
        gx = map(noise(tg), 0f, 1f, 0f, 255f)
        bx = map(noise(tb), 0f, 1f, 0f, 255f)


        fill(rx, gx, bx)
        stroke(2f, gx, bx)
        ellipse(x, y, 20f, 20f)

        tx += 0.01f
        ty += 0.01f
        tr += 0.01f
        tg += 0.01f
        tb += 0.01f

        when (filter[0]) {
            1 -> {
                filter(BLUR, 1f)
            }
            2 -> {
                filter(DILATE)
            }
            3 -> {
                filter(ERODE)
            }
            4 -> {
                filter(BLUR, 1f)
                filter(ERODE)
            }
            5 -> {
                filter(BLUR, 1f)
                filter(DILATE)
            }
            else -> {}
        }
    }

    override fun keyPressed() {
        when (key) {
            '0' -> filter[0] = 0
            '1' -> filter[0] = 1
            '2' -> filter[0] = 2
            '3' -> filter[0] = 3
            '4' -> filter[0] = 4
            '5' -> filter[0] = 5
            '6' -> filter[0] = 6
        }
    }
}
