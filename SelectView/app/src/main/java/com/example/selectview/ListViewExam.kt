package com.example.selectview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.SimpleAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_list_view_exam.*

class  ListViewExam : AppCompatActivity() {
    var mydrinkdata = arrayOf<String>("소주", "맥주", "소맥", "연맥", "레드와인", "화이트와인", "콜라", "사이다", "환타")
    var mydrinkpricedata = arrayOf<String>("4000원", "4500원", "6000원", "12000원", "50000원", "49000원", "2000원", "2000원", "2000원")
    val mydrnprlist = ArrayList<HashMap<String,String>>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_exam)
        //음식선택하기 - spinner
        val myadapter = ArrayAdapter.createFromResource(this, R.array.myfoodlist, android.R.layout.simple_spinner_item)
        myadapter.setDropDownViewResource(android.R.layout.simple_selectable_list_item)
        myspinner.adapter = myadapter

        myspinner.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                selectedfood.text = (view as TextView).text
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                selectedfood.text = "음식을 선택해주세요"
            }
        }
        //음료선택하기 - 리스트
        for (i in mydrinkdata.indices){
            var map = HashMap<String, String>()
            map["name"] = mydrinkdata[i]
            map["price"] = mydrinkpricedata[i]
            mydrnprlist.add(map)
        }
        var keyarr = arrayOf("name", "price")
        val layoutidarr = intArrayOf(R.id.txtdrink, R.id.txtprice)
        val mylistadapter = SimpleAdapter(this, mydrnprlist, R.layout.custrow2, keyarr, layoutidarr)
        mydrinklist.adapter = mylistadapter
        mydrinklist.onItemClickListener = mylistlistener
    }
    var mylistlistener = AdapterView.OnItemClickListener{parent, view, position, id ->
        Log.d("test", "parent -> $parent, view -> $view, position- > $position, id -> $id ")
        selecteddrink.text = "${mydrinkdata[position]}"
    }
}