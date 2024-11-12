package com.example.myapplication

fun Zadanie4v26() {
    val matrix = Array(10) { DoubleArray(10) }


    for (i in 0 until 10) {
        for (j in 0 until 10) {
            matrix[i][j] = Math.random()
        }
    }


    var sum = 0.0
    var product = 1.0

    for (row in matrix) {
        for (element in row) {
            sum += element
            product *= element
        }
    }


    println("Сумма элементов матрицы: $sum")
    println("Произведение элементов матрицы: $product")
}