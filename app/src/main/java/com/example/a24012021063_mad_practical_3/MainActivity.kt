package com.example.a24012021085_practical3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.constraintlayout.widget.Constraints
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a24012021063_mad_practical_3.LoginActivity
import com.example.a24012021063_mad_practical_3.R


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        implecitintent()
        explicitintent()
    }
    fun implecitintent() {
        findViewById<Button>(R.id.btn_browse).setOnClickListener {
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse(findViewById<EditText>(R.id.editTextText).text.toString())
            ).also {
                startActivity(it)
            }
        }
        val number = findViewById<EditText>(R.id.editTextPhone).text.toString()
        val intent = Intent(Intent.ACTION_DIAL).setData("tel:$number".toUri())
        val buttoncall = findViewById<Button>(R.id.btn_call)
        buttoncall.setOnClickListener {
            startActivity(intent)
        }
        findViewById<Button>(R.id.btn_camera).setOnClickListener {
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).also {
                startActivity(it)
            }

        }
        findViewById<Button>(R.id.btn_gallery).setOnClickListener {
            Intent(Intent.ACTION_VIEW).setType("image/*").apply {
                startActivity(this)
            }

        }
        findViewById<Button>(R.id.btn_calllog).setOnClickListener {
            Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE).apply {
                startActivity(this)
            }
        }
        findViewById<Button>(R.id.btn_alarm).setOnClickListener {
            Intent(AlarmClock.ACTION_SHOW_ALARMS).also {
                startActivity(it)
            }
        }
    }
    fun explicitintent(){
        findViewById<Button>(R.id.btn_login).setOnClickListener {
            Intent(this@MainActivity, LoginActivity
            ::class.java).also {
                startActivity(it)
            }
        }

    }
}