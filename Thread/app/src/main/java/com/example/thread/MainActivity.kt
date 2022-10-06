package com.example.thread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //안드로이드에서 기본 쓰레드 생성하는 방법
    //원하는 곳에서 쓰레드를 종료
    var isRunning = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_event.setOnClickListener {
            val today = System.currentTimeMillis() //millisecond 은 천분의 일초 현재시간 측정
            myinfo.text = "today$today"
        }
        /* 오래걸리는 작업
            while(true){
            SystemClock.sleep(100) //0.1초
            val now = System.currentTimeMillis()
            Log.d("test", "$now")
        }*/
        //오래 걸리는 작업을 쓰레드로 처리
        isRunning = true
        val threadObj = object :Thread(){
            override fun run() {
                super.run()
                while (true) {
                    SystemClock.sleep(100) //0.1초
                    val now = System.currentTimeMillis()
                    Log.d("test", "$now")
                }
            }
        }
        threadObj.start()
    }

    override fun onPause() {
        super.onPause()
        isRunning = false //안드로이드 앱이 일시 정지 상태가 되면 쓰레드가 종료된다.
                          //한 번 종료된 쓰레드는 다시 실행할 수 없다.
    }
}