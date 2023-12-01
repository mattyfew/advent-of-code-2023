import java.io.File

// Solution #1
//fun main() {
//    var total = 0
//    val fileName = "input.txt"
//    val file = File(fileName)
//
//    if (file.exists()) {
//        file.forEachLine { line: String ->
//            var str: String = ""
//            for (char: Char in line) {
//                when  {
//                    char.isDigit() -> {
//                        str = str + char.toString()
//                    }
//                }
//            }
//
//            if (str.length == 1) {
//                str = str + str
//            }
//
//            if (str.length > 2) {
//                val firstChar = str.get(0)
//                val lastChar = str.get(str.length-1)
//                str = firstChar.toString() + lastChar.toString()
//            }
//
//            total = total + str.toInt()
//        }
//
//        println("Total: ${total}")
//    } else {
//        println("File does not exist")
//    }
//}

// Solution #2
// ============================================================

fun formatWordsToInts(line: String) : String {
    var newLine = line

    for ((index, char: Char) in newLine.withIndex()) {
        when {
            "twone" in newLine -> {
                newLine = newLine.replace("twone", "21")
            }

            "eightwo" in newLine -> {
                newLine = newLine.replace("eightwo", "82")
            }

            "oneight" in newLine -> {
                newLine = newLine.replace("oneight", "18")
            }

            "seven" in newLine -> {
                newLine = newLine.replace("seven", "7")
            }

            "eight" in newLine -> {
                newLine = newLine.replace("eight", "8")
            }

            "three" in newLine -> {
                newLine = newLine.replace("three", "3")
            }

            "four" in newLine -> {
                newLine = newLine.replace("four", "4")
            }

            "five" in newLine -> {
                newLine = newLine.replace("five", "5")
            }

            "nine" in newLine -> {
                newLine = newLine.replace("nine", "9")
            }

            "six" in newLine -> {
                newLine = newLine.replace("six", "6")
            }

            "one" in newLine -> {
                newLine = newLine.replace("one", "1")
            }

            "two" in newLine -> {
                newLine = newLine.replace("two", "2")
            }

        }
    }

    return newLine
}

fun trimStringToOnlyNumbers (line: String) : Int {
    var str: String = ""
    for (char: Char in line) {
        when {
            char.isDigit() -> {
                str = str + char.toString()
            }
        }
    }

    if (str.length == 1) {
        str = str + str
    }


    if (str.length > 2) {
        val firstChar = str.get(0)
        val lastChar = str.get(str.length - 1)
        str = firstChar.toString() + lastChar.toString()
    }

//    println(str)
    return str.toInt()
}


fun main() {
    var total = 0
    val fileName = "input.txt"
    val file = File(fileName)

    if (file.exists()) {
        file.forEachLine { line: String ->
            val newLine = formatWordsToInts(line)
            val result = trimStringToOnlyNumbers(newLine)

            println("${newLine}...${result}...${line}")
            total = total + result
        }
        // 54877 -> too high
        // 54542 -> not right
        // 53789 -> too low
        println("Total: ${total}")
    } else {
        println("File does not exist")
    }
}

// Wrong: 54278, 54258, 54191

// Try: 54265, 54205