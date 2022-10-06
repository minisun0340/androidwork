package com.example.kotlinwork.oop

class Student{
    var name:String = ""
    var age:Int = 0
    var id:Int = 0
    constructor(){

    }
    constructor(name:String, age:Int, id:Int){
        this.name = name
        this.age = age
        this.id = id
    }
    fun print(){
        println("이름:$name 나이:$age 학번:$id")
    }

}