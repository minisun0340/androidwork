package com.example.fragment.tab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.fragment.R
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_tab_test2.*

class TabTest2 : FragmentActivity() {
    var fragmentlist = ArrayList<Fragment>()

    //탭 문자열을 담을 ArrayList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_test2)
        //동일한 프레그먼트를 만들어서 작업하는 거라면 만들어질 프레그먼트를 담을 프레그먼트객체를 준비하고 작업
        for(i in 0..9){
            val sub = SubFragment("$i 번째 프레그먼트")
            fragmentlist.add(sub)
        }
        val myadapter= object:FragmentStateAdapter(this){
            override fun getItemCount(): Int {
                return fragmentlist.size
            }

            override fun createFragment(position: Int): Fragment {
                return fragmentlist[position]
            }

        }
        tab_viewpager2.adapter = myadapter

        //탭과 뷰페이저를 연결하기 - 연결할 탭과 뷰페이저를 이용해서 TabLayoutMediator객체
        TabLayoutMediator(tabs2, tab_viewpager2){tab, position ->
            tab.text = "탭 $position" //탭의 이름 설정

        }.attach()
    }
}