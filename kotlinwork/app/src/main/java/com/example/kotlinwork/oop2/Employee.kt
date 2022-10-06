package com.example.kotlinwork.oop2
// Student, Teacher, Staff의 공통기능과 속성을 Employee클래스에 정의
open abstract class Employee {
    var name:String = ""
    var age:Int = 0
    constructor(){}
    constructor(name:String, age:Int){
        this.name = name
        this.age = age
    }
    open fun print(){
        print("이 름:$name 나 이:$age")
    }
    // 메소드의 내용이 없는 메소드 -> 추상메소드로 정의
    // 추상 메소드를 정의하는 경우 메소드 선언부에 abstract
    // 추상 메소드를 갖고 있는 클래스는 추상클래스가 되므로 클래스 선언부에도 abstract를 추가해야 한다.
    open abstract fun test()
}