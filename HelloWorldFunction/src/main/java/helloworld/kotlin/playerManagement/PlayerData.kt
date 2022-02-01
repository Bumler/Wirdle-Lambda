package playerManagement

import java.util.*

data class PlayerData (
    val playerId: UUID,
    val gameInProgress: UUID?,
    val previousGames: List<GameResult>
) {
    fun getPreviousWords(): Set<UUID>{
        return previousGames.map { it.wordId }.toSet()
    }

    companion object {
        fun create(playerId: UUID): PlayerData{
            return PlayerData(playerId, null, listOf())
        }
    }
}