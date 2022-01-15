package com.example.learnactivity

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class MainActivity : BaseActivity("screen1") {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState?.getString("message") != null) {
            val message = savedInstanceState.getString("message")
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }
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

        findViewById<Button>(R.id.btn_implicit_intent).setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL).setData(Uri.parse("tel:" + "0393072748"))
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                val REQUEST_PHONE_CALL = 0
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.CALL_PHONE), REQUEST_PHONE_CALL
                );
            }
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }
        // start activity custom for result
        val getResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    Toast.makeText(this, result.data?.getStringExtra("message"), Toast.LENGTH_SHORT).show()
                }
            }
        findViewById<Button>(R.id.btnGoForResult).setOnClickListener {
            getResult.launch(Intent(this, ActivityForResult::class.java))
        }
        // start activity available for result
        findViewById<Button>(R.id.btnTakePhoto).setOnClickListener {

        }
    }


}
