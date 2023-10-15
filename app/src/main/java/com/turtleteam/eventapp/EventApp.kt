package com.turtleteam.eventapp

import android.app.Application
import com.turtleteam.eventapp.di.featureOne
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class EventApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@EventApp)
            androidLogger(Level.DEBUG)
            modules(featureOne)
        }
    }
}
