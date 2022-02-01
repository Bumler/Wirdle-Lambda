package dataLayer.inMemoryRepos

import dataLayer.PlayerRepo
import playerManagement.PlayerData
import util.Constants.consoleId
import java.util.*

class InMemoryPlayerRepo : PlayerRepo {
    private val playerMap: MutableMap<UUID, PlayerData> = mutableMapOf(
        consoleId to PlayerData.create(consoleId)
    )

    override fun getPlayer(id: UUID): PlayerData? {
        return playerMap[id]
    }

    override fun updatePlayer(playerData: PlayerData) {
        playerMap[playerData.playerId] = playerData
    }

    override fun createPlayer(id: UUID): PlayerData {
        val newPlayer = PlayerData.create(id)
        playerMap[id] = newPlayer
        return newPlayer
    }
}