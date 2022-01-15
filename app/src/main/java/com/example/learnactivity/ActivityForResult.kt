package com.example.learnactivity

import android.os.Bundle
import android.content.Intent
import java.util.Timer
import kotlin.concurrent.schedule

class ActivityForResult : BaseActivity("asctivityForResult") {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_for_result)
        setResult(RESULT_OK, Intent().putExtra("message", "Some interesting data!"))
        Timer("SettingUp", false).schedule(500) {
            finish()
        }
    }

}