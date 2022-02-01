package dataLayer

import java.util.*

interface WordRepo {
    fun getNewWord(wordsUsed: Set<UUID>): Word
    fun getAllPossibleAnswers(): Set<Word>
    fun getAllGuessWords(): Set<Word>
}
