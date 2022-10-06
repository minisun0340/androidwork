package com.example.kotlinwork.exam

fun main() {
    val myarr = arrayOf(100, 90, 90, 80, 97)
    printSumArray(myarr)
    println("==========")
    println("결과:${display('a')}")
    println("결과:${display('1')}")
    println("결과:${display('#')}")
    println("==========")
    printdata(myarr)

}

fun printSumArray(myarr:Array<Int>){
    var sum = 0
    var avg = 0.0
    var count = 0
    for (i in myarr){
        sum = sum + i
        count++
    }
    println("합계: $sum")
    println("평균: ${sum/ count.toDouble()}") //실수의 형태로 결과를 출력하고 싶은 경우 캐스팅
}

fun display(data:Char) = when(data){
    in '0'..'9' -> "숫자입니다"
    in 'a'..'z', in 'A'..'Z' -> "문자입니다"
    else -> "판단할 수 없습니다"
}

fun printdata(myarr: Array<Int>){
    for (i in myarr){
        if (i%3 == 0){
            print("$i"+' ')
        }
    }
}
