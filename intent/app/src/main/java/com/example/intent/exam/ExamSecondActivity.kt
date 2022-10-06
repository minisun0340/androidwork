package com.example.intent.exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intent.R
import kotlinx.android.synthetic.main.secondexam.*

class ExamSecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.secondexam)
        val intent = intent
        val name = intent.getStringExtra("name")
        val telNum = intent.getStringExtra("telNum")
        exam_result_txt.text = "name:$name, phone:$telNum"

        exam_close.setOnClickListener{
            intent.putExtra("chkVal", member_state.isChecked)
            setResult(RESULT_OK, intent)
            finish()
        }

    }
}