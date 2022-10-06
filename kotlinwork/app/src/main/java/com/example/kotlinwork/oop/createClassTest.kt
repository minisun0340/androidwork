package com.example.kotlinwork.oop

fun main() {
    //사용자정의 클래스를 사용하는 방법
    //객체생성 = 클래스의 인스턴스화 작업
    //정의된 클래스를 실제 프로그램 내부에서 사용하기 위해 메모리에 올려놓는 작업
    // 클래스가 인스턴화 되는 공간 -> heap
    // stack은 실제 코드가 돌아가면서 필요한 주소 공간
    val obj1:MyClass = MyClass()
    val obj2 = MyClass() // 객체를 참조하는 변수와 실제 생성되는 객체가 타입이 동일한 경우 참조변수의 타입을 생략 할 수 있다.
    println("obj1:$obj1")
    println("obj2:$obj2")

    var obj3:Person = Person()
    obj3.name = "장동건"
    obj3.telNum = 111
    obj3.age = 22

    println("Person의 데이터:${obj3.name}, ${obj3.age}, ${obj3.telNum}")
    obj3.print()

}

// 클래스를 작성하는 방법
class MyClass{

}
class Person{
    //DB의 레코드를 모델링한 클래스인 경우 멤버변수가 DB의 컬럼
    //DB의 데이터를 저장하고 가져오기 위해 setter/getter메소드 필수로 작성
    //멤버변수 정의
    var name = ""
    var telNum = 0
    var age = 0

    //멤버 메소드 - Person클래스가 갖고 있는 기능(함수와 동일한 방법으로 정의)
    fun print():Unit{
        println("print=> name:$name, age:$age, telNum:$telNum")
    }
}