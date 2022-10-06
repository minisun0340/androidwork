package com.example.kotlinwork.oop2

class FreeLancer:Employee{
    var grade:Int = 0
    constructor():super(){}
    constructor(name:String, age:Int, id:Int):super(name, age){
        this.grade = grade
    }
    override fun print(){
        super.print()
        println("등급:$grade")
    }
    override fun test(){
        println("FreeLancer클래스의 메소드")
    }

}