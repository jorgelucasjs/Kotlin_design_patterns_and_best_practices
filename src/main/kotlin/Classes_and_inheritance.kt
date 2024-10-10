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
