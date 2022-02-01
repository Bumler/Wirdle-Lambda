package dependencyInjection

import commandLayer.MessageInputProcessor
import org.koin.core.KoinComponent
import org.koin.core.inject
import util.Constants.consoleId

class CliTestingApplication : KoinComponent {
    private val messageInputProcessor by inject<MessageInputProcessor>()

    fun run(){
        println("Type !play to play")
        println("Type !stop to stop")

        var input: String? = ""
        do {
            input = readLine()
            if (input == null)
                break

            val result = messageInputProcessor.processCommand(input, consoleId)
            println(result.message)
        }while (input != "!stop")

    }

    fun testInput(){
        println("Ok trying to run")
        val result = messageInputProcessor.processCommand("!play", consoleId)
        println("Run succeeded")
        println(result.message)
        val guessResult = messageInputProcessor.processCommand("Rides", consoleId)
        println(guessResult.message)
    }
}