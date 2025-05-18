package com.zkkdinx.new.ui.activity

import android.os.Bundle

import androidx.activity.ComponentActivity

import com.zkkdinx.new.server.DhizukuDAReceiver

import org.koin.core.component.KoinComponent

class FinalizeActivity : ComponentActivity(), KoinComponent {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setResult(RESULT_OK)
        finish()
    }
}
