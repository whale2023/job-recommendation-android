package kumoh.whale.whale.di

import android.util.Log
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kgb.plum.data.library.Api.ApiService
import kgb.plum.data.library.retrofit.NetworkRequestFactory
import kgb.plum.data.library.retrofit.NetworkRequestFactoryImpl
import kgb.plum.data.library.retrofit.StringConverterFactory
import kgb.plum.domain.LoginTokenData
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import timber.log.Timber
import java.io.IOException
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }


    @Provides
    @Singleton
    fun provideOkHttpClient(
        interceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
//        if (BuildConfig.DEBUG) {
//            builder.addInterceptor(interceptor)
//        }
        return builder.build()
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return Gson()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gson: Gson
    ): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(logBaseUrl(baseUrl = "http://13.124.3.219:8080/"))
            .addConverterFactory(StringConverterFactory(gson))
            .build()
    }

    private fun logBaseUrl(baseUrl: String): String {
        Timber.d("baseUrl $baseUrl")
        return baseUrl
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun bindNetworkRequestFactory(networkRequestFactory: NetworkRequestFactoryImpl): NetworkRequestFactory =
        networkRequestFactory

}

class HeaderInterceptor constructor(private val token: String) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = "Bearer $token"
        val newRequest = chain.request().newBuilder()
            .addHeader("Authorization", token)
            .build()
        return chain.proceed(newRequest)
    }
}