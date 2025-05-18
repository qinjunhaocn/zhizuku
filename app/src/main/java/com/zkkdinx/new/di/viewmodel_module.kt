package com.zkkdinx.new.di

import com.zkkdinx.new.ui.page.settings.activate.ActivateViewModel
import com.zkkdinx.new.ui.page.settings.app_management.AppManagementViewModel

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        AppManagementViewModel()
    }
    viewModel {
        ActivateViewModel()
    }
}