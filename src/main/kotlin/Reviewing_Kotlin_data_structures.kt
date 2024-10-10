
fun reviewingKotlinDatastructures(){
    //lists, sets, and maps.
    // ================= lists =============
    //val hobbits = listOf("Frodo", "Sam", "Pippin", "Merry")
    //val hobbits: List<String> = listOf("Frodo", "Sam", "Pippin", "Merry")

    // ============= Sets =============
    //A set in Kotlin represents a collection of unique elements.
    val footballChampions = setOf("Brazil", "France", "Brazil", "Italy", "Spain", "Germany", "France")

    //println(footballChampions)
    //println("Israel" in footballChampions)
    //println("Italy" in footballChampions)

    //================ Maps =============
    //In Kotlin, a map is a collection that holds key-value pairs, with each key being unique

    val movieBatmans = mapOf(
        "Batman Returns" to "Michael Keaton",
        "Batman Forever" to "Val Kilmer",
        "Batman & Robin" to "George Clooney"
    )

    println(movieBatmans)

    //To access a value from the map using its key, we use square brackets and provide the key:
    println(movieBatmans["Batman Returns"])
    //These data structures also support checking whether an element does not exist:
    println("Batman Begins" in movieBatmans)

    //==================[Mutability]=================
    val editableHobbits = mutableListOf("Frodo", "Sam", "Pippin", "Merry")
    editableHobbits.add("Bilbo")

    //===================[Arrays]=================
    val musketeers: Array<String> = arrayOf("Athos", "Porthos", "Aramis")

    for(c in musketeers){
        println(c)
    }





}

