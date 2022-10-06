package com.example.basicview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_radio_button_test.*
import kotlinx.android.synthetic.main.check_box_exam.*

class RadioButtonTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio_button_test)
        val listener = RadioListener()
        group1.setOnCheckedChangeListener(listener)
        group2.setOnCheckedChangeListener(listener)
    }
    internal inner class RadioListener : RadioGroup.OnCheckedChangeListener{
        override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
            Log.d("test", "${group?.id.toString()}, $checkedId")
            val id1 = group1.checkedRadioButtonId
            val id2 = group2.checkedRadioButtonId //그룹내에서 선택된 라디오버튼id를 반환

            val radio1 = findViewById<RadioButton>(id1)
            val radio2 = findViewById<RadioButton>(group2.checkedRadioButtonId)
            txtdata1.text = "$id1 radio버튼이 선택됨 => ${radio1.text}"
            txtdata2.text = "$id2 radio버튼이 선택됨 => ${radio2.text}"
    /*       when(group?.id){
                R.id.group1 -> {
                    Log.d("test", "그룹1")
                    when (checkedId){
                        R.id.radioButton1 -> Log.d("test", "그룹1의 radio버튼1")
                        R.id.radioButton2 -> Log.d("test", "그룹1의 radio버튼2")
                        R.id.radioButton3 -> Log.d("test", "그룹1의 radio버튼3")
                    }
                }
                R.id.group2 -> Log.d("test", "그룹2")
            }*/
        }

    }
}