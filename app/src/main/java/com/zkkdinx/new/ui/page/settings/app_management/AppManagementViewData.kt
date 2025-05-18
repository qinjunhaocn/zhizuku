package com.zkkdinx.new.ui.page.settings.app_management

import android.content.pm.ApplicationInfo

data class AppManagementViewData(
    val applicationInfo: ApplicationInfo,
    val enabled: Boolean
)