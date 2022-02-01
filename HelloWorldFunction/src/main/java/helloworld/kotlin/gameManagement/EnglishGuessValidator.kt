package gameManagement

import dataLayer.WordRepo
import util.SimpleResult

class EnglishGuessValidator(
    private val expectedWordLength: Int,
    private val wordRepo: WordRepo
): GuessValidator {
    private val alphaRegex: Regex = Regex("^[a-zA-Z]*\$")

    override fun validate(guess: String, previousGuesses: Set<String>): SimpleResult {
        if(guess.length != expectedWordLength){
            return SimpleResult.failure("Expected word length is $expectedWordLength. Your word is $expectedWordLength")
        }
        if(!alphaRegex.matches(guess)){
            return SimpleResult.failure("Your word must be 5 letters and be only composed of characters between A-Z (it's case-insensitive so don't worry about that).")
        }
        if(previousGuesses.contains(guess)){
            return SimpleResult.failure("You've already guessed this word")
        }
        if(!wordRepo.getAllGuessWords().map{it.value}.contains(guess)){
            return SimpleResult.failure("Not a valid word.")
        }

        return SimpleResult.success()
    }

}
