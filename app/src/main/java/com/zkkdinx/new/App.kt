package com.zkkdinx.new

import android.app.Application

import com.google.android.material.color.DynamicColors

import com.zkkdinx.new.di.init.appModules
import com.zkkdinx.new.server.DhizukuState
import com.zkkdinx.new.server.RunningService

import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin
import org.koin.dsl.module

import rikka.sui.Sui

class App : Application(), KoinComponent {
    override fun onCreate() {
        super.onCreate()
        DhizukuState.sync(this)
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appModules)
            modules(module { single { this@App } })
        }
        Sui.init(packageName)
        RunningService.start(this)
        DynamicColors.applyToActivitiesIfAvailable(this)
    }
}
