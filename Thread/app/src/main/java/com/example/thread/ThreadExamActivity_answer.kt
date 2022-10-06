package com.example.thread

import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_thread_exam.*
import kotlinx.android.synthetic.main.main.*
import kotlin.concurrent.thread

class ThreadExamActivity_answer : AppCompatActivity() {
    var num:Int = 0
    lateinit var myhandler:Handler
    var isRunning = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread_exam)
        //3. 핸들러객체 생성
        myhandler = Handler(Looper.myLooper()!!)

        //2. UI의 구성요소를 변경하는 쓰레드를 정의 - handleMessage메소드 내부에서 처리하던 작업을 별도의 쓰레드로 작성
        var uithread = object:Thread(){
            override fun run(){
                super.run()
                mytextview.text = "$num"
            }
        }
        //1. 오래걸리는 작업을 처리할 쓰레드 생성
        isRunning = true
        thread {
            var i = 1
            while(isRunning){
                num = i
                //핸들러에서 처리할 쓰레드 객체를 만들어서 의뢰
                //post메소드를 이용해서 핸들러에게 처리할 쓰레드 객체를 넘기기
                myhandler.post(uithread)
                SystemClock.sleep(1000)
                i += 1
                if(i>10){
                    break
                }
            }
        }
        btn_start.setOnClickListener {
            //stop버튼을 눌러서 종료시킨 쓰레드를 다시 start하는 것이 아니라 새롭게 쓰레드를 만들어서 start하기
            //thread{}아니라 var workerthread = object:Thread(){}와 같이 정의해서 workerthread객체를 start하기
        }

        btn_stop.setOnClickListener {
            isRunning = false
        }
    }
}