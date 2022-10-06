package com.example.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //인텐트는 액티비티 간에 정보를 전달하기 위해서 제공되는 객체
        //명시적 인텐트 - 정확하게 어떤 액티비티에서 전달할지 명시하고 작업
        //암시적 인텐트

        //명시적 인텐트
        //context객체와 실행할 액티비티의 클래스명
        //------------------------------------ 안드로이드 내부에서 코틀린클래스가 자바클래스로 변환
        //                                      .kt -> .java -> .class(바이트코드 or 클래스파일)
        //                                                      ------ 머신내부에서 실행되는 파일
        //1) 인텐트객체에 실행할 구성요소에 대한 정보를 셋팅
        //2) 안드로이드os에 실행 요청을 하며 인텐트객체를 넘긴다.
        //3) 안드로이드os에서 인텐트에 명시된 정보를 보며 실행할 객체를 파악한다.
        //4) 인텐트에 명시된 컴포넌트를 실행하고 인텐트 객체를 실행되는 컴포넌트 쪽으로 넘겨준다.
        //  =>실행될 컴포넌트(액티비티)에 넘겨줄 데이터를 공유할 수 있다.
        //  =>intent.putExtra메소드를 이용해서 데이터공유
        button.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("info", "첫번째 액티비티가 넘기는 메시지")
                putExtra("num", 10000)
            }
            //실행될 액티비티에 넘겨줄 데이터를 인텐트에 저장
/*            intent.putExtra("info", "첫번째 액티비티가 넘기는 메시지")
            intent.putExtra("num", 10000)*/
            startActivity(intent)
        }
    }
}