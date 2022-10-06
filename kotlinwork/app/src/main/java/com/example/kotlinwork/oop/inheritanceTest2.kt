package com.example.kotlinwork.oop

fun main() {
    var obj = Sub("장동건", 50)
    println("name:${obj.name}")
    println("age:${obj.age}")
}

open class Super(var name:String){
    init{
        println("test super")
    }
}
/*
class Sub(var subname:String, var age:Int):Super(subname){
    fun display(){
        println("test sub")
    }
}*/
class Sub:Super{
    var age:Int = 0
    constructor(name:String, age:Int):super(name){
        this.age = age
    }
    init{
        println("test sub")
    }
}