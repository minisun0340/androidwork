package com.example.kotlinwork.oop

class Staff{
    var name:String = ""
    var age:Int = 0
    var dept:String = ""
    constructor(){

    }
    constructor(name:String, age:Int, dept:String){
        this.name = name
        this.age = age
        this.dept = dept
    }
    fun print(){
        println("이름:$name 나이:$age 부서:$dept")
    }

}