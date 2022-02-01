package gameManagement

import util.SimpleResult

interface GuessValidator {
    fun validate(guess: String, previousGuesses: Set<String>): SimpleResult
}