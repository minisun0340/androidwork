package com.example.layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_event_test_exam1.*
import kotlinx.android.synthetic.main.activity_find_view_test.*

class EventTestExam1 : AppCompatActivity() , View.OnClickListener {

        //1번 방법
        var mybtn1 : Button?=null

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_event_test_exam1)
            mybtn1 = findViewById(R.id.mybtn1)
            mybtn1?.setOnClickListener(this)


        //2번 방법
        mybtn2.setOnClickListener(this)

        //3번 방법
        mybtn3.setOnClickListener(object:View.OnClickListener{
            override fun onClick(v: View?) {
                Toast.makeText(applicationContext, "btn3이 눌렸습니다", Toast.LENGTH_SHORT).show()
                mytext.text = "3번입니다."
            }
        })

        //4번 방법
        mybtn4.setOnClickListener{
            Toast.makeText(applicationContext, "btn4가 눌렸습니다", Toast.LENGTH_SHORT).show()
            mytext.text = "4번입니다."
        }

    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.mybtn1){
            Toast.makeText(this, "btn1이 눌렸습니다", Toast.LENGTH_SHORT).show()
            mytext.text = "1번입니다."
            editinfo.setText("버튼2(editText)")
            Log.d("test", editinfo.text.toString())
        }
        else if(v?.id == R.id.mybtn2){
            Toast.makeText(this, "btn2가 눌렸습니다", Toast.LENGTH_SHORT).show()
            mytext.text = "2번입니다."
        }
    }

}