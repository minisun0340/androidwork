package com.example.kotlinwork.oop3

fun main() {
    val mymovie2 = Video("변호인", "sf")
    mymovie2.totalPrice()
    mymovie2.show()
}

/* 내가 한 것
class Video:Content{
    var genre:String = ""
    constructor(title:String, genre:String):super(title){
        this.genre = genre
    }
    override fun totalPrice() {
        if (genre.equals("new")) {
            super.price = 2000
        }
        else if (genre.equals("comic")) {
            super.price = 1500
        }
        else if (genre.equals("child")) {
            super.price = 1000
        }
        else {
            super.price = 500
        }
    }
}
*/

class Video:Content{
    var genre:String=""
    constructor(title:String,genre:String):super(title){
        this.genre = genre
    }

    override fun totalPrice() {
        price = when(genre){
            "new" -> 2000
            "comic" -> 1500
            "child" -> 1000
            else -> 500
        }
    }
}