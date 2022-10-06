package com.example.kotlinwork.function

fun main() {
    //매개변수가 없고 리턴값이 없는 함수의 호출
    test()
    //매개변수가 없고 리턴값이 없는 함수의 호출
    test(100, 200)
    test(100.2, 200)

    //기본값이 있는 함수를 호출하기
    test(num2 = 500, num1 = 100)
    //기본값이 없는 함수는 일부 값만 전달할 수 없다. - 기본값이 없는 함수를 호출하는 경우는 무조건 매개변수 개수, 타입이 일치
    //test(num1=1000) - error
    test(num1 = 1000.3)
    test(num2 = 23000)
    //리턴값이 있는 함수의 호출
    val result = mytest(100, 200)
    println("result:$result")
    println("값:${mytest(200, 300)}")
}
//매개변수가 없고 리턴값이 없는 함수 -> Unit 은 반환될 값이 없다는 의미로 해석 : void와 동일
fun test():Unit{
    println("test함수")
}
//매개변수 있고 리턴값이 있는 함수를 정의
fun mytest(num1:Int, num2:Int):Int{
    //                        ----
    //                        리턴되는 값의 타입을 명시
    val result = num1 + num2
    return result
}
//매개변수가 있고 리턴값이 없는 함수
//함수명이 같아도 매개변수의 개수가 다르거나 매개변수의 타입이 다르면
// 같은 이름으로 여러 개 함수를 정의할 수 있다. - 오버로딩 (e.g.print)
fun test(num1:Int, num2:Int){
    println("===========")
    println("num1=$num1")
    println("num2=$num2")
    println("===========")
}
//함수의 매개변수에 기본 값을 정의할 수 있다.
fun test(num1:Double=10.0, num2:Int=100000){ //기본값 넣기 허용
    println("*************")
    println("num1=$num1")
    println("num2=$num2")
    println("*************")
}