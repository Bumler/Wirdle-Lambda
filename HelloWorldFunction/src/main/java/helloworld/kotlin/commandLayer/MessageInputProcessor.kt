package commandLayer

import commandLayer.commandProcessors.CommandFactory
import dataLayer.PlayerRepo
import gameManagement.GameRetriever
import gameManagement.TurnManager
import playerManagement.PlayerData
import util.SimpleResult
import java.util.*

class MessageInputProcessor(
    private val playerRepo: PlayerRepo,
    private val gameRetriever: GameRetriever,
    private val turnManager: TurnManager,
    private val turnResultMessageDecorator: TurnResultMessageDecorator,
    private val commandFactory: CommandFactory
) {
    fun processCommand(inputString: String, playerId: UUID): SimpleResult {
        val playerData = playerRepo.getPlayer(playerId) ?: playerRepo.createPlayer(playerId)

        return tryRunCommand(inputString, playerData) ?:
            tryToTakeATurn(inputString, playerData) ?:
            SimpleResult.failure("Unknown input")
    }

    private fun tryRunCommand(inputString: String, playerData: PlayerData): SimpleResult? {
        return commandFactory.runCommand(inputString, playerData)
    }

    private fun tryToTakeATurn(inputString: String, playerData: PlayerData): SimpleResult? {
        val gameData = gameRetriever.retrieveGameForPlayer(playerData) ?: return null

        val turnResult = turnManager.takeATurn(playerData, gameData, inputString)
        return if (turnResult.validationResult.isSuccess)
            SimpleResult.success(turnResultMessageDecorator.formatMessage(turnResult.gameData))
            else SimpleResult.failure(turnResult.validationResult.message)
    }
}