package gameManagement

import dataLayer.GameRepo
import dataLayer.PlayerRepo
import playerManagement.PlayerData

class GameRetriever(
    private val gameRepo: GameRepo,
    private val playerRepo: PlayerRepo
) {
    fun retrieveGameForPlayer(playerData: PlayerData): GameData?{
        if (playerData.gameInProgress == null)
            return null

        val gameData = gameRepo.getGame(playerData.gameInProgress)

        if (gameData == null){
            //todo need to log the failed gameId
            println("Failed to retrieve a game.")
            removeFaultyGameFromPlayer(playerData)
        }

        return gameData
    }

    private fun removeFaultyGameFromPlayer(playerData: PlayerData) {
        val updatedPlayerData = PlayerData(
            playerData.playerId,
            null,
            playerData.previousGames
        )
        playerRepo.updatePlayer(updatedPlayerData)
    }
}