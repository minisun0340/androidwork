package com.example.selectview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter
import kotlinx.android.synthetic.main.listview_test.*

class SimpleAdapterTestActivity : AppCompatActivity() {
    //List에 저장된 Map
    var listdata = ArrayList<HashMap<String, String>>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listview_test)

        //1. 데이터 준비
        var item = HashMap<String,String>()
        item["name"] = "김서연"
        item["telNum"] = "010-1111-2222"
        listdata.add(item)

        item = HashMap<String,String>()
        item["name"] = "봉미선"
        item["telNum"] = "010-0000-2222"
        listdata.add(item)

        item = HashMap<String,String>()
        item["name"] = "신짱구"
        item["telNum"] = "010-0000-2222"
        listdata.add(item)

        item = HashMap<String,String>()
        item["name"] = "신짱아"
        item["telNum"] = "010-1111-4444"
        listdata.add(item)

        //2.adapter만들기
        val myadapter = SimpleAdapter(this, listdata,
                                            android.R.layout.simple_list_item_2 ,arrayOf("name", "telNum"),
                                            intArrayOf(android.R.id.text1, android.R.id.text2))
        listview1.adapter = myadapter
    }
}