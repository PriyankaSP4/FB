package com.example.fizzbuzz

fun main() {

    for (x in 1..200) {
        var word: String = ""
        // adds Fizz for 3
        if (x%3 == 0) {
            word += "Fizz"
            }
        // adds Fezz for 13, after 3 but before everything else
        if (x%13 == 0) {
            word = "Fezz"
        }
        // adds Buzz for 5
        if (x%5 == 0) {
            word += "Buzz"
        }
        // adds Bang for 7
        if (x%7 == 0) {
            word += "Bang"
        }
        // changes to only Bong for 11, or adds Bong if 13 also
        if (x%11 == 0) {
            if (x%13 == 0) {
                word = "FezzBong"
            } else {
                word = "Bong"
            }
        }
        // reverses for 17
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