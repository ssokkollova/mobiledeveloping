package com.example.myapplication

fun Zadanie5() {
    val circle = Circle("Red", 5.0)
    val rectangle = Rectangle("Blue", 4.0, 6.0)
    val triangle = Triangle("Green", 3.0, 4.0, 5.0)

    // Выводим информацию о фигурах
    circle.printInfo()
    println()
    rectangle.printInfo()
    println()
    triangle.printInfo()
}