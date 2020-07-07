package com.example.fizzbuzz

/*
fun main() {
    // Get max output
    print("Up to what number do you want to print output?: ")
    val max = Integer.valueOf(readLine())
    var rules = mutableListOf<String?>()
    print("Which rule would you like to implement? Enter the associated number (3, 5, 7, 11, 13): ")
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
    for (x in 1..200) {
        var words = mutableListOf<String>()
        // adds Fizz for 3
        if (rules.contains("3") && x%3 == 0) {
            words.add("Fizz")
        }
        // adds Fezz for 13, after 3 but before everything else
        if (rules.contains("13") && x%13 == 0) {
            words.add("Fezz")
        }
        // adds Buzz for 5
        if (rules.contains("5") && x%5 == 0) {
            words.add("Buzz")
        }
        // adds Bang for 7
        if (rules.contains("7") && x%7 == 0) {
            words.add("Bang")
        }
        // changes to only Bong for 11, or adds Bong if 13 also
        if (rules.contains("11") && x%11 == 0) {
            if (rules.contains("13") && x%13 == 0) {
                words = mutableListOf("Fezz", "Bong")
            } else {
                words = mutableListOf("Bong")
            }
        }
        //reverses for 17
        if (rules.contains("17") && x%17 == 0) {
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
*/
fun main() {
    // Get max output
    print("Up to what number do you want to print output?: ")
    val max = Integer.valueOf(readLine())

    // Find out what rules the user wants to implement
    print("How many rules would you like to implement? ")
    val tot = Integer.valueOf(readLine())
    var divs = mutableListOf<Int>()
    var phrases = mutableListOf<List<String?>>()
    for (x in 1..tot) {
        print("Rule $x - what number would you like to use as the divisor? ")
        divs.add(Integer.valueOf(readLine()))
        print("If a number is divisible by this divisor, do you want to:\nA) add a word to start of the phrase\nB) add a word to the of the phrase\nC) only print the word associated with this divisor and no others\nD) reverse the order of words")
        val aim = readLine()
        var phrase: String? = " "
        if (aim != "D") {
            print("What word would you like to associate with this divisor? ")
            phrase = readLine()
        }
        val indic = listOf(aim, phrase)
        phrases.add(indic)
    }

    //Generate output
    for (num in 1..max) {
        var words = mutableListOf<String?>()
        var reverse: String = ""
        for (index in phrases.indices) {
            if (num % divs[index] == 0) {
                var specific_phrase = phrases[index]
                if (specific_phrase[0] == "A") {
                    words.add(0, specific_phrase[1])
                } else if (specific_phrase[0] == "B") {
                    words.add(specific_phrase[1])
                } else if (specific_phrase[0] == "C") {
                    words = mutableListOf(specific_phrase[1])
                    break
                } else {
                    reverse = "Y"
                }
            }
        }
        if (reverse == "Y") {
            words = words.asReversed()
        }

        // prints required output
        var phrase = ""
        for (word in words) {
                phrase += word
            }
            if (phrase == "") {
                println(num)
            } else {
                println(phrase)
            }
        }
    }

