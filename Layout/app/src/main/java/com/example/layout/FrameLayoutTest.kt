package com.example.layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_frame_layout_test.*

class FrameLayoutTest : AppCompatActivity(), View.OnClickListener {
    var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame_layout_test)
        btnimagechange.setOnClickListener(this)
    }

    //이미지선택버튼이 선택될때마다 이미지가 교체되어 보이도록 구현
    override fun onClick(v: View?) {
        if(index == 0){
            //0번에 해당하는 이미지를 화면에 보이도록 설정
            img02.visibility = View.VISIBLE
            //기존에 보였던 이미지는 화면에 보이지 않도록 설정
            img01.visibility = View.INVISIBLE
            Log.d("test", "현재 index == $index")
            index = 1

        }else if(index==1){
            img01.visibility = View.VISIBLE
            img02.visibility = View.INVISIBLE
            Log.d("test", "현재 index == $index")
            index = 0
        }
    }
}