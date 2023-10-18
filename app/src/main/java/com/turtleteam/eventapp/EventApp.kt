package com.turtleteam.eventapp

import android.app.Application
import com.turtleteam.eventapp.di.commonModule
import com.turtleteam.eventapp.di.featureModule.accountModule
import com.turtleteam.eventapp.di.featureModule.eventModule
import com.turtleteam.eventapp.di.featureModule.homeModule
import com.turtleteam.eventapp.di.featureModule.profileModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class EventApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@EventApp)
            androidLogger(Level.DEBUG)
            modules(commonModule, accountModule, homeModule, eventModule, profileModule)
        }
    }
}
