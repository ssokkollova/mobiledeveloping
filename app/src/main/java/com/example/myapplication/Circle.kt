package com.example.myapplication

class Circle(color: String, val radius: Double) : Shape(color) {
    override fun area(): Double {
        return Math.PI * radius * radius
    }

    override fun perimeter(): Double {
        return 2 * Math.PI * radius
    }
}