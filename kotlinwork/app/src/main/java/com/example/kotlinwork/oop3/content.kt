package com.example.kotlinwork.oop3

fun main() {
    val mymovie:Content = Video("변호인", "new")
    mymovie.show()

}
/*
내가한것
open abstract class Content{
    var title:String = ""
    open var price:Int = 100
    constructor(){}
    constructor(title:String){
        this.title = title
    }
    open abstract fun totalPrice()
    open fun show(){
        println("$title 비디오의 가격은 $price 원 입니다.")
    }
}
*/

open abstract class  Content(var title:String) {
    var price:Int = 0
    fun show(){
        println("$title 비디오의 가격은 $price 원 입니다.")
    }
    open abstract fun  totalPrice()
}
