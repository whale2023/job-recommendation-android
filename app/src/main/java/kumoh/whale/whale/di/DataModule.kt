package kumoh.whale.whale.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kgb.plum.data.datasource.HomeDataSource
import kgb.plum.data.datasource.LoginDataSource
import kgb.plum.data.datasource.MyPageDataSource
import kgb.plum.data.datasource.RecommendDataSource
import kgb.plum.data.datasource.RecruitDataSource
import kgb.plum.data.datasource.SignUpDataSource
import kgb.plum.data.datasource.UserDataSource
import kgb.plum.data.datasource.WishDataSource
import kgb.plum.data.network.HomeApi
import kgb.plum.data.network.LoginApi
import kgb.plum.data.network.MyPageApi
import kgb.plum.data.network.RecommendApi
import kgb.plum.data.network.RecruitApi
import kgb.plum.data.network.SignUpApi
import kgb.plum.data.network.UserApi
import kgb.plum.data.network.WishApi
import kgb.plum.data.repository.ExRepositoryImpl
import kgb.plum.data.repository.HomeRepositoryImpl
import kgb.plum.data.repository.LoginRepositoryImpl
import kgb.plum.data.repository.MyPageRepositoryImpl
import kgb.plum.data.repository.RecommendRepositoryImpl
import kgb.plum.data.repository.RecruitRepositoryImpl
import kgb.plum.data.repository.SignUpRepositoryImpl
import kgb.plum.data.repository.WishRepositoryImpl
import kgb.plum.domain.repository.ExRepository
import kgb.plum.domain.repository.HomeRepository
import kgb.plum.domain.repository.LoginRepository
import kgb.plum.domain.repository.MyPageRepository
import kgb.plum.domain.repository.RecommendRepository
import kgb.plum.domain.repository.RecruitRepository
import kgb.plum.domain.repository.SignUpRepository
import kgb.plum.domain.repository.WishRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
  @Binds
  @Singleton
  fun bindExRepository(exRepositoryImpl: ExRepositoryImpl): ExRepository

  @Binds
  @Singleton
  fun bindLoginRepository(loginRepositoryImpl: LoginRepositoryImpl): LoginRepository

  @Binds
  @Singleton
  fun bindSignUpRepository(signUpRepositoryImpl: SignUpRepositoryImpl): SignUpRepository

  @Binds
  @Singleton
  fun bindRecruitRepository(recruitRepositoryImpl: RecruitRepositoryImpl): RecruitRepository

  @Binds
  @Singleton
  fun bindMyPageRepository(myPageRepositoryImpl: MyPageRepositoryImpl): MyPageRepository

  @Binds
  @Singleton
  fun bindHomeRepository(homeRepositoryImpl: HomeRepositoryImpl): HomeRepository

  @Binds
  @Singleton
  fun bindRecommendRepository(recommendRepositoryImpl: RecommendRepositoryImpl): RecommendRepository

  @Binds
  @Singleton
  fun bindWishRepository(wishRepositoryImpl: WishRepositoryImpl): WishRepository

  @Binds
  @Singleton
  fun bindHomeNetwork(homeDataSource: HomeDataSource): HomeApi

  @Binds
  @Singleton
  fun bindSignUpNetwork(signUpDataSource: SignUpDataSource): SignUpApi

  @Binds
  @Singleton
  fun bindLoginNetwork(loginDataSource: LoginDataSource): LoginApi

  @Binds
  @Singleton
  fun bindUserNetwork(userDataSource: UserDataSource): UserApi

  @Binds
  @Singleton
  fun bindWishNetwork(wishDataSource: WishDataSource): WishApi

  @Binds
  @Singleton
  fun bindMyPageNetwork(myPageDataSource: MyPageDataSource): MyPageApi

  @Binds
  @Singleton
  fun bindRecommendNetwork(recommendDataSource: RecommendDataSource) : RecommendApi

  @Binds
  @Singleton
  fun bindRecruitNetwork(recruitDataSource: RecruitDataSource) : RecruitApi
}