package com.zkkdinx.new.server

import com.zkkdinx.new.aidl.IDhizukuClient
import com.zkkdinx.new.server_api.DhizukuProvider
import com.zkkdinx.new.server_api.DhizukuService

import org.koin.core.component.KoinComponent

class MyDhizukuProvider : DhizukuProvider(), KoinComponent {
    override fun onCreateService(client: IDhizukuClient): DhizukuService {
        return MyDhizukuService(context, DhizukuState.component, client)
    }
}