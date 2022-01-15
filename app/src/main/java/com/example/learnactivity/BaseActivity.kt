package com.example.learnactivity

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

abstract class BaseActivity(private val name: String) : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("state - " + name, "onCreate in task " + this.taskId.toString());
    }
    override fun onStart() {
        super.onStart()
        Log.e("state - " + name, "start ");
    }

    override fun onResume() {
        super.onResume()
        Log.e("state - " + name, "resumed");
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.e("onSaveInstanceState - " + name, "start");
        val random: Int = Random(System.nanoTime()).nextInt(11)
        outState.putString("message", random.toString());
        super.onSaveInstanceState(outState)
    }

    override fun onPause() {
        super.onPause()
        Log.e("state - " + name, "paused");
    }

    override fun onStop() {
        super.onStop()
        Log.e("state - " + name, "stopped")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("state - " + name, "restarted");
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("state - " + name, "will destroy");
    }
}