package com.example.di

import android.content.Context
import com.example.data.remote.PokemonServices
import com.example.data.remote.UnsafeOkHttpClient.unsafeOkHttpClient
import com.example.imagefromapi.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val remoteDataSourceModule = module {
    single { createOkHttpClient(androidContext()) }
    single { createAPIService<PokemonServices>(get()) }

}

fun createOkHttpClient(context: Context): OkHttpClient {
    val httpClient = unsafeOkHttpClient
        .connectTimeout(60L, TimeUnit.SECONDS)
        .readTimeout(60L, TimeUnit.SECONDS)
//        .addInterceptor { chain ->
//            val newRequest = chain.request().newBuilder()
//                .addHeader("Authorization", "Bearer ${Hawk.get("USER_ACCESS_TOKEN", "")}")
//                .addHeader("deviceos", "android")
//                .addHeader("appversion", BuildConfig.VERSION_NAME)
//                .build()
//            chain.proceed(newRequest)
//        }

    return if (BuildConfig.DEBUG) {
        httpClient.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    } else {
        httpClient.build()
    }
}

inline fun <reified T> createAPIService(okHttpClient: OkHttpClient): T {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()
    return retrofit.create(T::class.java)
}
