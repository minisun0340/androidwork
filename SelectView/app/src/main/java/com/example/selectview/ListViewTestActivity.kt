package com.example.selectview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.listview_test.*

class ListViewTestActivity : AppCompatActivity() {
    //1. ListView에 출력할 데이터
    var datalist = arrayOf<String>("python", "Django", "arduino", "raspberrypi"
        , "android","mqtt","tcp", "java", "spring", "hadoop", "spark", "sqoop", "flume", "servlet", "jsp")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listview_test)

        //2. row에 대한 디자인은 안드로이드에서 제공하는 디자인을 활용
        //3. 데이터+row에 대한 디자인을 이용해서 ListView에 출력하는 결과물을 만들어줄 adapter를 생성
        //context가 안드로이드 내부에서 처리될 다양한 기능들을 담고 있는 객체, 화면을 구성하기 위해서
        //필요한 화면정보, os와 통신하기 위한 여러가지 기본내용을 담고 있는 객체
        // 많은 작업을 할 때 context가 필요
        val myadapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, datalist)

        //4. ListView에 어댑터를 연결
        listview1.adapter = myadapter
        //var myadapter2 = listview1.adapter
        listview1.onItemClickListener = mylistener
    }
    var mylistener = AdapterView.OnItemClickListener { parent, view, position, id ->
        Log.d("test", "parent -> $parent, view -> $view, position- > $position, id -> $id ")
        //안드로이드에서 제공되는 디자인에 포함된 com.google.android.material.textview.MaterialTextViewTextView를
        //TextView로 캐스팅(캐스팅이 가능한 건 상속관계에 있기 때문)
        var mytextview = view as TextView //자식을 부모타입으로 업캐스팅
        listtext.text = "선택한 항목: ${datalist[position]} => view ${mytextview.text}"
    }
}