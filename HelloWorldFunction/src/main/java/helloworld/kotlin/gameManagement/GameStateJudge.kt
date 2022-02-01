package gameManagement

import wirdleLogic.WirdleResult

class GameStateJudge(private val maxTurns: Int) {
    fun determineGameState(result: List<WirdleResult>, currentTurn: Int): GameState {
        if (result.all { it == WirdleResult.EXACT_MATCH })
            return GameState.WON

        return if (currentTurn >= maxTurns) GameState.LOST
            else GameState.IN_PROGRESS
    }
}