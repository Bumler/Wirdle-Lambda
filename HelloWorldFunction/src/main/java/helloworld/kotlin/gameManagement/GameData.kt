package gameManagement

import dataLayer.Word
import java.util.*

data class GameData(
    val gameId: UUID,
    val wordsGuessed: List<GuessedWord>,
    val turnsTaken: Int,
    val gameState: GameState,
    val actualWord: Word
){
    companion object {
        fun create(actualWord: Word): GameData{
            return GameData(
                UUID.randomUUID(),
                listOf(),
                0,
                GameState.IN_PROGRESS,
                actualWord
            )
        }
    }
}
