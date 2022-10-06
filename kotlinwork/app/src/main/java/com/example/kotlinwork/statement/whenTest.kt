package com.example.kotlinwork.statement

fun main() {
    //when 구문 -> 다중분기(if~else if, switch)
    //사이값을 비교하는 경우 if~else if
    //정확하게 일치하는 값을 비교하고 비교할 값들이 적은 경우 사용
    /*when(변수 or 연산식 or 메소드호출문){
        -----------------------------> 결과가 값으로 리턴
        값1 -> 결과가 값1이면 실행할 명령문
        값2 -> 결과가 값2이면 실행할 명령문
        값3 -> {실행할 문장이 여러 개인 경우{}안에 사용가능}
        ...
        값4, 5 -> 값4이거나 값5인 경우 실행할 문장
        else -> 나머지
    }*/
    val num1 : Int = 4
    when (num1) {
        1 -> println("num1은 1")
        2 -> {
            println("num1은 2")
            println("여러줄 명령문")
        }
        3 -> println("num1은 3")
        4, 5 -> println("4이거나 5입니다")
        else -> println("해당사항없음")
    }
    val num2 = 13
    when (num2){
        in 1..3 ,in 11..15 -> println("1부터 3")
        in 4..7 -> println("4부터 7")
        in 8..10 -> println("8부터 10")
    }
}