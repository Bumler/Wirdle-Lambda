package dataLayer.wordDataManager

import util.InputSanitizer


/*
    Just use this to generate or update the word CSV
    files.
 */
fun main(args: Array<String>) {
    val wordTextToCsvConverter = WordTextToCsvConverter(InputSanitizer())

    wordTextToCsvConverter.createCsv("./src/main/kotlin/dataLayer/wordDataManager/files/allowedGuesses.txt", "allowedGuesses")
    wordTextToCsvConverter.createCsv("./src/main/kotlin/dataLayer/wordDataManager/files/possibleAnswers.txt", "possibleAnswers")
}