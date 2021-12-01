package com.example.vontoil2.network

import com.example.vontoil2.BuildConfig
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    companion object {

        private const val BASE_URL = "https://maps.googleapis.com/maps/api/"
        private val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level =
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE


        }
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        fun buildRequest(): ApiService {

            val okHttpClient = OkHttpClient.Builder()
                .addNetworkInterceptor(httpLoggingInterceptor)
                .addInterceptor { chain ->
                    val request = chain.request()
                    val authRequest = request.newBuilder()
                        .header("Content-Type", "application/json")
                        .build()
                    return@addInterceptor chain.proceed(authRequest)
                }.build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
                .create(ApiService::class.java)

        }

    }


    @GET("place/nearbySearch/json")
    fun getNearbyPlaces(
        @Query("location") location: String,
        @Query("radius") radius: String = "4000",
        @Query("type") type: String = "gas_station",
        @Query("key") key: String = BuildConfig.MAPS_API_KEY,

        )
}