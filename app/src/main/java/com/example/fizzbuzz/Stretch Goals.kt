package com.example.fizzbuzz

/*
fun main() {
    fun getInput(q: String): String? {
        println(q)
        return readLine()
    }
    // Get max output
    val max = Integer.valueOf(getInput("Up to what number do you want to print output?: "))
    var rules = mutableListOf<String?>()
    val rule1 = getInput("Which rule would you like to implement? Enter the associated number (3, 5, 7, 11, 13, 17): ")
    rules.add(rule1)
    var more: String? = "Y"
    while (more == "Y") {
        more = getInput("Would you like to implement another set rule (Y/N)? ")
        if (more == "Y") {
            val rule = getInput("Which rule would you like to implement? Enter the associated number: ")
            rules.add(rule)
        }
    }
    // Generate output
    fun addWord(w: String, l: MutableList<String>): Boolean = l.add(w)
    fun singleWord(w: String): MutableList<String> { return mutableListOf(w) }
    fun reverseWords(l: MutableList<String>): MutableList<String> { return l.asReversed()}
    fun betweenFandB(w: String, l: MutableList<String>): MutableList<String> {
        var bWords = l.dropWhile { !it.startsWith('B')}
        var fWords = l.takeWhile {!it.startsWith('B')}
        var word = mutableListOf<String>(w)
        return (fWords + word + bWords) as MutableList<String>
    }
    for (x in 1..200) {
        var words = mutableListOf<String>()
        // adds Fizz for 3
        if (rules.contains("3") && x % 3 == 0) addWord("Fizz", words)
        // adds Buzz for 5
        if (rules.contains("5") && x % 5 == 0) addWord("Buzz", words)
        // adds Bang for 7
        if (rules.contains("7") && x % 7 == 0) addWord("Bang", words)
        // changes to only Bong for 11, or adds Bong if 13 also
        if (rules.contains("11") && x % 11 == 0) {
            words = singleWord("Bong")
        }
        // adds Fezz for 13, after 3 but before everything else
        if (rules.contains("13") && x % 13 == 0) {
            words = betweenFandB("Fezz", words)
        }
        //reverses for 17
        if (rules.contains("17") && x % 17 == 0) {
            words = reverseWords(words)
        }
        // prints required output
        var phrase = ""
        for (word in words) {
            phrase += word
        }
        if (phrase == "") {
            println(x)
        } else {
            println(phrase)
        }
    }
}
*/

fun main() {
    fun getInput(q: String): String {
        println(q)
        val ans = readLine()
        if (ans == null) {
            return getInput(q)
        } else {
            return ans
        }
    }

    //Rule templates
    fun addWord(mod: Int, w: String): (Int, List<String>) -> List<String> {
        return { input, results: List<String> ->
            if (input % mod == 0) results + listOf(w) else results
        }
    }

    fun singleWord(mod: Int, w: String): (Int, List<String>) -> List<String> {
        return { input, results ->
            if (input % mod == 0) listOf(w) else results
        }
    }

    fun reverseWords(mod: Int): (Int, List<String>) -> List<String> {
        return { input, results ->
            if (input % mod == 0) results.asReversed() else results
        }
    }

    fun betweenFandB(mod: Int, w: String): (Int, List<String>) -> List<String> {
        return { input, results ->
            if (input % mod == 0) {
                val bWords = results.dropWhile { !it.startsWith('B')}
                val fWords = results.takeWhile { !it.startsWith('B')}
                (fWords + w + bWords) as List<String>
            } else {
                results
            }
        }
    }
    // Get max output
    val max = Integer.valueOf(getInput("Up to what number do you want to print output?: "))
    // Find out what rules the user wants to implement
    var rules = listOf<(Int, List<String>) -> List<String>>()
    val tot = Integer.valueOf(getInput("How many rules would you like to implement? "))
    println("Please note rules will execute in the order given")

    for (x in 1..tot) {
        val aim =
            getInput("Rule $x: what type of rule would you like to implement?\nA) add a word to the end of a phrase\nB) add a word after F-words but before B-words \nC) return only one word and then any words from later rules\nD) reverse the order of words")
        val num =
            Integer.valueOf(getInput("What number would you like to use as the divisor? "))
        val word =
            getInput("What word would you like to associate with this divisor? (N/A if option D) ")
        if (aim == "A") {
            val rule = addWord(num, word)
            rules = (rules + rule)
        } else if (aim == "B") {
            val rule = betweenFandB(num, word)
            rules = (rules + rule)
        } else if (aim == "C") {
            val rule = singleWord(num, word)
            rules = (rules + rule)
        } else {
            val rule = reverseWords(num)
            rules = (rules + rule)
        }
    }

    for (trial in 1..max) {
        val words = rules.fold(
            listOf<String>(),
            { accumulator, rule ->
                rule(trial, accumulator)
            }
        )
        // prints required output
        var phrase = ""
        for (word in words) {
            phrase += word
        }
        if (words.isEmpty()) {
            println(trial)
        } else {
            println(phrase)
        }
    }
}
