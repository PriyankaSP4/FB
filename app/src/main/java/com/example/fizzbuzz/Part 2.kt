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
        // adds Fezz for 13, after 3 but before everything else
        if (x%13 == 0) {
            var pos = words.size
            for (item in words) {
                if (item[0] == 'B') {
                    var index = words.indexOf(item)
                    if (index < pos) {
                        pos = index
                    }
                }
            }
            words.add(pos, "Fezz")
        }
        // changes to only Bong for 11, or adds Bong if 13 also
        if (x%11 == 0) {
            if (x%13 == 0) {
                words = mutableListOf("Fezz", "Bong")
            } else {
                words = mutableListOf("Bong")
            }
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