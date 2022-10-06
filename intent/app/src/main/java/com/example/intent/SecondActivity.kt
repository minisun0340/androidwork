package com.example.intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second)
        //안드로이드os가 넘겨준 인텐트객체를 가져온다
        val intent = intent //getIntent()과 동일
        //인텐트에 공유된 데이터 꺼내기 - getXXXXExtra("공유명")
        //                             ------------ 타입
        val msg = intent.getStringExtra("info")
        val data = intent.getIntExtra("num", 0)
        Toast.makeText(this, "추출한 값: $msg, $data", Toast.LENGTH_SHORT).show()
        bt2.setOnClickListener{
            //버튼을 누르면 액티비티 종료하기
            finish()
        }
    }
}