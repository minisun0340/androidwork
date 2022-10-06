package com.example.kotlinwork.oop

fun main() {
    val mymovie:Movie = Movie("어거스트러쉬", "Drama")
    val mymovie2:Movie = Movie("나는 전설이다", "SF")
    mymovie.print()
    mymovie2.print()
}

class Movie{
    var title:String = ""
    var genre:String = ""
    constructor(){
        //기본생성자
    }
    constructor(title:String, genre:String){
        //멤버변수 초기화 생성자
        this.title = title
        this.genre = genre
    }
    fun print(){
        println("$title($genre) 상영중입니다.")
    }
}