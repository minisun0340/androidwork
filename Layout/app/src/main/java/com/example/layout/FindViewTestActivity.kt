package com.example.layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_find_view_test.*
import layout.MyListener
import java.util.*

//xml에 추가한 view에 코드를 연결

class FindViewTestActivity : AppCompatActivity(), View.OnClickListener {
    var mybtn: Button?= null
    var txtresult:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // R클래스는 안드로이드 내부에서 리소스를 관리하는 객체 - 안드로이드가 자동으로 생성해주는 클래스
        // res폴더안에 저장하는 모든 파일들, String.xml에 정의하는 문자열, id 속성 ...... 많은 것들을 관리
        setContentView(R.layout.activity_find_view_test)
        // 1) click이벤트는 메소드를 정의한 후 xml에서 onClick속성에 메소드를 연결 - 약식, 추천하지 않는 방법
        // 2)직접 찾아오기
        mybtn = findViewById(R.id.btn_Click)
        txtresult = findViewById(R.id.result)
        mybtn?.setOnClickListener(this) //액티비티이면서 리스너

        /*var listener:MyListener = MyListener()
        mybtn?.setOnClickListener(listener)*/

        //this는 이벤트를 처리할 내용이 담겨있는 리스너 객체
        //2. xml import하고 바로 사용하기
        btnxmlimport.setOnClickListener(this)


        //3. 익명리스너클랫를 만들어서 작업하기
        btnanonymous.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                //this는 Context의 하위가 아니라 View.OnclickListener의 하위이므로 getApplicationContext() 메소드를 이용해서
                //Context객체를 넘긴다
                Toast.makeText(applicationContext, "익명클래스로 리스너 구현", Toast.LENGTH_LONG).show()
            }
        })

        //4. 람다로 익명리스너를 만들어서 작업하기
        btnanonymous_lambda.setOnClickListener{
                Toast.makeText(applicationContext, "익명클래스 람다로 리스너 구현", Toast.LENGTH_LONG).show()
                result.text = "지금은 이벤트 연결 연습중.." //TextView의 setText호출
                                                          //result.setText("지금은 이벤트 연결 연습 중..")와 동일
            }
    }

    //onClick메소드의 매개변수인 View객체에는 이벤트 객체가 전달된다.
    //안드로이드OS내부에서 이벤트가 발생할 때 onClick메소드를 호출하면서 이벤트를 발생시킨 위젯객체를 같이 넘긴다.
    override fun onClick(v: View?) {
        Log.d("test", v?.id.toString()) //v.getId()의 결과가 int이므로 toString()을 호출해서 String으로 변환
        if(v?.id == R.id.btn_Click) {
            mybtn?.text = Date().toString() // mybtn.setText(Data().toString())
            Toast.makeText(this, "android event text...", Toast.LENGTH_LONG).show()
        }
        else if(v?.id == R.id.btnxmlimport){
            myimg.setImageResource(R.drawable.img01)
        }
    }
}