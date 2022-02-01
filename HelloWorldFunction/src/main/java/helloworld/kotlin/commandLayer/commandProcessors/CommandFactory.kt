package commandLayer.commandProcessors

import gameManagement.GameCreator
import playerManagement.PlayerData
import util.InputSanitizer
import util.SimpleResult

class CommandFactory(
    private val sanitizer: InputSanitizer,
    private val gameCreator: GameCreator,
    ) {
    private val commandChar = "!"
    private val play = "${commandChar}PLAY"

    fun runCommand(command: String, playerData: PlayerData): SimpleResult? {
        val sanitizedCommand = sanitizer.sanitizeString(command)

        if(sanitizedCommand == play)
            return gameCreator.startAGame(playerData)
        else if (sanitizedCommand.startsWith(commandChar))
            return SimpleResult.failure("$command is not a known command.")

        return null
    }
}