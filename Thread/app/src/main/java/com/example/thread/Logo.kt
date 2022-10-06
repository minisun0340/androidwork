package com.example.thread

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class Logo : AppCompatActivity() {
    lateinit var handler : Handler
    lateinit var threadObj : Thread
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logo)

        handler = Handler(Looper.myLooper()!!)
        threadObj = object : Thread(){
            override fun run() {
                super.run()
                //3초 후에 메인 액티비티 이동
                val intent = Intent(applicationContext, ThreadExamActivity_answer::class.java)
                startActivity(intent)
                finish()
            }
        }
        //쓰레드에서 지속적으로 화면을 변경하는 경우는 반복문 내부에서 post를 요청했지만 한 번만 작업을 의뢰하는 경우
        //밖에서 한 번만 메소드를 호출하면 된다.
        handler.postDelayed(threadObj, 5000)
    }
    //뒤로가기 버튼을 눌렀을 때 호출되는 메소드
    //뒤로가기 버튼을 눌러서 5초가 되기 전에 쓰레드 실행을 취소하고 싶은 경우
    override fun onBackPressed() {
        handler.removeCallbacks(threadObj)
    }
}