package kumoh.whale.whale.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kgb.plum.data.repository.ExRepositoryImpl
import kgb.plum.domain.repository.ExRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    @Singleton
    fun bindExRepository(exRepositoryImpl: ExRepositoryImpl) : ExRepository
}