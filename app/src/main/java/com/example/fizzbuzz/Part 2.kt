package com.example.fizzbuzz

fun main() {
    // Generate output
    for (x in 1..200) {
        var words = mutableListOf<String>()
        // adds Fizz for 3
        if (x%3 == 0) {
            words.add("Fizz")
        }
        // adds Buzz for 5
        if (x%5 == 0) {
            words.add("Buzz")
        }
        // adds Bang for 7
        if (x%7 == 0) {
            words.add("Bang")
        }
        // changes to only Bong for 11
        if (x%11 == 0) {
            words = mutableListOf("Bong")
        }

        // adds Fezz for 13, after F words but before B words
        if (x%13 == 0) {
            var bWords = words.dropWhile { it.startsWith('F')}
            var fWords = words.takeWhile {it.startsWith('F')}
            var fezz = mutableListOf<String>("Fezz")
            words = (fWords + fezz + bWords) as MutableList<String>
            }
        //reverses for 17
        if (x%17 == 0) {
            words.asReversed()
        }
        // prints required output
        var phrase = ""
        for (word in words) {
                phrase += word
            }
        if (phrase == ""){
            println(x)
        } else {
            println(phrase)
        }
    }
}