package patterns.singleton

object NoMoviesList

object Logger {
    init {
        println("I was accessed for the first time")
// Initialization logic goes here
    }
// More code goes here
}

//pag ->47




fun printMovies(movies: List<String>) {
    for (m in movies) {
        println(m)
    }
}


fun  singletonPattern(){
    val myFavoriteMovies = NoMoviesList
    val yourFavoriteMovies = NoMoviesList
    //println(myFavoriteMovies === yourFavoriteMovies)
    //printMovies(myFavoriteMovies)


}