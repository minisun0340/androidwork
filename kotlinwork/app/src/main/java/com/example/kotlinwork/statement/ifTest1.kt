package com.example.kotlinwork.statement
import java.util.*
fun main() {

    /*if(조건){
        조건이 만족하는 경우 실행할 문장
    }
    else{
        조건이 만족하지 않는 경우 실행할 문장
    }

    if(조건1){
        조건1 만족하는 경우 실행할 문장
    }
    else if(조건2){
        조건2 만족하는 경우 실행할 문장
    }
    else{
        조건이 만족하지 않는 경우 실행할 문장
    }*/
    var sc:Scanner = Scanner(System.`in`)
    print("숫자입력:")
    val num1:Int = sc.nextInt()
    if(num1==100){
        println("같다.")
    }
    if(num1!=100){
        println("다르다.")
    }
    if(num1>=90){
        println("성공.")
    }else{
        println("실패.")
    }

    // ||or $$and
    if(num1>100 || num1<0){
        println("잘못입력")
    }else{
        if(num1>=90){
            println("A")
        }else if(num1>=80){
            println("B")
        }else if(num1>=70){
            println("C")
        }else if(num1>=60){
            println("D")
        }else{
            println("F")
        }

    }

}