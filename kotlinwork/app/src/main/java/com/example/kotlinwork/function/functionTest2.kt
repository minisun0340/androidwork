package com.example.kotlinwork.function

fun main() {
    val result1 = test1(100,200)
    println("result1 = $result1")
    val result2 = test2(300, 200)
    println("result2 = $result2")
}

fun test1(num1:Int, num2:Int):Int{
    return num1+num2
}

//실행할 명령문이 바로 값을 리턴하고 있다면 함수를 축약해서 사용할 수 있다.
fun test2(num1:Int, num2:Int):Int = num1+num2