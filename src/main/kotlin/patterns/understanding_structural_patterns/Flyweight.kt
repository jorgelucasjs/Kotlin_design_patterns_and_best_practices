package patterns.understanding_structural_patterns

import java.io.File

enum class Direction {
    LEFT,
    RIGHT
}

object SnailSprites {
    val sprites = List(8) { i ->
        java.io.File(when (i) {
            0 -> "snail-left.jpg"
            1 -> "snail-right.jpg"
            in 2..4 -> "snail-move-left-${i-1}.jpg"
            else -> "snail-move-right${(4-i)}.jpg"
        })
    }
}

class TansanianSnail {
    val directionFacing = Direction.LEFT
    val sprites = SnailSprites.sprites
}