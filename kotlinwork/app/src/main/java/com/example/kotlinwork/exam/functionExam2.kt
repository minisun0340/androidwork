package com.example.kotlinwork.exam

import java.util.*

fun main() {
    println("****계산기****")
    println("""
        1. 더하기
        2. 빼기
        3. 곱하기
        4. 나누기
    """.trimIndent())
    val sc:Scanner = Scanner(System.`in`)
    print("원하는 작업을 입력하세요 : ")
    val opr = sc.nextInt()
    println("숫자1: ")
    val num1 = sc.nextInt()
    println("숫자2: ")
    val num2 = sc.nextInt()
    println("결과: ")
    calc(opr, num1, num2)
    println("결과:${calc2(opr, num1, num2)}")
}

fun calc(opr:Int, num1:Int, num2:Int){
    if (opr == 1){
        print(num1 + num2)
    }
    else if (opr == 2){
        print(num1 - num2)
    }
    else if (opr == 3){
        print(num1 * num2)
    }
    else if (opr == 4) {
        print(num1 / num2)
    }
}
fun calc2(opr:Int, num1:Int, num2:Int):Int{
    var result = 0
    when (opr){
        1-> result = num1 + num2
        2-> result = num1 - num2
        3-> result = num1 * num2
        4-> result = num1 / num2
    }
    return result
}