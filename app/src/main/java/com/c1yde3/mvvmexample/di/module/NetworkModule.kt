package com.c1yde3.mvvmexample.di.module

import android.util.Log
import com.c1yde3.mvvmexample.model.repository.network.CONNECT_TIMEOUT
import com.c1yde3.mvvmexample.model.repository.network.READ_TIMEOUT
import com.c1yde3.mvvmexample.model.repository.network.SERVER_URL
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.net.URLDecoder
import java.util.concurrent.TimeUnit

@Module
object NetworkModule {

    @Provides
    @Reusable
    @JvmStatic
    fun provideOkHttpClient(interceptor: Interceptor):OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .readTimeout(READ_TIMEOUT,TimeUnit.SECONDS)
            .connectTimeout(CONNECT_TIMEOUT,TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Reusable
    @JvmStatic
    fun provideHttpLoggingInterceptor():Interceptor{
        return HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
            try {
                Log.e("NETWORK-----", URLDecoder.decode(it, "utf-8"))
            } catch (e: Throwable) {
                e.printStackTrace()
                Log.e("NETWORK-----", it)
            }
        })
    }

    @Provides
    @Reusable
    @JvmStatic
    fun provideRetrofitClient(okHttpClient: OkHttpClient):Retrofit{
        return Retrofit.Builder()
            .baseUrl(SERVER_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

}