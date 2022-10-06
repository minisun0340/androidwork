package com.example.fragment.exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragment.R
import kotlinx.android.synthetic.main.activity_support_lib.*

class support_lib : AppCompatActivity() {
    var firstView = firstview()
    var secondView = secondview()
    var thirdView = thirdview()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_support_lib)

        //액티비티가 실행될 때 2번째 프레그먼트가 실행되도록 제어
       changeFragment("sec")

        mybtn1.setOnClickListener{
            changeFragment("first")
        }
        mybtn2.setOnClickListener{
            changeFragment("sec")
        }
        mybtn3.setOnClickListener{
            changeFragment("trd")
        }
    }
    fun changeFragment(name:String?){
        //1. FragmentManager는 프레그먼트를 관리하는 객체
        val fragmentManager = supportFragmentManager
        //2. FragmentTransaction은 프레그먼트를 교체할 수 있거나 실행될 수 있도록 기능을 제공하는 객체
        //=>FragmentManager를 통해서 얻을 수 있다.
        val transaction = fragmentManager.beginTransaction()
        when (name){
            "first"->{
                //replace는 매개변수에 정의한 프레그먼트로 특정영역을 교체하는 작업
                transaction.replace(R.id.mycontainer, firstView)
                transaction.addToBackStack("first")
            }
            "sec"->{
                transaction.replace(R.id.mycontainer, secondView)
                transaction.addToBackStack("sec")
            }
            "trd"->{
                transaction.replace(R.id.mycontainer, thirdView)
                transaction.addToBackStack("trd")
            }
        }
        transaction.commit()
    }
}