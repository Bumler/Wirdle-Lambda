package dataLayer.inMemoryRepos

import dataLayer.Word
import dataLayer.WordRepo
import java.util.*

class InMemoryWordRepo(
    private val inMemoryWordRepoDataProvider: InMemoryWordRepoDataProvider)
    : WordRepo{
    override fun getNewWord(wordsUsed: Set<UUID>): Word {
        val answerMap = inMemoryWordRepoDataProvider.getPossibleAnswers().toMutableMap()
        wordsUsed.forEach { answerMap.remove(it) }

        val wordEntries = answerMap.entries
        val randy = Random()

        return wordEntries.elementAt(randy.nextInt(wordEntries.size)).value
    }

    override fun getAllGuessWords(): Set<Word> {
        return inMemoryWordRepoDataProvider.getAllowedGuesses().values.toSet()
    }

    override fun getAllPossibleAnswers(): Set<Word> {
        return inMemoryWordRepoDataProvider.getPossibleAnswers().values.toSet()
    }
}