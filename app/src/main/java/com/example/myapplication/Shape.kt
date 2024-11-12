package com.example.myapplication

abstract class Shape(val color: String) {

    abstract fun area(): Double


    abstract fun perimeter(): Double


    fun printInfo() {
        println("Color: $color")
        println("Area: ${area()}")
        println("Perimeter: ${perimeter()}")
    }
}