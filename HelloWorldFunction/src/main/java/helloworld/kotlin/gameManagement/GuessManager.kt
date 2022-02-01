package gameManagement

import dataLayer.GameRepo
import wirdleLogic.WirdleChecker

class GuessManager(
    private val wirdleChecker: WirdleChecker,
    private val gameStateJudge: GameStateJudge,
    private val gameRepo: GameRepo
) {
    fun makeAGuess (gameData: GameData, guess: String): GameData {
        val guessResult = wirdleChecker.checkWord(guess, gameData.actualWord.value)
        val currentTurn = gameData.turnsTaken + 1
        val newGameState = gameStateJudge.determineGameState(guessResult, currentTurn)

        val updatedGameData = GameData(
            gameData.gameId,
             gameData.wordsGuessed + GuessedWord(guess, guessResult),
            currentTurn,
            newGameState,
            gameData.actualWord
        )

        gameRepo.updateGame(updatedGameData)
        return updatedGameData
    }
}