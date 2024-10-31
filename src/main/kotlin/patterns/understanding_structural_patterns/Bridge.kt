package patterns.understanding_structural_patterns
//The Bridge design pattern is a great tool for avoiding the pitfalls of overusing inheritance and
//creating more flexible, maintainable code. It helps in separating abstractions from their
// implementations, allowing for better extensibility

interface Trooper1 {
    fun move(x: Long, y: Long)
    fun attackRebel(x: Long, y: Long)
    fun shout(): String
}

typealias PointsOfDamage = Long
typealias Meters = Int
const val RIFLE_DAMAGE: PointsOfDamage = 3L
const val REGULAR_SPEED: Meters = 1

interface Weapon {
    fun attack(x: Long, y: Long): PointsOfDamage
}
interface Legs {
    fun move(x: Long, y: Long): Meters
}


data class StormTrooper(
    private val weapon: Weapon,
    private val legs: Legs
) : Trooper1 {
    override fun move(x: Long, y: Long) {
        legs.move(x, y)
    }
    override fun attackRebel(x: Long, y: Long) {
        weapon.attack(x, y)
    }

    override fun shout(): String {
        TODO("Not yet implemented")
    }
}

//Now, we can provide some implementations for our interfaces:
class Rifle : Weapon {
    override fun attack(x: Long, y: Long) = RIFLE_DAMAGE
}
class Flamethrower : Weapon {
    override fun attack(x: Long, y: Long)= RIFLE_DAMAGE * 2
}
class Batton : Weapon {
    override fun attack(x: Long, y: Long)= RIFLE_DAMAGE * 3
}

//Next, we’ll see how we can make the following legs move:
class RegularLegs : Legs {
    override fun move(x: Long, y: Long) = REGULAR_SPEED
}
class AthleticLegs : Legs {
    override fun move(x: Long, y: Long) = REGULAR_SPEED * 2
}

fun runBridge(){
    val stormTrooper = StormTrooper(Rifle(), RegularLegs())
    val flameTrooper = StormTrooper(Flamethrower(), RegularLegs())
    val scoutTrooper = StormTrooper(Rifle(), AthleticLegs())

    println(listOf(stormTrooper, flameTrooper, scoutTrooper))
}
