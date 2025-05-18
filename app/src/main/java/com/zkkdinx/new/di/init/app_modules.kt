package com.zkkdinx.new.di.init

import com.zkkdinx.new.di.preferencesModule
import com.zkkdinx.new.di.reflectModule
import com.zkkdinx.new.di.roomModule
import com.zkkdinx.new.di.viewModelModule

val appModules = listOf(
    roomModule,
    viewModelModule,
    reflectModule,
    preferencesModule
)