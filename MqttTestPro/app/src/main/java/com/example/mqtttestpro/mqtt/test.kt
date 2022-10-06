package com.example.mqtttestpro.mqtt

fun main() {
    val mylist = listOf<String>("python", "arduino", "raspberry", "android")
    mylist.map {
        testobj -> testobj.length
    }
            .forEach {
                println("length=$it")
            }
}