package com.example.layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_frame_layout_exam.*

class FrameLayoutExam : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame_layout_exam)
        btn_login.setOnClickListener(this)
        btn_register.setOnClickListener(this)
        btn_detail.setOnClickListener(this)
        btnregisterrun.setOnClickListener {
            //editinfo.setText("${editreg_name.text},${editreg_id.text},${editreg_pass.text}")
            editinfo.text = editreg_name.text.toString() +","+ editreg_id.text.toString() +","+ editreg_pass.text.toString()
        }
    }
    //framelayout에서 제어할 뷰(리니어레이아웃)가 여러 개 이므로 id속성으로 구분
    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_login) {
            linear_login.visibility = View.VISIBLE
            linear_register.visibility = View.INVISIBLE
            linear_info.visibility = View.INVISIBLE
        }
        else if (v?.id == R.id.btn_register) {
            linear_login.visibility = View.INVISIBLE
            linear_register.visibility = View.VISIBLE
            linear_info.visibility = View.INVISIBLE
        }
        else if (v?.id == R.id.btn_detail) {
            linear_login.visibility = View.INVISIBLE
            linear_register.visibility = View.INVISIBLE
            linear_info.visibility = View.VISIBLE
        }


    }}