package A_D_S


var board = mutableListOf(
    mutableListOf("r","n","b","k","q","b","n","r"),
    mutableListOf("p","p","p","p","p","p","p","p"),
    mutableListOf(" "," "," "," "," "," "," "," "),
    mutableListOf(" "," "," "," "," "," "," "," "),
    mutableListOf(" "," "," "," "," "," "," "," "),
    mutableListOf(" "," "," "," "," "," "," "," "),
    mutableListOf("P","P","P","P","P","P","P","P"),
    mutableListOf("R","N","B","K","Q","B","N","R")
)

fun main() {
    while (true){
        draw(board)
        move(readln())
    }
}

fun move(m: String) {
    val x = m.filter { it.isDigit() }.split("")

    board[x[3].toInt()][x[4].toInt()] = board[x[1].toInt()][x[2].toInt()]
    board[x[1].toInt()][x[2].toInt()] = " "
}

fun draw(board: List<List<String>>){
    board.forEachIndexed { index, s ->
        println(",$s")
    }
}