package com.example.learnactivity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

abstract class BaseActivity(private val orderScreen: Int) : AppCompatActivity() {

    override fun onStart() {
        super.onStart()
        Log.e("state" + orderScreen, "start " + this.taskId.toString());
    }

    override fun onResume() {
        super.onResume()
        Log.e("state1", "resumed");
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.e("onSaveInstanceState" + orderScreen, "start");
        val random: Int = Random(System.nanoTime()).nextInt(11)
        outState.putString("message", random.toString());
        super.onSaveInstanceState(outState)
    }

    override fun onPause() {
        super.onPause()
        Log.e("state" + orderScreen, "paused");
    }

    override fun onStop() {
        super.onStop()
        Log.e("state" + orderScreen, "stopped")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("state" + orderScreen, "restarted");
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("state" + orderScreen, "will destroy");
    }
}