package com.example.learnactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class FragmentActivity : BaseActivity("FragmentActivity") {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
    }
}