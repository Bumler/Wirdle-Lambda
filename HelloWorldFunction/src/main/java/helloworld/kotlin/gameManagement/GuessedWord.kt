package gameManagement

import wirdleLogic.WirdleResult

data class GuessedWord(
    val guess: String,
    val result: List<WirdleResult>
)
