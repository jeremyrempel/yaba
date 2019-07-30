package com.github.jeremyrempel.yaba.android.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import sample.Sample
import sample.hello
import com.github.jeremyrempel.yaba.android.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.main_text).text = "${hello()} ${Sample().checkMe()}"
    }
}