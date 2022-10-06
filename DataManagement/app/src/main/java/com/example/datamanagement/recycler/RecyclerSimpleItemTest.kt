package com.example.datamanagement.recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.datamanagement.R
import kotlinx.android.synthetic.main.activity_recycler_simple_item_test.*

class RecyclerSimpleItemTest : AppCompatActivity() {
    var datalist = ArrayList<SimpleItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_simple_item_test)

        //1. RecyclerView에 출력할 데이터를 준비
        for (i in 0..9){
            val item = SimpleItem("simple_item $i")
            datalist.add(item)
        }
        //2. Adapter를 생성 -RecyclerView는 어댑터를 직접 만들어서 작업
        //  -> 기존 ListView의 문제는 사용자정의 row를 디자인하고 row내부의 위젯에 이벤트처리를 못함
        //  -> 데이터와 row에 대한 디자인을 주면 목록화면을 만들어내는 작업을 수행
        val adapter = SimpleItemAdapter(this, R.layout.simple_item, datalist)
        //3. Recycler에 레이아웃을 설정하기 - LinearLayout, Gridlayout을 설정
        // RecyclerView에 설정할 레이아웃객체를 생성
        // 3-1) LinearLayout객체를 생성
        /*val manager = LinearLayoutManager(this)
        manager.orientation = LinearLayoutManager.VERTICAL
        myrecycler.layoutManager = manager*/
        // 3-2) GridLayout객체를 생성
        val manager = GridLayoutManager(this, 3)
        myrecycler.layoutManager = manager

        //4. RecyclerView에 adapter연결
        myrecycler.adapter = adapter
    }
}