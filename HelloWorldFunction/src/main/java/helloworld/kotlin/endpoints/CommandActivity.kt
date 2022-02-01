package helloworld.kotlin.endpoints

import dependencyInjection.awsDependencies
import dependencyInjection.coreModule
import endpoints.CommandRunner
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import util.SimpleResult
import java.util.*

class CommandActivity {
    fun runCommand(command: String, playerId: UUID): SimpleResult{
        startKoin {
        }
        loadKoinModules(listOf(awsDependencies, coreModule))

        return CommandRunner().run(command, playerId)
    }
}