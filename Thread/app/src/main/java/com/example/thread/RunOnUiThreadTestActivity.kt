package com.example.thread

import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_run_on_ui_thread_test.*
import kotlin.concurrent.thread

class RunOnUiThreadTestActivity : AppCompatActivity() ,View.OnClickListener{
    var isRunning = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_run_on_ui_thread_test)
        //사용자가 만든 쓰레드
        isRunning = true
        thread{
            while (isRunning) {
                SystemClock.sleep(1000)
                val now_time = System.currentTimeMillis()
                Log.d("mythread", "now_time=$now_time")
                runOnUiThread {
                    txtView1.text = "runOnUiThread:$now_time"
                }
                SystemClock.sleep(500)
                runOnUiThread {
                    txtView2.text = "다음 작업으로 또 다른 뷰를 수정할 수 있다."
                }
            }
        }
        button.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        txtView1.text = "test........"
        txtView2.text = "thread....runOnUiThread"
    }
}