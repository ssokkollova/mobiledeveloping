package com.example.myapplication

class Triangle(color: String, val sideA: Double, val sideB: Double, val sideC: Double) : Shape(color) {
    override fun area(): Double {

        val s = (sideA + sideB + sideC) / 2
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC))
    }

    override fun perimeter(): Double {
        return sideA + sideB + sideC
    }
}