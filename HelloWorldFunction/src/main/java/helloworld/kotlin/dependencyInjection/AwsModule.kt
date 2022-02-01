package dependencyInjection

import dataLayer.GameRepo
import dataLayer.PlayerRepo
import dataLayer.WordRepo
import dataLayer.inMemoryRepos.InMemoryGameRepo
import dataLayer.inMemoryRepos.InMemoryPlayerRepo
import dataLayer.inMemoryRepos.InMemoryWordRepo
import dataLayer.inMemoryRepos.InMemoryWordRepoDataProvider
import org.koin.dsl.module

//todo switch to dynamo repos
val awsDependencies = module {
    single<PlayerRepo> { InMemoryPlayerRepo() }
    single<GameRepo> { InMemoryGameRepo() }
    single<WordRepo> { InMemoryWordRepo(get()) }
    single { InMemoryWordRepoDataProvider() }
}