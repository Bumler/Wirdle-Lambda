package gameManagement

import dataLayer.GameRepo
import dataLayer.PlayerRepo
import dataLayer.WordRepo
import playerManagement.PlayerData
import util.SimpleResult

class GameCreator(
    private val playerRepo: PlayerRepo, private val wordRepo: WordRepo,
    private val gameRepo: GameRepo){
    fun startAGame(playerData: PlayerData): SimpleResult{
        if(playerData.gameInProgress != null){
            return SimpleResult.failure("Can't start a game with another game in progress. Please make a guess instead")
        }

        val newWord = wordRepo.getNewWord(playerData.getPreviousWords())
        val newGame = GameData.create(newWord)

        gameRepo.createGame(newGame)

        val updatedPlayerData = PlayerData(
            playerData.playerId,
            newGame.gameId,
            playerData.previousGames
        )

        playerRepo.updatePlayer(updatedPlayerData)
        return SimpleResult.success("Game created successfully.")
    }
}