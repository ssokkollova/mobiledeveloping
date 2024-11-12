package com.example.myapplication

fun Zadanie2v26() {
    print("Введите первое число: ")
    val num1 = readLine()!!.toDouble()

    print("Введите второе число: ")
    val num2 = readLine()!!.toDouble()

    print("Введите третье число: ")
    val num3 = readLine()!!.toDouble()

    //  if
    val maxNumber: Double
    if (num1 >= num2 && num1 >= num3) {
        maxNumber = num1
    } else if (num2 >= num1 && num2 >= num3) {
        maxNumber = num2
    } else {
        maxNumber = num3
    }


    println("Наибольшее число: $maxNumber")


    // when
    val maxNumber1 = when {
        num1 >= num2 && num1 >= num3 -> num1
        num2 >= num1 && num2 >= num3 -> num2
        else -> num3
    }


    println("Наибольшее число: $maxNumber1")
}