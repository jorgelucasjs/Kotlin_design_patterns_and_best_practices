import kotlin.random.Random


//class Player(){
//
//    var name: String = ""
//
//    fun getName(): String {
//        return name
//    }
//
//    fun setName(name: String){
//        this.name = name
//    }
//
//}


//Custom setters and getters
class Player2(val name: String){

    var score: Int = 0

        set(value){
            field = if(value >= 0){
                value
            }else{
                0
            }

        }
}


class Player: DiceRoller{

    override fun rollDice(): Int = Random.nextInt(0, 6)

}


//======{ Inheritance }=====
open class ActivePlayer(name: String) {

}

class ConfusedPlayer(name: String ):ActivePlayer(name)


//==========Data classes==============

data class User(val username: String, private val password: String){
    fun hidePassword() = "*".repeat(password.length)
}

//============[Extension functions]=============
fun String.hidePassword() = "*".repeat(this.length)



fun run(){
    val password: String = "secretpassword"
    println("Password: ${password.hidePassword()}")
}



















