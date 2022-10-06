package com.example.fragment.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentStateManagerControl
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.fragment.R
import com.example.fragment.fragment.LoginFragment
import com.example.fragment.fragment.MyPageFragment
import com.example.fragment.fragment.RegisterFragment
import kotlinx.android.synthetic.main.activity_view_pager2_test.*

//ViewPager2를 이용할 때 FragmentActivity를 상속받아 작업하기
class ViewPager2TestActivity : FragmentActivity() {
    var view1 = RegisterFragment()
    var view2 = LoginFragment()
    var view3 = MyPageFragment()
    val fragmentlist = ArrayList<Fragment>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager2_test)
        // 1. ViewPage2에 연결될 프레그먼트 준비
        fragmentlist.add(view1)
        fragmentlist.add(view2)
        fragmentlist.add(view3)

        //ViewPager2도 어댑터가 있어야 한다 -FragmentStateAdapter
        //FragmentStateAdapter가 커스트마이징될 때 FragmentActivity를 요구하기 때문에 액티비티는 FragmentActivity하위로 작업
        val my_viewpager2_adapter = object : FragmentStateAdapter(this){

            //viewpager2를 통해 보여줄 프레그먼트 갯수
            override fun getItemCount(): Int {
                return fragmentlist.size
            }

            override fun createFragment(position: Int): Fragment {
                return fragmentlist[position]
            }

        }
        // 3. 뷰페이저2에 어댑터연결
        pager2.adapter = my_viewpager2_adapter
    }
}