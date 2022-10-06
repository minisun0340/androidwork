package com.example.fragment.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import com.example.fragment.R
import com.example.fragment.exam.firstview
import kotlinx.android.synthetic.main.activity_fragment_exam.*
import kotlinx.android.synthetic.main.activity_support_lib.*

class SetGetTestFragmentActivity : AppCompatActivity() {
    var firstView:RegisterFragment ?= null
    var secondView:LoginFragment ?= null
    var thirdView:MyPageFragment ?= null
    var fragmentManager:FragmentManager?=null
    var obj:RegisterFragment?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_exam)

        firstView = RegisterFragment()
        secondView = LoginFragment()
        thirdView = MyPageFragment()
        fragmentManager = supportFragmentManager
        //액티비티가 실행될 때 2번째 프레그먼트가 실행되도록 제어
       changeFragment("sec")

        //액티비티 -> 프레그먼트 데이터 가져오기
        btn_get.setOnClickListener {
            //findFragmentById -> 현재 container의 연결된 프레그먼트를 리턴(화면에 보이는 프레그먼트를 리턴)
            //                    어떤 프레그먼트가 연결되어있는지 알 수 없으므로 상위타입은 fragment를 반환
            //                    우리가 사용할 프레그먼트는 RegisterFragment이므로 캐스팅작업까지 해야 사용할 수 있다.
            obj = fragmentManager?.findFragmentById(R.id.mycontainer) as RegisterFragment?
            maindata.setText(obj?.senddata())
        }
        //액티비티 -> 프레그먼트로 데이터 보내기
        btn_set.setOnClickListener {
            //현재 화면에 표시된 프레그먼트가져오기
            obj = fragmentManager?.findFragmentById(R.id.mycontainer) as RegisterFragment?
            obj?.receivedata(senddata.text.toString())
        }
    }
    fun btn_click(view:View){
        changeFragment(view.tag.toString())
    }

    fun changeFragment(name:String?){
        //1. FragmentManager는 프레그먼트를 관리하는 객체
        //fragmentManager = supportFragmentManager
        //2. FragmentTransaction은 프레그먼트를 교체할 수 있거나 실행될 수 있도록 기능을 제공하는 객체
        //=>FragmentManager를 통해서 얻을 수 있다.
        val transaction = fragmentManager?.beginTransaction()
        when (name){
            "first"->{
                //replace는 매개변수에 정의한 프레그먼트로 특정영역을 교체하는 작업
                transaction?.replace(R.id.mycontainer, firstView!!)
                transaction?.addToBackStack("first")
            }
            "second"->{
                transaction?.replace(R.id.mycontainer, secondView!!)
                transaction?.addToBackStack("sec")
            }
            "third"->{
                transaction?.replace(R.id.mycontainer, thirdView!!)
                transaction?.addToBackStack("trd")
            }
        }
        transaction?.commit()
    }
}