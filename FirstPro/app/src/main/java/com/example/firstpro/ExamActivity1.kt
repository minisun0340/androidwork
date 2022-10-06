package com.example.firstpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast

class ExamActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exam1)
    }
    fun ClickSave(view: View){
        Toast.makeText(this, "저장완료", Toast.LENGTH_SHORT).show()
    }
    fun ClickUpdate(view: View){
        Log.d("mytest2", "업데이트되었습니다.")
    }
}