package cat.helm.basearchitecture.data.dependencyinjection

import cat.helm.basearchitecture.data.dependencyinjection.qualifier.queries.LoginApiQuery
import cat.helm.basearchitecture.data.network.ApiConstants
import cat.helm.basearchitecture.data.repository.datasource.ReadableDataSource
import cat.helm.basearchitecture.data.repository.login.LoginApiDataSource
import cat.helm.basearchitecture.data.repository.login.LoginDataRepository
import cat.helm.basearchitecture.data.repository.login.model.TokenDataEntity
import cat.helm.basearchitecture.data.repository.login.query.LoginQueryApi
import cat.helm.basearchitecture.data.repository.query.Query
import cat.helm.basearchitecture.repository.LoginRepository
import cat.helm.ureentool.data.dependencyinjection.qualifier.queries.DefaultQueries
import dagger.Module
import dagger.Provides
import dagger.multibindings.ElementsIntoSet
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Borja on 4/1/17.
 */
@Module
open class DataModule {

    @Provides
    @ElementsIntoSet
    @Singleton
    @DefaultQueries
    fun provideDefaultQueries(): MutableSet<Query> {
        return LinkedHashSet()
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
//        val authenticationInterceptor = AuthenticationInterceptor()
//        httpClient.addInterceptor(authenticationInterceptor)
        return httpClient.build()
    }



    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
                .client(OkHttpClient.Builder().build())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ApiConstants.BASEURL)
                .build()
    }


    @Provides
    @Singleton
    @ElementsIntoSet
    @LoginApiQuery
    fun providesLoginApiQuery(loginQueryApi: LoginQueryApi): MutableSet<Query> {

        val set = LinkedHashSet<Query>()
        set.add(loginQueryApi)
        return set
    }

    @Provides
    @Singleton
    fun providesLoginRepository(loginDataRepository: LoginDataRepository): LoginRepository {
        return loginDataRepository
    }

    @Provides
    @Singleton
    fun providesApiLoginReadableDataSource(loginApiDataSource: LoginApiDataSource): ReadableDataSource<String, TokenDataEntity> {
        return loginApiDataSource
    }
}
