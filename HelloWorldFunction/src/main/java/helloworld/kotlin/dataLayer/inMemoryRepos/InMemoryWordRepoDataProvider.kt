package dataLayer.inMemoryRepos

import dataLayer.Word
import dataLayer.wordDataManager.WordCsvToPokoConverter
import java.io.File
import java.util.*

//todo separate these under a shared interface.
//todo there should be some sort of layer that validates words provided in caps
class InMemoryWordRepoDataProvider {
    private val path = "./src/main/kotlin/dataLayer/wordDataManager/files/"
    private val possibleAnswersFile = "possibleAnswers.csv"
    private val allowedGuessesFile = "allowedGuesses.csv"

    fun getPossibleAnswers(): Map<UUID, Word> {
        return createWordMapFromCsv(possibleAnswersFile)
    }

    fun getAllowedGuesses(): Map<UUID, Word> {
        return createWordMapFromCsv(allowedGuessesFile)
    }

    private fun createWordMapFromCsv(fileName: String): Map<UUID, Word>{
        val possibleAnswersCsv = File("$path/$fileName").readLines()
        return possibleAnswersCsv
            .map { WordCsvToPokoConverter.convertWord(it) }
            .associateBy { it.id }
    }
}