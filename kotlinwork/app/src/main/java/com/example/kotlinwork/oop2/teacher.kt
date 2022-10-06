package com.example.kotlinwork.oop2

class Teacher:Employee{
    var subject:String = ""
    constructor():super(){}
    constructor(name:String, age:Int, subject:String):super(name, age){
        this.subject = subject
    }
    override fun print(){
        super.print()
        println("담당과목:$subject")
    }
    override fun test(){
        println("teacher클래스의 메소드")
    }
}