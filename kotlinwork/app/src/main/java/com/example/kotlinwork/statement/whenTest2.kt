package com.example.kotlinwork.statement

fun main() {
    val str1 = setValue(2)
    println("result1=>$str1")
    println("result2=>${setValue(2)}")
    println("result3=>${setValue(3)}")

    var data:Char = '1'
    var data2:Char = 'A'
    println("result=>$data, result2=>$data2")
}

//when을 함수의 리턴값으로 사용 - else문을 반드시 사용해서, 리턴값이 없는 경우를 만들면 안된다.
fun setValue(num:Int) = when(num){
    1 -> "문자열 1"
    2 -> {
        println("실행할 문장")
        "문자열 2"
    }
    else -> "그 외의 값"
}