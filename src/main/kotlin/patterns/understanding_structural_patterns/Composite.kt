package patterns.understanding_structural_patterns

interface Trooper {
    fun move(x: Long, y: Long)
    fun attackRebel(x: Long, y: Long)
    fun retreat() {
        println("Retreating!")
    }
}

class Squad(private val units: List<Trooper>): Trooper  {
    override fun move(x: Long, y: Long) {
        for (u in units) {
            u.move(x, y)
        }
    }
    override fun attackRebel(x: Long, y: Long) {
        for (u in units) {
            u.attackRebel(x, y)
        }
    }

    override fun retreat() {

    }
}

//==============[Secondary constructors]==================
//class Squad(private val units: List<Trooper>): Trooper {
//    constructor(): this(listOf())
//    constructor(t1: Trooper): this(listOf(t1))
//    constructor(t1: Trooper, t2: Trooper): this(listOf(t1, t2))
//}

fun runComposite(){



}