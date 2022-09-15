import processing.core.PApplet


fun main() {
    RandomPerlinNoiseWalker
}

object RandomPerlinNoiseWalker : PApplet() {
    init {
        this.setSize(400, 400)
        this.runSketch()
    }

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
        stroke(rx, gx, bx)
        ellipse(x, y, 20f, 20f)

        tx += 0.01f
        ty += 0.01f
        tr += 0.01f
        tg += 0.01f
        tb += 0.01f

        filter(BLUR, 1f);
    }
}
