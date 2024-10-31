package patterns.getting_familiar_with_behavioral_patterns

//The goal of the Strategy design pattern is to allow an object to alter its behavior at runtime.

enum class Direction {
    LEFT, RIGHT
}

interface Weapon {
    fun shoot(x: Int, y: Int, direction: Direction): Projectile
}

data class Projectile(
    private var x: Int,
    private var y: Int,
    private var direction: Direction
)

class OurHero1 {
    private var direction = Direction.LEFT
    private var x: Int = 42
    private var y: Int = 173
    fun shoot(): Projectile {
        return Projectile(x, y, direction)
    }
}

// Flies straight
class Peashooter : Weapon {

    override fun shoot(x: Int, y: Int, direction: Direction) = Projectile(x, y, direction)

}

// Returns back after reaching end of the screen
class Banana : Weapon {
    override fun shoot(x: Int, y: Int, direction: Direction) = Projectile(x, y, direction)


}

fun equip(weapon: Weapon) {
    currentWeapon = weapon
}

private var currentWeapon: Weapon = Peashooter()

//============Functions as first-class citizens==========
val x = 7

val square = fun(x: Int): Long {
    return (x * x).toLong()
}

val result = square(5)

object Weapons {
    // Flies straight
    fun peashooter(x: Int, y: Int, direction: Direction):
            Projectile {
        return Projectile(x, y, direction)
    }

    // Returns back after reaching end of the screen
    fun banana(x: Int, y: Int, direction: Direction):
            Projectile {
        return Projectile(x, y, direction)
    }
// Other similar implementations here
}

class OurHero {

    private var direction = Direction.LEFT
    private var x: Int = 42
    private var y: Int = 173
    var currentWeapon = Weapons::peashooter

    val shoot = fun() {
        currentWeapon(x, y, direction)
    }
}


fun runStrategy(){
    val hero = OurHero()
    hero.shoot()
    hero.currentWeapon = Weapons::banana
    hero.shoot()
}















