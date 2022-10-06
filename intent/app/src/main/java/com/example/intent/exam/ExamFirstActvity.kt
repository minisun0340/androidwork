package com.example.intent.exam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.intent.R
import kotlinx.android.synthetic.main.firstexam.*

class ExamFirstAcitivity : AppCompatActivity() , View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.firstexam)
        Button01.setOnClickListener(this)
        Button02.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.Button01 -> {
                val intent = Intent(this, ExamSecondActivity::class.java).apply {
                    putExtra("name", "${EditText01.text}")
                    putExtra("telNum", "${EditText02.text}")

                }
                startActivityForResult(intent, 100)
            }
        }
    }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            when (requestCode) {
                100 -> {
                    val chkVal: Boolean? = data?.getBooleanExtra("chkVal", false)
                    if (chkVal == true) {
                        first_return.text = "우수회원설정"
                    }
                }
            }
        }
    }

