package com.example.myapplication

class Rectangle(color: String, val width: Double, val height: Double) : Shape(color) {
    override fun area(): Double {
        return width * height
    }

    override fun perimeter(): Double {
        return 2 * (width + height)
    }
}