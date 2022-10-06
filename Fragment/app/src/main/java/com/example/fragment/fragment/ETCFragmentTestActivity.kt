package com.example.fragment.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.fragment.R
import com.example.fragment.fragment.UserListFragment



class ETCFragmentTestActivity : AppCompatActivity() {
    var view1: UserListFragment? =null
    //var view2: MapFragment? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.etcfragment_test)
        view1 = UserListFragment()
        //view2 = MapFragment()
    }
    fun btn_click(view: View){
        setFragment(view.tag.toString())

    }
    fun setFragment(tag:String){
        var exam_manager = supportFragmentManager
        var transaction = exam_manager.beginTransaction()
        when(tag){
            "list" -> transaction.replace(R.id.container_etc,view1!!)
          //  "map" -> transaction.replace(R.id.container_etc,view2!!)
        }
        transaction.commit()

    }
}