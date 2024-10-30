package patterns.understanding_structural_patterns
//The Bridge design pattern is a great tool for avoiding the pitfalls of overusing inheritance and
//creating more flexible, maintainable code. It helps in separating abstractions from their
// implementations, allowing for better extensibility

interface Trooper {
    fun move(x: Long, y: Long)
    fun attackRebel(x: Long, y: Long)
    fun shout(): String
}

open class StormTrooper : Trooper {
    override fun move(x: Long, y: Long) {
        // Move at normal speed
    }

    override fun attackRebel(x: Long, y: Long) {
        // Missed most of the time
    }
}

open class ShockTrooper : Trooper {
    override fun move(x: Long, y: Long) {
        // Moves slower than regular StormTrooper
    }

    override fun attackRebel(x: Long, y: Long) {
        // Sometimes hits
    }
}

class RiotControlTrooper: StormTrooper(){
    override fun attackRebel(x: Long, y: Long) {
        // Has an electric baton, stay away!
    }
}

class FlameTrooper : ShockTrooper() {
    override fun attackRebel(x: Long, y: Long) {
        // Uses flametrower, dangerous!
    }
}

class ScoutTrooper : ShockTrooper() {
    override fun move(x: Long, y: Long) {
        // Runs faster
    }
}