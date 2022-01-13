package com.example.learnactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    private lateinit var tvState :TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e("onCreate", this.taskId.toString());
        if(!this::tvState.isInitialized){
            println("notInitialized")
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState?.getString("message") != null) {
            val message = savedInstanceState.getString("message")
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }
        tvState = findViewById(R.id.tv_state)
        val btnGoto2: Button = findViewById(R.id.btn_goto2)
        btnGoto2.setOnClickListener {
            // Code here executes on main thread after user presses button
            val intent = Intent(this, Screen2::class.java)
            intent.putExtra("message", 15)
            startActivity(intent)
        }
        val btnGoto1: Button = findViewById(R.id.btn_goto1)
        btnGoto1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }


    override fun onStart() {

        if(this::tvState.isInitialized){
            println("initialized")
        }
        super.onStart()
        tvState.setText("started")
        Log.e("onStart", this.taskId.toString());
    }

    override fun onResume() {
        super.onResume()
        tvState.setText("resumed")
        Log.e("onResume", "resumed");
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.e("onSaveInstanceState", "start");
        val random: Int = Random(System.nanoTime()).nextInt(11)
        outState.putString("message", random.toString());
        super.onSaveInstanceState(outState)
    }

    override fun onPause() {
        tvState.setText("will pause")
        super.onPause()
        tvState.setText("paused")
        Log.e("onPause", "paused");
    }

    override fun onStop() {
        tvState.setText("will stopped")
        super.onStop()
        tvState.setText("stopped")
        Log.e("onStop", "stopped")
    }

    override fun onRestart() {
        super.onRestart()
        tvState.setText("restarted")
        Log.e("onRestart", "restarted");
    }

    override fun onDestroy() {
        tvState.setText("will destroy")
        super.onDestroy()
        Log.e("onDestroy", "will destroy");
    }
}
