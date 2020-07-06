package com.example.fizzbuzz

fun main() {
    for (x in 1..100) {
        if (x%15 == 0) {
            print("FizzBuzz")
        } else if (x%3 == 0) {
            print("Fizz")
        } else if (x%5 == 0) {
            print ("Buzz")
        } else {
            print(x)
        }
        print(' ')
    }
}