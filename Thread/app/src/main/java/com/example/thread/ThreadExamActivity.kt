package com.example.thread

import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_thread_exam.*
import kotlinx.android.synthetic.main.main.*
import kotlin.concurrent.thread

class ThreadExamActivity : AppCompatActivity() {
    var mynum:Int = 0
    var isRunning = false
    lateinit var mythrhand:Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread_exam)

        mythrhand = object : Handler(Looper.myLooper()!!){
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                mytextview.text = "progressbar진행률:${msg.arg1}%"
            }
        }
    }
    fun threadstart(view:View){
        thread{
            isRunning = true
            for (i in 1..10){
                mynum = i
                SystemClock.sleep(1000)
                var msg = Message()
                msg.arg1 = i
                mythrhand.sendMessage(msg)
            }

        }
    }

    override fun onPause() {
        super.onPause()
        isRunning = false
    }
}