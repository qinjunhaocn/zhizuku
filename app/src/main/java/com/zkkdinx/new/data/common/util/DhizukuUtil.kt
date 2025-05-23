package com.zkkdinx.new.data.common.util

import android.content.pm.PackageManager

import com.zkkdinx.new.api.Dhizuku
import com.zkkdinx.new.api.DhizukuRequestPermissionListener
import com.zkkdinx.new.data.common.model.exception.DhizukuNotWorkException

import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first

private suspend fun blockingRequestDhizukuPermission() = callbackFlow {
    Dhizuku.requestPermission(object : DhizukuRequestPermissionListener() {
        override fun onRequestPermission(grantResult: Int) {
            if (grantResult == PackageManager.PERMISSION_GRANTED) trySend(Unit)
            else close(DhizukuNotWorkException("dhizuku permission denied"))
        }
    })
    awaitClose()
}.catch {
    throw if (it !is DhizukuNotWorkException) DhizukuNotWorkException(cause = it)
    else it
}.first()

suspend fun <T> requireDhizukuPermissionGranted(action: suspend () -> T): T {
    if (!Dhizuku.init()) throw DhizukuNotWorkException("dhizuku isn't activated")
    if (!Dhizuku.isPermissionGranted())
        blockingRequestDhizukuPermission()
    return action()
}