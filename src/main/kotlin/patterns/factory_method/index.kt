package patterns.factory_method
import java.lang.IllegalArgumentException

interface ChessPiece {
    val file: Char
    val rank: Char
}

data class Pawn(
    override val file: Char,
    override val rank: Char
) : ChessPiece

data class Queen(
    override val file: Char,
    override val rank: Char
) : ChessPiece


fun createPiece(notation: String): ChessPiece {

    val (type, file, rank) = notation.toCharArray()
    return when(type){
        'q' -> Queen(file, rank)
        'p' -> Queen(file, rank)
        else -> throw IllegalArgumentException("Unknown piece: $type")
    }

//The above code could be written more explicitly as:
// val type = notation.toCharArray()[0]
// val file = notation.toCharArray()[1]
// val rank = notation.toCharArray()[2]

}

fun factoryMethod(){
    val notations = listOf("pa8", "qc3",)
    val pieces = mutableListOf<ChessPiece>()

    for (n in notations) {
        pieces.add(createPiece(n))
    }

    println(pieces)

}

class Server(port: Long) {
    init {
        println("Server started on port $port")
    }
    companion object {
        fun withPort(port: Long) = Server(port)
    }
}

//page -> 55
//val server = Server(8080)
val server = Server.withPort(8080)