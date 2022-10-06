package com.example.thread

import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.main.*
import kotlin.concurrent.thread

class ThreadTestActivity : AppCompatActivity() {
    var progressVal:Int = 0
    lateinit var myhandler:Handler
    lateinit var myhandler2:Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        //루퍼객체를 만들어서 매개변수로 전달해야 한다.
        //작업 요청을 기다리고 있다가 이 작업을 처리해주세요라고 요청이 들어오면 작업을 처리하는 일을 내부에서 받아서 수행할 객체
        myhandler = object : Handler(Looper.myLooper()!!){
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                text1.text = "progressbar의 진행률:$progressVal %"
                progressBar.incrementProgressBy(1) //ProgressBar의 progress속성을 1씩 증가
            }
        }
        myhandler2 = object :Handler(Looper.myLooper()!!){
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                when(msg.what){
                    0 -> text1.text = "progressbar진행률:${msg.arg2}% ----- ${msg.arg1}, ${msg.obj}"

                    1 -> {
                        progressBar.progress = msg.arg2
                        text1.text = "*"}
                }
            }
        }
    }
    /*
    [화면 변경하는 작업을 다른 메소드에서 처리]
    긴 시간동안 실행하며 view를 변경하려고 하는 경우 실행되는 동안 다른 작업을 할 수 없다.
    이벤트에 5초 동안 반응하지 않으면 안드로이드 os는 어플리케이션을 강제 종료한다.
    */
    fun btnNoThread(view: View){
        for(i in 1..10){
            progressBar.progress = i
            SystemClock.sleep(1000)
        }
    }
    /*
    * 개발자가 쓰레드를 만들어서 작업
    *  - 하위버전은 os에서는 문제를 발생시킬 수 있다.(UI에 대한 변경은 UI쓰레드에서만 작업)
    */
    fun useThread(view: View){
        thread { //코틀린 안드로이드에서 쓰레드를 생성하고 start
            for(i in 1..10){
                progressBar.progress = i
                SystemClock.sleep(1000)
            }
        }
    }
    fun useHandler(view: View){
        thread{
            for(i in 1..10){
                //progressBar.progress = i ----> 사용자정의쓰레드(개발자가 만든 쓰레드, worker Thread)에서 화면을 변경할 수 없다.
                progressVal = i
                SystemClock.sleep(1000)
                //핸들러객체에게 작업을 의뢰 - 핸들러객체 내부에 있는 메시지객체를 넘기면서
                myhandler.sendMessage(myhandler.obtainMessage())
            }
        }
    }
    //작업을 구분하기 위해서 Message객체를 만들어서 작업할 수 있다.
    fun useMessageHandler(view: View){
        thread {
            for (i in 1..10) {
                progressVal = i
                SystemClock.sleep(1000)
                //변경할 뷰의 정보나 Handler에게 전달할 데이터, 작업의 구분코드 등을 Message객체를 생성해서 셋팅할 수 있다.
                var msg = Message()
                //Handler에게 작업을 의뢰한 쓰레드를 구분하거나 작업의 종류를 구분해야 하는 경우
                if (i % 2 == 0) {
                    msg.what = 0 //what은 구분하기 위한 코드
                } else {
                    msg.what = 1
                }
                msg.arg2 = i
                msg.arg1 = 100 //Int값을 넘기고 싶은 경우 전달
                msg.obj = "객체" //객체를 핸들러에게 넘기는 경우 사용

                //핸들러에게 작업 의뢰
                myhandler2.sendMessage(msg)
            }
        }
    }
}