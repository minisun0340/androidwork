package com.example.kotlinwork.oop

class Teacher{
    var name:String = ""
    var age:Int = 0
    var subject:String = ""
    constructor(){
    }
    constructor(name:String, age:Int, subject:String){
        this.name = name
        this.age = age
        this.subject = subject
    }
    fun print(){
        println("이름:$name 나이:$age 담당과목:$subject")
    }

}