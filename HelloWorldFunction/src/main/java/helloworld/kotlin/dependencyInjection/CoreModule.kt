package dependencyInjection

import commandLayer.MessageInputProcessor
import commandLayer.TurnResultMessageDecorator
import commandLayer.commandProcessors.CommandFactory
import gameManagement.*
import org.koin.dsl.module
import playerManagement.PlayerGameStateUpdater
import util.InputSanitizer
import wirdleLogic.WirdleChecker

// todo this should be moved to game data if we want it to be configurable.
private const val wordLength = 5
private const val maxTurns = 6

val coreModule = module {
    single { MessageInputProcessor(get(), get(), get(), get(), get()) }
    single { GameRetriever(get(), get()) }
    single { TurnManager(get(), get(), get(), get())}
    single { InputSanitizer() }
    single<GuessValidator> { EnglishGuessValidator(wordLength, get()) }
    single { GuessManager(get(), get(), get()) }
    single { WirdleChecker() }
    single { GameStateJudge(maxTurns) }
    single { EliminatedLetterBuilder() }
    single { PlayerGameStateUpdater(get()) }
    single { TurnResultMessageDecorator(get(), maxTurns) }
    single { CommandFactory(get(), get())}
    single { GameCreator(get(), get(), get()) }
}