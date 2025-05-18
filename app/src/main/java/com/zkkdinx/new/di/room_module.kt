package com.zkkdinx.new.di

import com.zkkdinx.new.data.settings.model.room.DhizukuRoom
import com.zkkdinx.new.data.settings.model.room.impl.AppRepoImpl
import com.zkkdinx.new.data.settings.repo.AppRepo

import org.koin.dsl.module

val roomModule = module {
    single {
        DhizukuRoom.createInstance()
    }

    single<AppRepo> {
        val room = get<DhizukuRoom>()
        AppRepoImpl(room.appDao)
    }
}