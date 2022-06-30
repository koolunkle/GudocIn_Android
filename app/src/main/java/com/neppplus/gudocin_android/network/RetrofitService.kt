package com.neppplus.gudocin_android.network

import android.content.Context
import com.google.gson.GsonBuilder
import com.neppplus.gudocin_android.util.Context
import com.neppplus.gudocin_android.util.DateDeserializer
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class RetrofitService {
    companion object {
        private var BASE_URL = "https://api.gudoc.in"
        private var retrofit: Retrofit? = null

        fun getRetrofit(context: android.content.Context): Retrofit {
            if (retrofit == null) {
                val interceptor = Interceptor {
                    with(it) {
                        val newRequest = request().newBuilder()
                            .addHeader("X-Http-Token", Context.getToken(context))
                            .build()
                        proceed(newRequest)
                    }
                }
                val myClient = OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build()

                val gson = GsonBuilder()
                    .setDateFormat("yyyy-MM-dd HH:mm:ss")
                    .registerTypeAdapter(
                        Date::class.java,
                        DateDeserializer()
                    )  // Date 형태로 실제 파싱 진행 클래스 추가
                    .create()

                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(myClient)
                    .build()
            }
            return retrofit!!
        }
    }
}