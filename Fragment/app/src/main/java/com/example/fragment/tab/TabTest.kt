package com.example.fragment.tab

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.fragment.R

import com.example.fragment.fragment.LoginFragment
import com.example.fragment.fragment.MyPageFragment
import com.example.fragment.fragment.RegisterFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_tab_test.*

class TabTest : AppCompatActivity() {
    var view1 = RegisterFragment()
    var view2 = LoginFragment()
    var view3 = MyPageFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_test)
        //텝 추가
        //tabs.setTabTextColors(Color.RED, Color.BLUE)
        tabs.addTab(tabs.newTab().setText("설정"))
        //처음 실행할 때 보여줄 프레그먼트를 지정

        supportFragmentManager.beginTransaction().replace(R.id.linear1, view1).commit()

        //탭에 이벤트 연결
        tabs.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            //탭이 선택될때 호출되는 메소드
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val position = tab?.position //탭의 순서 받아오기
                var fragment : Fragment ?= null
                when (position){
                    0 -> fragment = view1
                    1 -> fragment = view2
                    2 -> fragment = view3
                }
                //탭을 선택할 때 정의된 프레그먼트 객체가 show되도록 연결
                supportFragmentManager.beginTransaction().replace(R.id.linear1, fragment!!).commit()

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }


        })
    }
}