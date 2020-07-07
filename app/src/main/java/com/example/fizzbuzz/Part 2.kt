package com.example.fizzbuzz

import android.provider.UserDictionary.Words.addWord

fun main() {
    // Generate output
    fun addWord(w: String, l: MutableList<String>): Boolean = l.add(w)

    for (x in 1..4) {
        var words = mutableListOf<String>()
        // adds Fizz for 3
        if (x%3 == 0) addWord("Fizz", words)
        // adds Buzz for 5
        if (x%5 == 0) addWord("Buzz", words)
        // adds Bang for 7
        if (x%7 == 0) addWord("Bang", words)
        // changes to only Bong for 11
        if (x%11 == 0) {
            words = mutableListOf("Bong")
        }
        // adds Fezz for 13, after F words but before B words
        if (x%13 == 0) {
            var bWords = words.dropWhile { !it.startsWith('B')}
            var fWords = words.takeWhile {!it.startsWith('B')}
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