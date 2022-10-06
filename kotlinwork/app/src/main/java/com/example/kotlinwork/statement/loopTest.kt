package com.example.kotlinwork.statement

fun main() {
    //반복문
    //for, while,do~while
    //코드의 반복, 배열과 같은 값을 관리 ...
    //for문
    /*for(변수 in 컬렉션){
                ----
                배열과 같이 값을 여러개 저장할 수 있는 변수
    //반복해서 실행할 명령문
    }*/

    println("==========================")
    val numlist1= 1..10
    for (i in numlist1){
        println("i:$i")
    }
    println("==========================")
    val numlist2= 1..10 step 2 //2씩 증가
    for (i in numlist2){
        println("i:$i")
    }
    println("==========================")
    val numlist3= 10 downTo 1
    for (i in numlist3){
        println("i:$i")
    }
    println("==========================")
    val numlist4= 10 downTo 1 step 2
    for (i in numlist4){
        println("i:$i")
    }
    //arrayOf를 이용해서 배열을 생성
    val myarr1 = arrayOf(10,20,30,40,50)
    test(myarr1)

    //while문 - 조건을 만족하는 경우 명령문을 반복해서 실행
    /*while (조건식){
        반복해서 실행할 명령문
    }*/

    //while문 조건을 만족하지 않으면 {}명령문을 실행할 수 없다.
    print("+++++++++++++")
    var num1 = 0
    while (num1<10){
        println("$num1")
        num1++
    }

    //조건이 만족하지 않아도 do~while은 {}안의 명령문을 한 번은 실행한다.
    do{
        println("$num1")
        num1++
    }while(num1<10)

}
//Array객체로 배열을 관리 -> Array에 담을 데이터의 타입을 <>안에 명시
fun test(myarr:Array<Int>){
    for (i in myarr){
        print("값:$i")
    }
}