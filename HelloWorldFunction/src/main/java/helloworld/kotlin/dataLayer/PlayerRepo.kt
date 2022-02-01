package dataLayer

import playerManagement.PlayerData
import java.util.*

interface PlayerRepo {
    fun getPlayer(id: UUID): PlayerData?
    fun updatePlayer(playerData: PlayerData)
    fun createPlayer(id: UUID): PlayerData
}