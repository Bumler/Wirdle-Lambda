package playerManagement

import java.time.LocalDateTime
import java.util.*

data class GameResult(
    val gameId: UUID,
    val turnComplete: Int,
    val isWin: Boolean,
    val completeDate: LocalDateTime,
    val wordId: UUID
) {
    companion object {
        fun win(gameId: UUID, turnComplete: Int, wordId: UUID): GameResult{
            return GameResult(
                gameId,
                turnComplete,
                isWin = true,
                LocalDateTime.now(),
                wordId
            )
        }

        fun lose(gameId: UUID, wordId: UUID): GameResult{
            return GameResult(
                gameId,
                -1,
                isWin = false,
                LocalDateTime.now(),
                wordId
            )
        }
    }
}