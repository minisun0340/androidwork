package com.example.kotlinwork.oop

fun main() {
    val obj1:Customer = Customer() //매개변수가 없는 생성자를 호출하며 객체를 생성
    obj1.name = "이민호" //Customer클래스에 동으로 생성되는 setter 메소드를 호출(setName)
    println("성명:${obj1.name}") //Customer클래스에 동으로 생성되는 getter 메소드를 호출(getName)
    val obj2:Customer = Customer("장동건", 20)
    val obj3:Customer = Customer("장동건", 20, "010")
    obj1.print()
    obj2.print()
    obj3.print()
}

//생성자작성 방법 - 1.기본방법
/*
* 생성자는 매개변수 갯수, 매개변수 타입을 다르게 추가해서 여러개를 정의할 수 있다.
* 클래스 내부에 생성자를 정의하지 않으면 매개변수가 없는 생성자가 제공된다.
* 클래스를 정의하면 코틀린 내부에서 자바코드로 변환될 때 자동으로 setter/getter메소드가 만들어진다.
*/
class Customer{
    var name=""
    var age:Int = 0
    var telNum = ""
    init{
        //객체가 생성될 때 실행해야 하는 기능 - 코틀린에서는 생성자에 멤버변수 초기화를 정의한다.
        println("객체가 생성될 때 처리해야 하는 일들을 정의")
    }
    constructor(){
        println("매개변수가 없는 생성자")
    }
    constructor(name:String, age:Int){ //매개변수는 val키워드로 정의된 것과 동일
        //생성자 내부에서 멤버변수의 값을 초기화
        this.name = name
        this.age = age
        println("매개변수 2개 생성자")
    }
    constructor(name:String, age:Int, telNum:String){
        this.name = name
        this.age = age
        this.telNum = telNum
        println("매개변수 3개 생성자")
    }
    fun print(){
        println("print=> name:$name, age:$age, telNum:$telNum")
    }
}