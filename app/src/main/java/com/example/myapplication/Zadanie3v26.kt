package com.example.myapplication

fun Zadanie3v26() {
    print("Введите число n: ")
    val n = readLine()!!.toInt()


    for (i in 1..n) {
        for (j in 1..i) {
            print("*")
        }

    }
}