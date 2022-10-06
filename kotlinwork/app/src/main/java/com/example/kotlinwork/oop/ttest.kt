package com.example.kotlinwork.oop

fun main() {
    val obj1:ana = ana("ana")
    obj1.print()
}

class ana(var name:String, var age:Int){
    constructor(name:String):this(name, 30){
        this.age = age
    }
    fun print(){
        println("name:$name, age:$age")
    }
}