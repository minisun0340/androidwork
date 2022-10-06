package com.example.kotlinwork.exam

import java.util.*

/*fun main() {
    gugu(2)
    println("=====")
    println("합계: ${sum(2,3)}")
}
fun gugu(dan:Int){
    println("""
        $dan * 1 = ${dan * 1}
        $dan * 2 = ${dan * 2}
        $dan * 3 = ${dan * 3}
        $dan * 4 = ${dan * 4}
        $dan * 5 = ${dan * 5}
        $dan * 6 = ${dan * 6}
        $dan * 7 = ${dan * 7}
        $dan * 8 = ${dan * 8}
        $dan * 9 = ${dan * 9}
    """.trimIndent())
}*/

fun main() {
    val sc:Scanner = Scanner(System.`in`)
    print("단: ")
    val dan:Int = sc.nextInt()
    gugu_answer(dan)
    println("${add_answer(10, 20)}")
}

fun gugu_answer(dan:Int){
    for (i in 1..9){
        print("$dan * $i = ${dan*i} ")
    }
}
// 1.Int -> Int?
// 2. return result -> return result!!
fun add_answer(num1:Int, num2:Int):Int{
    //null허용
    var result:Int ? = num1 + num2
    return result!!
}



fun sum(num1:Int, num2:Int):Int?{
    var result : Int ? = num1 + num2
    return  result
}