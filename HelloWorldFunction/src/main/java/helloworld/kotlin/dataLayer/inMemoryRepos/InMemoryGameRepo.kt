package dataLayer.inMemoryRepos

import dataLayer.GameRepo
import gameManagement.GameData
import java.util.*

class InMemoryGameRepo : GameRepo {
    private val gameDataMap: MutableMap<UUID, GameData> = mutableMapOf()

    override fun getGame(id: UUID): GameData? {
        return gameDataMap[id]
    }

    override fun updateGame(gameData: GameData) {
        gameDataMap[gameData.gameId] = gameData
    }

    override fun createGame(gameData: GameData) {
        gameDataMap[gameData.gameId] = gameData
    }
}