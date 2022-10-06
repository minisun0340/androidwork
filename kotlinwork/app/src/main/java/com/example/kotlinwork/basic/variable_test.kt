package com.example.kotlinwork.basic

fun main() {
    //변수를 선언하는 방법
    //val(value), var(variable)
    //val 키워드로 선언한 변수는 중간에 값을 변경할 수 없다.(읽기 전용)
    //var 키워드로 선언한 변수는 중간에 값을 변경할 수 있다.(읽기/쓰기)
    //코틀린은 데이터타입을 생략할 수 있고, 선언할 수 있다.
    var num = 100
    var data = "my kotlin"
    var point = 10.5
    val mydata = 300
    num =200
    //mydata = 500 -> val키워드로 정의된 변수이므로 중간에 수정이 불가능
    println(num)
    println(data)
    println(point)
    println(mydata)

    /*
    * 변수를 선언하는 방법
    * 1. val(var) 변수명 = 값
    * 2. val(var) 변수명 : 데이터타입 (Int, String, Double...) = 값
    */
    var num2 : Int = 200
    var data2 : String = "my kotlin"
    var point2 : Double = 10.5
    val mydata2 : Int = 300
    println(num2)
    println(data2)
    println(point2)
    println(mydata2)

    //변수의 활용
    var num3 : Int = 1000
    var num4 = 2000
    val result : Int = num3 + num4
    println("${num3}+${num4}=$result")
    println("${num3}+${num4}=${num3+num4}")
    var data3 = "123"
    println("$data3")
    println("${data3.toInt()}") //숫자모양을 하고 있는 문자열을 정수로 변환
    println("${data3.toDouble()}") //숫자모양을 하고 있는 문자열을 실수로 변환

    //변수에 null을 저장하기
    var num5 = 100
    var num6 = null
    println("값:$num5")
    println("값:$num6")

    var num7:Int = 100
    //null을 허용하지 않는 변수를 정의 - null을 허용하지 않는 변수에 null을 넣는 것은 불가능하다.
    //var num8:Int = null //데이터타입을 정의하고 null을 사용하면 오류발생
    ////물음표는 null을 허용한다는 연산자. 초기화작업 또는 값이 들어오지 않았을 때 사용.
    var num8 : Int ? = 10
    println("값:$num7")
    println("값:$num8")
    // null을 허용하지 않는 변수에 null을 허용하는 변수의 값을 저장할 수 없다.(성격이 다르면 값을 할당할 수 없다.)
    // => num8이 null을 허용하는 변수지만 현재는 null이 아니다라고 설정
    var num9 : Int = num8!! // null허용하지 않는 타입을 맞춰주는 작업(컴파일오류를 처리하도록)
                            // !!는 null은 허용했지만 이 시점에서 null이 아님을 보장하겠다는 의미
}