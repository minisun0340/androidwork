package com.example.kotlinwork.oop2

class Staff:Employee{
    var dept:String = ""
    constructor():super(){}
    constructor(name:String, age:Int, dept:String):super(name, age){
        this.dept = dept
    }

    override fun print(){
        super.print()
        println("부서:$dept")
    }
    override fun test(){
        println("staff클래스의 메소드")
    }

}