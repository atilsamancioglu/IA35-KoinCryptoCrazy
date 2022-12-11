package com.atilsamancioglu.koinretrofit

import android.app.Application
import com.atilsamancioglu.koinretrofit.di.anotherModule
import com.atilsamancioglu.koinretrofit.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(appModule, anotherModule)
        }
    }
}