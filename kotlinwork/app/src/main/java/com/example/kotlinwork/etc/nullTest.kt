package com.example.kotlinwork.etc

//코틀린에서 Null관리
fun main() {
    //null없는 경우 상관없는데 null이 있는 경우 에러
    /*var num1:Int ? = null;
    var num2:Int = num1!!*/
    testnull1("문자열")
    testnull1(null)

    testnull2("문자열")
    testnull2(null)

}

fun testnull1(str:String?){
    val value1 : String = str!! //문법적 오류는 해결, !!는 null에 대한 안정성을 보장받을 수 없다.
    println("value1:$value1")
}
fun testnull2(str:String?) {
    //str매개변수가 null이면 "기본값"이 str에 할당되고 null이 아니면 전달된 값이 적용
    val value1: String = str?:"기본값" //변수에 null이 없으면 전달된 값을 할당하고 null이 있는 경우 기본값을 할당할 수 있도록 구현
    println("value:$value1")
}