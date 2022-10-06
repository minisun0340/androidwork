package com.example.kotlinwork.basic

import java.util.*

/*
* ctrl+shift+ / => 여러줄 주석
* ctrl+/ => 한줄 주석
* python에서는 thread = Thread()
* java에서는 Thread thread = new Thread()
* */

//키보드로 입력하면 입력받은 내용으로 Scanner객체를 메모리에 사용할 수 있는 상태로 생성
fun main() {
    val sc: Scanner = Scanner(System.`in`)
    print("문장을 입력하세요: ")
    val line = sc.nextLine()
    print("이름을 입력하세요: ")
    val name = sc.next() //한 단어
    print("나이를 입력하세요: ")
    val age = sc.nextInt()

    println(line)
    println("name:$name, age:$age")
}