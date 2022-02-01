package gameManagement

import wirdleLogic.WirdleResult

class EliminatedLetterBuilder {
    fun getEliminatedLetters(guessedWords: List<GuessedWord>): Set<Char> {
        val newlyEliminated = mutableSetOf<Char>()
        guessedWords.forEach { guessedWord ->
            guessedWord.result.forEachIndexed { index, it ->
                if (it == WirdleResult.WRONG_LETTER) newlyEliminated.add(guessedWord.guess[index])
            }
        }

        return newlyEliminated
    }
}