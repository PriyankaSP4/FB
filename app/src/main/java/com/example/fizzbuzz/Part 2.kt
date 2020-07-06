package com.example.fizzbuzz

fun main() {
    for (x in 1..200) {
        var word: String = ""
        if (x%3 == 0) {
            word += "Fizz"
            }
        if (x%13 == 0) {
            word = "Fezz"
        }
        if (x%5 == 0) {
            word += "Buzz"
        }
        if (x%7 == 0) {
            word += "Bang"
        }
        if (x%11 == 0) {
            if (x%13 ==0) {
                word += "Bong"
            } else {
                word = "Bong"
            }
        }
        if (x%17 == 0) {
            var chunks = word.chunked(4)
            chunks = chunks.asReversed()
            word = ""
            for (chunk in chunks) {
                word += chunk
            }
        }
        if (word == "") {
            print(x)
        } else {
            print("$word")
        }
        print (" ")
    }
}