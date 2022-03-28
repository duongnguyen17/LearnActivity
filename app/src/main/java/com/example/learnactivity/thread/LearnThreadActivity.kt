package com.example.learnactivity.thread

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.learnactivity.R


class LearnThreadActivity : AppCompatActivity() {

    companion object {
        const val MESSAGE_UPDATE_TEXT_CHILD_THREAD = 1
        var count: Int = 0
    }

    private lateinit var btnProgress: Button
    private lateinit var pbProgress: ProgressBar
    private lateinit var tvProgress: TextView
    private lateinit var btnDownload: Button
    private lateinit var ivDownload: ImageView

    private var updateUIHandler: Handler? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.learn_thread_activity)
        bindingView()
        createUpdateUIHandler()
        clickView()
    }

    private fun bindingView() {
        btnProgress = findViewById(R.id.btnProgress)
        pbProgress = findViewById(R.id.pbProgress)
        tvProgress = findViewById(R.id.tvProgress)
        btnDownload = findViewById(R.id.btnDownload)
        ivDownload = findViewById(R.id.ivDownload)
    }

    private fun clickView() {
        btnProgress.setOnClickListener {
            startProgress()
        }
    }

    private fun startProgress() {
        val progressThread = object : Thread() {
            override fun start() {
                super.start()
                Log.d("thread${++count}", "${this.id} start")
            }

            override fun run() {
                super.run()
                for (i in 0..10) {
                    wait500ms()
                    val message = Message()
                    message.what = MESSAGE_UPDATE_TEXT_CHILD_THREAD
                    message.arg1 = i
                    updateUIHandler!!.sendMessage(message)
                }
                Log.d("thread${++count}", "${this.id} destroy")
            }
        }
        tvProgress.text = progressThread.id.toString()
        progressThread.start()
    }

    private fun createUpdateUIHandler() {
        if (updateUIHandler == null) {
            updateUIHandler = object : Handler(Looper.getMainLooper()) {
                override fun handleMessage(msg: Message) {
                    if (msg.what == MESSAGE_UPDATE_TEXT_CHILD_THREAD) {
                        pbProgress.progress = msg.arg1
                    }
                }
            }
        }
    }

    private fun wait500ms() {
//        Timer("SettingUp", false).schedule(500){}
        Thread.sleep(500);
    }
}
