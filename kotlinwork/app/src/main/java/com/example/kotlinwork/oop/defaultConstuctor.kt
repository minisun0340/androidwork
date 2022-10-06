package com.example.kotlinwork.oop

fun main() {
    val obj1 = Emp3("이민호", 25, 10)
    println("================================")
    val obj2 = Emp3("BTS")
}
//2. 코틀린은 주 생성자(기본생성자)를 정의하고 사용할 수 있다.
//기본생성자 정의 방법
//class 클래스명 constructor(...)
//              --------------
//              기본생성자
class Emp2 constructor(name:String, age:Int, telNum:Int){

}
//클래스를 선언하면서 기본생성자를 바로 정의하는 경우 constructor 키워드를 생략할 수 있다.
//기본생성자에 정의하는 매개변수는 자동으로 멤버변수로 등록된다.
//깁ㄴ생성자를 정의하면 매개변수 없는 생성자는 제공되지 않는다.
class Emp3(var name:String, var age:Int, var telNum:Int){
    init{
        println("init코드 실행")
        println("name:$name")
        println("age:$age")
        println("telNum:$telNum")
    }
    //기본생성자 이외에 추가하는 생성자를 보조생성자라고 한다.
    //Emp3클래스에는 생성자?? 2개
    //보조생성자에서 기본생성자를 호출할 수 있다.
    //constructor(.., .., ..):this(.., .., ..)
    constructor(name:String):this(name, 40, 11){
     println("보조생성자 호출")
    }
    //기본생성자를 정의하는 경우 보조생성자를 정의할 때 반드시 기본생성자를 호출해서 값을 셋팅해야 한다.
    constructor(name:String, age:Int):this(name, age, 10111777){
        this.name = name
        this.age = age
    }
}

//1. 생성자 정의 - 기본방법
    class Emp{
    var name = ""
    var telNum = 0
    var age = 0
    constructor(){

    }
    constructor(name: String, telNum: Int, age: Int) {
        this.name = name
        this.telNum = telNum
        this.age = age
    }
}