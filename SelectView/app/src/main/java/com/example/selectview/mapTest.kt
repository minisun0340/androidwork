package com.example.selectview
//자바의 HashMap
fun main() {
    //mapOf로 맵을 만들면 값을 변경할 수 없는 맵이 만들어진다. -고정
    val map1 = mapOf<String, Int>("key1" to 10, "key2" to 20)
    println("map1:$map1")
    println("map1:${map1.get("key1")}")
    println("map1:${map1["key1"]}")
    println("map1의 size:${map1.size}")
    println("map1의 size:${map1.values}") // map에 저장된 value만 리턴
    println("map1의 size:${map1.containsValue(30)}")

    //데이터수정이 가능한 맵 - 가변의 맵
    val map2 = mutableMapOf<String,Int>("key1" to 10, "key2" to 20)
    println("map2:$map2")
    println("map2:${map2.get("key1")}")
    println("map2:${map2["key1"]}")
    println("map2의 size:${map2.size}")
    println("map2의 size:${map2.values}")
    println("map2의 size:${map2.containsValue(30)}")

    map2.put("test2", 40)
    map2["test3"] = 50
    println("map2:$map2")
}