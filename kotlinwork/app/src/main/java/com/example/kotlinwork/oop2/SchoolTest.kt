package com.example.kotlinwork.oop2

import com.example.kotlinwork.oop.Staff
import com.example.kotlinwork.oop.Student
import com.example.kotlinwork.oop.Teacher

fun main() {
    val student1:Student = Student("홍길동", 20, 200201)
    student1.print()
    val teacher1:Teacher = Teacher("이순신", 30, "JAVA")
    teacher1.print()
    val staff1:Staff = Staff("유관순", 40, "교무과")
    staff1.print()
}