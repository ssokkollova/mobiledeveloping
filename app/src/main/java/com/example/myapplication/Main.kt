package com.example.myapplication

fun main() {
    print("Введите количество килограммов конфет: ")
    val kg = readLine()!!.toDouble()

    print("Введите стоимость этих конфет в рублях: ")
    val price = readLine()!!.toDouble()

    print("Введите количество килограммов конфет, для которых нужно определить стоимость: ")
    val kgToPrice = readLine()!!.toDouble()

    print("Введите сумму денег, на которую нужно купить конфеты: ")
    val money = readLine()!!.toDouble()


    val pricePerKg = price / kg
    val totalPrice = pricePerKg * kgToPrice


    val kgToBuy = money / pricePerKg


    println("Стоимость $kgToPrice кг конфет: $totalPrice рублей")
    println("На $money рублей можно купить $kgToBuy кг конфет")


    Zadanie2v26();
    Zadanie3v26();
    Zadanie4v26();
    Zadanie5();
}