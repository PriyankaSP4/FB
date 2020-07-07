package com.example.fizzbuzz

/*
fun main() {
    // Get max output
    print("Up to what number do you want to print output?: ")
    val max = Integer.valueOf(readLine())
    var rules = mutableListOf<String?>()
    print("Which rule would you like to implement? Enter the associated number: ")
    val rule1 = readLine()
    rules.add(rule1)
    var more: String? = "Y"
    while (more == "Y") {
        print("Would you like to implement another set rule (Y/N)? ")
        more = readLine()
        if (more == "Y") {
            print("Which rule would you like to implement? Enter the associated number: ")
            val rule = readLine()
            rules.add(rule)
        }
    }

    // Generate output
    for (x in 1..max) {
        var word: String = ""
        // adds Fizz for 3
        if (rules.contains("3") && x % 3 == 0) {
            word += "Fizz"
        }
        // adds Fezz for 13, after 3 but before everything else
        if (rules.contains("13") && x % 13 == 0) {
            word = "Fezz"
        }
        // adds Buzz for 5
        if (rules.contains("5") && x % 5 == 0) {
            word += "Buzz"
        }
        // adds Bang for 7
        if (rules.contains("7") && x % 7 == 0) {
            word += "Bang"
        }
        // changes to only Bong for 11, or adds Bong if 13 also
        if (rules.contains("11") && x % 11 == 0) {
            if (rules.contains("13") && x % 13 == 0) {
                word = "FezzBong"
            } else {
                word = "Bong"
            }
        }
        // reverses for 17
        if (rules.contains("17") && x % 17 == 0) {
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
*/

fun main() {
    // Get max output
    print("Up to what number do you want to print output?: ")
    val max = Integer.valueOf(readLine())

    // Find out what rules the user wants to implement
    print("How many rules would you like to implement? ")
    val tot = Integer.valueOf(readLine())
    var divs = mutableListOf<Int>()
    var phrases = mutableListOf<String?>()
    for (x in 1..tot) {
        print("Rule $x - what number would you like to use as the divisor? ")
        divs.add(Integer.valueOf(readLine()))
        print("What four letter word would you like to print if the number is divisible by this number? ")
        phrases.add(readLine())
    }

    //Generate output
    for (num in 1..max) {
        var word = ""
        for (index in phrases.indices) {
            if (num % divs[index] == 0) {
                word += phrases[index]
            }
        }
        if (word == "") {
            print("$num ")
        } else {
            print("$word ")
        }
    }
}
