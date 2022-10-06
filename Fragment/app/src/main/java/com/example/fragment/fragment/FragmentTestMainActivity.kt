package com.example.fragment.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragment.R
import kotlinx.android.synthetic.main.fragment_main.*

class FragmentTestMainActivity : AppCompatActivity() {
    val firstFragment = FirstFragment()
    val secondFragment = SecondFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_main)
        btn_first.setOnClickListener{
            changeFragment("first")
        }
        btn_second.setOnClickListener{
            changeFragment("second")
        }
        btn_del.setOnClickListener{
            changeFragment("remove")
        }

    }
    //container라는 이름으로 만들어놓은 영역에 프레그먼트를 교체해서 보여줄 수 있도록 처리
    //1. 프레그먼트객체를 관리하는 관리자객체를 액티비티에서 받아오기
    //2. fragmentManager객체를 이용해서 프레그먼트 관리 작업을 시작하기 위해서 트랜잭션객체를 구하기
    //3. 원하는 프레그먼트로 교체
    //4. 당장 처리할 수 있도록 commit()호출
    fun changeFragment(name:String?){
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        when(name){
            "first"->{
                //replace는 매개변수에 정의한 프레그먼트로 특정영역을 교체하는 작업
                transaction.replace(R.id.container, firstFragment)
                transaction.addToBackStack("first") //backstack에서 이름을 구분하기위해
            }
            "second"->{
                transaction.replace(R.id.container, secondFragment)
                transaction.addToBackStack("second") //backstack에서 이름을 구분하기위해
            }
            "remove"->{
                transaction.remove(firstFragment)
            }
        }
        transaction.commit()
    }
}