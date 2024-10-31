package patterns.getting_familiar_with_behavioral_patterns

open class Trooper {
    fun move(x: Int, y: Int) {
        println("Moving to $x:$y")
    }
}

class Squad(private val units: List<Trooper>) : Trooper() {
    constructor(vararg units: Trooper) : this(units.toList())

    operator fun iterator() = object: Iterator<Trooper> {
        override fun hasNext(): Boolean = TODO()
        override fun next(): Trooper = TODO()

        private var i = 0
    }

}

val platoon = Squad(Trooper(), Squad(Trooper()), Trooper(), Squad(Trooper(), Trooper()), Trooper())

