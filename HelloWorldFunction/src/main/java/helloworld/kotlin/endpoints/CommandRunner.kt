package endpoints

import commandLayer.MessageInputProcessor
import org.koin.core.KoinComponent
import org.koin.core.inject
import util.SimpleResult
import java.util.*

class CommandRunner : KoinComponent {
    private val messageInputProcessor by inject<MessageInputProcessor>()

    fun run(command: String, playerId: UUID): SimpleResult{
        return messageInputProcessor.processCommand(command, playerId)
    }
}