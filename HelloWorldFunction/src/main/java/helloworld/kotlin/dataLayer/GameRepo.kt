package dataLayer

import gameManagement.GameData
import java.util.*

interface GameRepo {
    fun getGame(id: UUID): GameData?
    fun updateGame(gameData: GameData)
    fun createGame(gameData: GameData)
}