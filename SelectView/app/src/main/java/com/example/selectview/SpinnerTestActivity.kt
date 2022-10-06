package com.example.selectview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_spinner_test.*

class SpinnerTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner_test)

        val myadapter = ArrayAdapter.createFromResource(this, R.array.mylist_data, android.R.layout.simple_spinner_item)
        val autoAdapter = ArrayAdapter.createFromResource(this, R.array.mylist_data, android.R.layout.simple_spinner_item)

        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner1.adapter = myadapter
        subjectlist.setAdapter(autoAdapter)

        //spinner에 이벤트 연결
        spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                result.text = (view as TextView).text
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                result.text = "선택된 음식이 없습니다."
            }


        }        }
}