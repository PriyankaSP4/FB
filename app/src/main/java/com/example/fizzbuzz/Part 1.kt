package com.example.fizzbuzz

fun main() {
    for (x in 1..100) {
        if (x%15 == 0) {
            println("FizzBuzz")
        } else if (x%3 == 0) {
            println("Fizz")
        } else if (x%5 == 0) {
            println("Buzz")
        } else {
            println(x)
        }
    }
}