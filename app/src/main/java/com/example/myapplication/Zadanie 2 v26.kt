package com.example.myapplication

fun Zadanie2v26() {
    print("Введите первое число: ")
    val num1 = readLine()!!.toDouble()

    print("Введите второе число: ")
    val num2 = readLine()!!.toDouble()

    print("Введите третье число: ")
    val num3 = readLine()!!.toDouble()

    val maxNumber = maxOf(num1, num2, num3)

    println("Наибольшее число: $maxNumber")
}