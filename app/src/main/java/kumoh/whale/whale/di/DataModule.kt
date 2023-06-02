package kumoh.whale.whale.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kgb.plum.data.repository.ExRepositoryImpl
import kgb.plum.data.repository.LoginRepositoryImpl
import kgb.plum.data.repository.RecruitRepositoryImpl
import kgb.plum.data.repository.SignUpRepositoryImpl
import kgb.plum.domain.repository.ExRepository
import kgb.plum.domain.repository.LoginRepository
import kgb.plum.domain.repository.RecruitRepository
import kgb.plum.domain.repository.SignUpRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    @Singleton
    fun bindExRepository(exRepositoryImpl: ExRepositoryImpl) : ExRepository

    @Binds
    @Singleton
    fun bindLoginRepository(loginRepositoryImpl: LoginRepositoryImpl) : LoginRepository

    @Binds
    @Singleton
    fun bindSignUpRepository(signUpRepositoryImpl: SignUpRepositoryImpl) : SignUpRepository

    @Binds
    @Singleton
    fun bindRecruitRepository(recruitRepositoryImpl: RecruitRepositoryImpl) : RecruitRepository
}