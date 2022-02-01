package gameManagement

import playerManagement.PlayerData
import playerManagement.PlayerGameStateUpdater
import util.InputSanitizer

//consider wrapping this in a try catch that wipes a players game so that no one is stuck
class TurnManager(
    private val guessSanitizer: InputSanitizer,
    private val guessValidator: GuessValidator,
    private val guessManager: GuessManager,
    private val playerGameStateUpdater: PlayerGameStateUpdater
) {
    fun takeATurn(playerData: PlayerData, gameData: GameData, guess: String): TurnResult{
        val sanitizedGuess = guessSanitizer.sanitizeString(guess)
        val validationResult = guessValidator.validate(sanitizedGuess, gameData.wordsGuessed.map { it.guess }.toSet())

        if (!validationResult.isSuccess){
            return TurnResult(validationResult, gameData, playerData)
        }

        val updatedGameData = guessManager.makeAGuess(gameData, sanitizedGuess)
        val updatedPlayerData = playerGameStateUpdater.update(playerData, updatedGameData)

        return TurnResult(validationResult, updatedGameData, updatedPlayerData)
    }
}