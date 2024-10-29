package patterns.understanding_structural_patterns

open class StarTrekRepository {

    private val starshipCaptains = mutableMapOf("USS Enterprise" to "Jean-Luc Picard")

    open fun getCaptain(starshipName: String): String {
        return starshipCaptains[starshipName] ?: "Unknown"
    }

    open fun addCaptain(starshipName: String, captainName: String) {
        starshipCaptains[starshipName] = captainName
    }

}

class LoggingGetCaptainStarTrekRepository: StarTrekRepository(){
    override fun getCaptain(starshipName: String): String {
        return super.getCaptain(starshipName)
    }
}

fun runDecorator(){
    val name = LoggingGetCaptainStarTrekRepository().getCaptain("")
    println(name)
}