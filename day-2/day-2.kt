import java.io.File

fun main() {
    val fileName = "./input.txt"
    val lines: File = File(fileName)
    runDayTwoPartOne(lines)
    runDayTwoPartTwo(lines)
}

fun runDayTwoPartOne(file: File) {
    var total = 0
    val game = object {
        val RED_LIMIT: Int = 12
        val GREEN_LIMIT: Int = 13
        val BLUE_LIMIT: Int = 14
    }

    file.forEachLine { line: String ->
        var isDisqualified = false
        val parts = line.split(": ")

        val gameNumber = parts[0].split("Game ")[1].toInt()

        val gameList: MutableList<MutableList<String>> = mutableListOf(mutableListOf())
        parts[1].split(", ").forEach {
            if (it.contains(";")) {
                var semicolonParts = it.split(";")
                gameList[gameList.size-1].add(semicolonParts[0])
                gameList.add(mutableListOf(semicolonParts[1]))
            } else {
                gameList[gameList.size-1].add(it)
            }
        }

        gameList.forEach { gameScore: List<String> ->
            gameScore.forEach {
                val cubeScore = it.trim().split(" ")
                val num = cubeScore[0].trim().toInt()
                val color = cubeScore[1].trim()

                if (color == "red") {
                    if (num > game.RED_LIMIT) isDisqualified = true
                } else if (color == "green") {
                    if (num > game.GREEN_LIMIT) isDisqualified = true
                } else {
                    if (num > game.BLUE_LIMIT) isDisqualified = true
                }
            }
        }

        if (!isDisqualified) {
            total = total + gameNumber
        }
    }

    print("Part 1 answer: ${total}\n") // Answer: 3059
}

fun runDayTwoPartTwo(file: File) {
    var total = 0

    file.forEachLine { line: String ->
        val parts = line.split(": ")[1].trim().split(";")
        var redMax = 0
        var greenMax = 0
        var blueMax = 0

        parts.forEach { part ->
            part.trim().split(", ").forEach {
                val cubeScore = it.trim().split(" ")
                val num = cubeScore[0].trim().toInt()
                val color = cubeScore[1].trim()

                if (color == "red") {
                    if (num > redMax) {
                        redMax = num
                    }
                } else if (color == "green") {
                    if (num > greenMax) {
                        greenMax = num
                    }
                } else if (color == "blue") {
                    if (num > blueMax) {
                        blueMax = num
                    }
                }
            }
        }

        val gameTotal = redMax * greenMax * blueMax
        total += gameTotal
    }

    print("Part 2 answer: ${total}\n") // Answer: 65371
}