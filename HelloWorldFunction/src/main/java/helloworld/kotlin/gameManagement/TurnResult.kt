package gameManagement

import playerManagement.PlayerData
import util.SimpleResult

data class TurnResult (
    val validationResult: SimpleResult,
    val gameData: GameData,
    val playerData: PlayerData
)
