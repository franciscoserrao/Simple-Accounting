package com.emmanuelmess.simpleaccounting

import android.app.Application
import android.content.Context
import android.widget.Toast

import org.acra.ACRA
import org.acra.annotation.AcraCore
import org.acra.annotation.AcraHttpSender
import org.acra.annotation.AcraToast

@AcraCore(buildConfigClass = BuildConfig::class)
@AcraHttpSender(uri = "https://emmanuelmess.cloudant.com/acra-simpleaccounting/_design/acra-storage/_update/report",
        httpMethod = org.acra.sender.HttpSender.Method.PUT,
        basicAuthLogin = "greardelecarecessingstin",
        basicAuthPassword = "607cb9c826c6f7e4eca1bee1540f8e285e5a0a17")
@AcraToast(resText = R.string.crash_toast_text)
class SimpleAccountingApplication : Application() {
    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)

        // The following line triggers the initialization of ACRA
        if (!BuildConfig.DEBUG) ACRA.init(this)
    }
}

