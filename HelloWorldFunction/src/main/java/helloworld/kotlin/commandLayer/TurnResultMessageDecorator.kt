package commandLayer

import gameManagement.EliminatedLetterBuilder
import gameManagement.GameData
import gameManagement.GameState
import gameManagement.GuessedWord
import util.EmojiUnicodeConstants.fullMoon
import util.EmojiUnicodeConstants.halfMoon
import util.EmojiUnicodeConstants.newMoon
import wirdleLogic.WirdleResult

class TurnResultMessageDecorator(private val eliminatedLetterBuilder: EliminatedLetterBuilder,
                                 private val maxTurns: Int) {
    private val resultMap = mapOf(
        WirdleResult.EXACT_MATCH to fullMoon,
        WirdleResult.HAS_LETTER to halfMoon,
        WirdleResult.WRONG_LETTER to newMoon,
    )

    fun formatMessage(gameData: GameData): String{
        val message = mutableListOf<String>()

        val topLine = createTopLine(gameData)
        message.add(topLine)
        val linesForResults = gameData.wordsGuessed.map { createLineForGuess(it) }
        message.addAll(linesForResults)

        if(gameData.gameState == GameState.IN_PROGRESS){
            val lettersEliminated = eliminatedLetterBuilder.getEliminatedLetters(gameData.wordsGuessed)
                .joinToString(", ")
            message += "Letters Eliminated: $lettersEliminated"
        }

        return message.joinToString("\n")
    }

    private fun createTopLine(gameData: GameData) = when (gameData.gameState) {
        GameState.WON -> {
            createWinMessage(gameData.actualWord.value) + " ${formatTurns(gameData.turnsTaken)}"
        }
        GameState.LOST -> {
            createLoseMessage(gameData.actualWord.value)
        }
        else -> {
            createTurnMessage(gameData.wordsGuessed.last().result, gameData.actualWord.value.length) +
                    " ${formatTurns(gameData.turnsTaken)}"
        }
    }

    private fun formatTurns(turnsTaken: Int): String {
        return "$turnsTaken/$maxTurns"
    }

    private fun createLineForGuess(guessedWord: GuessedWord): String {
        return "${guessedWord.result.map { resultMap[it] }.joinToString("")} - ${guessedWord.guess}"
    }

    private fun createWinMessage(actualWord: String): String {
        return "Congratulations you win! The word was $actualWord"
    }

    private fun createLoseMessage(actualWord: String): String {
        return "I'm sorry you lost. The word was $actualWord"
    }

    private fun createTurnMessage(currentResult: List<WirdleResult>, numLetters: Int): String {
        val numMiss = currentResult.count { it == WirdleResult.WRONG_LETTER }
        val numPartial = currentResult.count { it == WirdleResult.HAS_LETTER }
        val numHit = currentResult.count { it == WirdleResult.EXACT_MATCH }

        if (numMiss == numLetters)
            return "OOF! Try again."
        else if (numHit == numLetters - 1)
            return "SO CLOSE!"
        else if (numHit + numPartial >= numLetters - 1)
            return "You're almost there."

        return "Good guess."
    }

}