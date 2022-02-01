import dependencyInjection.CliTestingApplication
import dependencyInjection.cliTestingDependencies
import dependencyInjection.coreModule
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

    startKoin {
    }
    loadKoinModules(listOf(cliTestingDependencies, coreModule))

    CliTestingApplication().run()
}