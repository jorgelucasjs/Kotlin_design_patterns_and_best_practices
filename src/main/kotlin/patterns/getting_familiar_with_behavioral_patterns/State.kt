package patterns.getting_familiar_with_behavioral_patterns

interface WhatCanHappen {
    fun seeHero()
    fun getHit(pointsOfDamage: Int)
    fun calmAgain()
}

class Snail : WhatCanHappen {

    private var mood: Mood = Still

    private var healthPoints = 10
    override fun seeHero() {
        mood = when(mood) {
            is Still -> Aggressive
            else -> mood
        }
    }
    override fun getHit(pointsOfDamage: Int) {
        healthPoints -= pointsOfDamage
        mood = when {
            (healthPoints <= 0) -> Dead
            mood is Aggressive -> Retreating
            else -> mood
        }
    }
    override fun calmAgain() {
    }
}
//Now, we can declare the Mood class, which we will mark with the sealed keyword:
sealed interface Mood {
// Abstract methods here, like draw(), for instance
}

data object Still : Mood
data object Aggressive : Mood
data object Retreating : Mood
data object Dead : Mood

