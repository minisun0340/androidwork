package com.example.selectview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.listview_test.*

class ResourceDataListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listview_test)
        //R은 내꺼 //안드로이드꺼는 android.R
        val adapter = ArrayAdapter.createFromResource(this,R.array.mylist_data, android.R.layout.simple_list_item_1)
        listview1.adapter = adapter
        listview1.onItemClickListener = mylistener

    }
    var mylistener = AdapterView.OnItemClickListener { parent, view, position, id ->
        listtext.text = "선택한 항목: ${(view as TextView).text}"
    }
}