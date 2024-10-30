package patterns.understanding_structural_patterns
//
//open class StarTrekRepository {
//
//    private val starshipCaptains = mutableMapOf("USS Enterprise" to "Jean-Luc Picard")
//
//    open fun getCaptain(starshipName: String): String {
//        return starshipCaptains[starshipName] ?: "Unknown"
//    }
//
//    open fun addCaptain(starshipName: String, captainName: String) {
//        starshipCaptains[starshipName] = captainName
//    }
//
//}
//
//class LoggingGetCaptainStarTrekRepository : StarTrekRepository() {
//    override fun getCaptain(starshipName: String): String {
//        return super.getCaptain(starshipName)
//    }
//}
//
//class ValidatingAddCaptainStarTrekRepository : StarTrekRepository() {
//    override fun addCaptain(starshipName: String, captainName: String) {
//        if(captainName.length >15){
//            throw RuntimeException("$captainName is longer than 15 characters!")
//        }
//        super.addCaptain(starshipName, captainName)
//    }
//}
//
//
//fun runDecorator() {
//    val name = LoggingGetCaptainStarTrekRepository().getCaptain("")
//    println(name)
//}

//convert our StarTrekRepository class into an interface:
interface StarTrekRepository {
    fun getCaptain(starshipName: String): String
    fun addCaptain(starshipName: String, captainName: String)
}

class DefaultStarTrekRepository: StarTrekRepository {
    private val starshipCaptains = mutableMapOf("USS Enterprise" to "Jean-Luc Picard")

    override fun getCaptain(starshipName: String): String {
        return starshipCaptains[starshipName] ?: "Unknown"
    }

    override fun addCaptain(starshipName: String, captainName: String) {
        starshipCaptains[starshipName] = captainName
    }
}

//Let’s proceed with implementing the Decorator pattern using the by keyword:
class LoggingGetCaptain(private val repository: StarTrekRepository):
    StarTrekRepository by repository {
    override fun getCaptain(starshipName: String): String {
        println("Getting captain for $starshipName")
        return repository.getCaptain(starshipName)
    }
}

class ValidatingAdd(private val repository: StarTrekRepository):
    StarTrekRepository by repository {
    private val maxNameLength = 15
    override fun addCaptain(starshipName: String, captainName: String) {
        require (captainName.length < maxNameLength) {
            "$captainName name is longer than $maxNameLength characters!"
        }
        repository.addCaptain(starshipName, captainName)
    }
}

fun runDecorator() {

    val starTrekRepository = DefaultStarTrekRepository()
    val withValidating = ValidatingAdd(starTrekRepository)
    val withLoggingAndValidating = LoggingGetCaptain(withValidating)

    // Will print: Getting captain for...

    val captain = withLoggingAndValidating.getCaptain("USS Enterprise")
    withLoggingAndValidating.addCaptain("USS Voyager", "Kathryn Janeway")

    println(captain)

}

//===== [Operator overloading] =====









