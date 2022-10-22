package com.example.gitusers.module
import android.util.Log
import com.example.gitusers.data.GitUserApis
import com.example.gitusers.domain.GitUserClient
import com.example.gitusers.domain.GitUserClientResponse
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Credentials
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


const val API_TIME_OUT = (30L)

val gitHubApiModules =  module {
factory { provideHttpClient(get()) }
factory { provideHttpLoggingInterceptor() }
factory { provideGson() }
factory { provideGitApi(get()) }
single  { provideRetrofit(get(),get()) }

}

val githubApiClientModule = module {
    single<GitUserClient> { GitUserClientResponse(get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
}

fun provideHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
    val okHttpClientBuilder = OkHttpClient.Builder()
    okHttpClientBuilder.readTimeout(API_TIME_OUT, TimeUnit.SECONDS)
        .writeTimeout(API_TIME_OUT, TimeUnit.SECONDS).addInterceptor(interceptor)
        .addInterceptor { chain ->
            val requestBuilder = chain.request().newBuilder()
            requestBuilder.addHeader(
                "Authorization",
                Credentials.basic("a7025374ad2aea926b9d", "1b8b727bcdeabe8b3751371afa1fcd6ef2014520")
            )
            chain.proceed(requestBuilder.build())
        }
    return okHttpClientBuilder.build()
}

fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
    val interceptor = HttpLoggingInterceptor { logs -> Log.i("GithubUser API", logs) }
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    return interceptor
}

fun provideGitApi(retrofit: Retrofit): GitUserApis = retrofit.create(GitUserApis::class.java)


fun provideGson(): Gson {
    return GsonBuilder()
        .setLenient()
        .create()
}
