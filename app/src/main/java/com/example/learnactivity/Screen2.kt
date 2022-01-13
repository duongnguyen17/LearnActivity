package com.example.learnactivity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Button

class Screen2 : BaseActivity(2) {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e("state2", "onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen2)
        val receiveData: String = intent.getIntExtra("message", 10).toString()
        val tvReceiveData: TextView = findViewById(R.id.tv_receive_data)
        tvReceiveData.setText(receiveData)
        val btnGoto1: Button = findViewById(R.id.btn_goto1)
        btnGoto1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val btnGoto2: Button = findViewById(R.id.btn_goto2)
        btnGoto2.setOnClickListener {
            val intent = Intent(this, Screen2::class.java)
            startActivity(intent)
        }
    }

}