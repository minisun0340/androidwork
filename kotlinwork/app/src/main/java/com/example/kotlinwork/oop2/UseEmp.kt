package com.example.kotlinwork.oop2

import java.util.*

//빨간곳에 커서 놓고 alt + Enter 하면 import 됨

fun main() {
    println("****인사관리시스템****")
    println("""
        1. Teacher
        2. Student
        3. Staff
        4. FreeLancer
    """.trimIndent())
    var sc: Scanner = Scanner(System.`in`)
    print("작업선택: ")
    var data:Int = sc.nextInt()
    //상속관계에서는 부모타입의 변수를 자식객체를 참조할 수 있다.
    //타입이 부모클래스 타입이면 부모가 갖고있는 메소드, 속성만 접근할 수 있다.
    var obj : Employee ?= null
    when(data){
        1 -> obj = Teacher()
        2 -> obj = Student()
        3 -> obj = Staff()
        4 -> obj = FreeLancer()
    }
    run(obj!!)
}
fun run(obj: Employee){
        obj.test()
}
