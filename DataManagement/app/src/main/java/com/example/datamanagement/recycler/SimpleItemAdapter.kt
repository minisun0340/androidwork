package com.example.datamanagement.recycler

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.simple_item.view.*

/*
*RecyclerView에서 사용하는 Adapter를 커스트마이징
* 1. RecyclerView.Adapter를 상속받도록 처리
* 2. Adapter안에 ViewHolder객체를 정의
*    => ViewHolder객체는 row를 구성하는 웨젯에 데이터를 연결하는 작업을 수행하고 그 객체를 유지하면서
*       가지고 있을 객체
*    => ViewHoled객체는 Inner Class로 정의
*    => RecyclerView.ViewHolder의 하위로 작성
*    => RecyclerViw.Adapter를 상속받을 때 ViewHolder에 대한 정보를 전달해야 한다.
*/
class SimpleItemAdapter(var context: Context, var itemlayout:Int, var datalist:ArrayList<SimpleItem>)
    : RecyclerView.Adapter<SimpleItemAdapter.MyViewHolder>(){


    /*
    * xml로 부터 한 뷰(row에 대한 뷰)를 만들어서 viewHolder에 셋팅한 후 리턴
    * */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        //한 row로 사용할 view객체를 생성
        val itemView = LayoutInflater.from(context).inflate(itemlayout, null)
        //row에 대한 객체를 이용해서 ViewHolder객체 생성
        val myViewHolder = MyViewHolder(itemView)
        //ViewHolder객체를 리턴
        Log.d("test", "onCreateViewHolder")
        return myViewHolder
    }
    //ViewHolder객체에서 위젯을 꺼내서 데이터와 연결하는 작업을 수행
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var myTextView = holder.textview
        myTextView.text = datalist.get(position).title
        Log.d("test", "onBindViewHolder")
        myTextView.setOnClickListener{
            Toast.makeText(context, "데이터 연결 완료", Toast.LENGTH_SHORT).show()
        }
    }
    //RecyclerView에 출력할 데이터 갯수를 리턴
    override fun getItemCount(): Int {
        return datalist.size
    }
    //itemView는 전체 row를 표현해 놓은 View를 의미
    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        //row내부에서 처리되어야하는 일을 구현
        val textview = itemView.itemview_info
    }


}