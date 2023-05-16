
import Chess2.drawBoard
import Chess2.drawHighlight
import Chess2.drawPieces
import processing.core.PApplet


fun main() {
    chess
}

object chess : PApplet() {

    init {
        this.setSize(400, 400)
        this.runSketch()
    }
    override fun setup() {

    }

    override fun draw() {

        Chess2.let {
            background(0)
            drawBoard()
            textSize(50f)
            translate(12f, 40f)
            drawHighlight()
            drawPieces()
        }



    }
    override fun mouseClicked() {
        Chess2.apply {
            boxX = mouseY / 50
            boxY = mouseX / 50
            board[boxX][boxY].let {
                if(it!= " ") {
                    piece = it
                    pieceX = boxX
                    pieceY = boxY
                }
            }
            piece = board[boxX][boxY]
            movePiece(boxX, boxY)
            possibleMoves()
        }
    }
}


object Chess2{
    var board = mutableListOf(
        mutableListOf("r", "n", "b", "k", "q", "b", "n", "r"),
        mutableListOf("p", "p", "p", "p", "p", "p", "p", "p"),
        mutableListOf(" ", " ", " ", " ", " ", " ", " ", " "),
        mutableListOf(" ", " ", " ", " ", " ", " ", " ", " "),
        mutableListOf(" ", " ", " ", " ", " ", " ", " ", " "),
        mutableListOf(" ", " ", " ", " ", " ", " ", " ", " "),
        mutableListOf("P", "P", "P", "P", "P", "P", "P", "P"),
        mutableListOf("R", "N", "B", "K", "Q", "B", "N", "R")
    )

    var highlight = mutableListOf(
        mutableListOf(" ", " ", " ", " ", " ", " ", " ", " "),
        mutableListOf(" ", " ", " ", " ", " ", " ", " ", " "),
        mutableListOf(" ", " ", " ", " ", " ", " ", " ", " "),
        mutableListOf(" ", " ", " ", " ", " ", " ", " ", " "),
        mutableListOf(" ", " ", " ", " ", " ", " ", " ", " "),
        mutableListOf(" ", " ", " ", " ", " ", " ", " ", " "),
        mutableListOf(" ", " ", " ", " ", " ", " ", " ", " "),
        mutableListOf(" ", " ", " ", " ", " ", " ", " ", " ")
    )

    var box = " "
    var boxX = 0
    var boxY = 0

    var piece  = " "
    var pieceX  = 0
    var pieceY  = 0

    fun drawBoard() {
        chess.apply {
            for (i in 0..7) {
                for (j in 0..7) {
                    if (
                        j % 2 == 0 && i % 2 == 0
                        ||
                        j % 2 != 0 && i % 2 != 0
                    ) {
                        fill(240f)
                        rect(i * 50f, j * 50f, 50f, 50f)
                    } else {
                        fill(0f,55f,100f)
                        rect(i * 50f, j * 50f, 50f, 50f)
                    }
                }
            }
        }
    }


    fun movePiece(x: Int, y: Int) {
        if (highlight[x][y] == "0")
        {
            board[x][y] = piece
            board[pieceX][pieceY] = " "
        }
    }

    fun highlight(a: Int, b: Int) {
        if (
            a in 0..7 && b in 0..7
            &&
            "$a$b" != "$boxX$boxY"
        ) {
            highlight[a][b] = "0"
        }
    }

    fun possibleMoves() {
        cleanHighlight()
        when (piece) {
            "p" -> {
                highlight(boxX + 1, boxY)
                if (boxX == 1) {
                    highlight(boxX + 2, boxY)
                }
            }
            "P" -> {
                highlight(boxX - 1, boxY)
                if (boxX == 6) {
                    highlight(boxX - 2, boxY)
                }
            }
            "K", "k" -> {
                highlight(boxX + 1, boxY)
                highlight(boxX - 1, boxY)

                highlight(boxX, boxY + 1)
                highlight(boxX, boxY - 1)

                highlight(boxX + 1, boxY + 1)
                highlight(boxX + 1, boxY - 1)
                highlight(boxX - 1, boxY + 1)
                highlight(boxX - 1, boxY - 1)
            }
            "q", "Q" -> {
                for (i in 0..7) {
                    for (j in 0..7) {
                        if (boxX == i) highlight(i, j)
                        if (boxY == j) highlight(i, j)
                        if (i - boxX == j - boxY) highlight(i, j)
                        if (boxX - i == j - boxY) highlight(i, j)
                    }
                }
            }
            "B", "b" -> {
                for (i in 0..7) {
                    for (j in 0..7) {
                        if (i - boxX == j - boxY) highlight(i, j)
                        if (boxX - i == j - boxY) highlight(i, j)
                    }
                }
            }
            "r", "R" -> {
                for (i in 0..7) {
                    for (j in 0..7) {
                        if (boxX == i) highlight(i, j)
                        if (boxY == j) highlight(i, j)
                    }
                }
            }
            "n", "N" -> {
               highlight(boxX + 2, boxY + 1)
               highlight(boxX - 2, boxY + 1)
               highlight(boxX + 2, boxY - 1)
               highlight(boxX - 2, boxY - 1)

               highlight(boxX + 1, boxY - 2)
               highlight(boxX - 1, boxY - 2)
               highlight(boxX + 1, boxY + 2)
               highlight(boxX - 1, boxY + 2)
            }
        }
    }

    fun drawHighlight() {
        chess.apply {
            for (i in 0..7) {
                for (j in 0..7) {
                    highlight[i][j].let {
                        fill(0f, 255f, 0f)
                        text(it, 50f * j, 50f * i)
                    }
                }
            }
        }
    }

    fun drawPieces() {
        chess.apply {
            for (i in 0..7) {
                for (j in 0..7) {
                    board[i][j].let {
                        it.filter { it.isLowerCase() }.let {
                            fill(0f, 0f, 255f)
                            text(it, 50f * j, 50f * i)
                        }
                        it.filter { !it.isLowerCase() }.let {
                            fill(255f, 0f, 0f)
                            text(it, 50f * j, 50f * i)
                        }
                    }
                }
            }
        }
    }

    fun cleanHighlight() {
        for (i in 0..7) {
            for (j in 0..7) {
                highlight[i][j] = " "
            }
        }
    }
}