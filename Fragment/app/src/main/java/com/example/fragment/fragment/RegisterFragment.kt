package com.example.fragment.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragment.R
import kotlinx.android.synthetic.main.activity_fragment_exam.*
import kotlinx.android.synthetic.main.register.*


class RegisterFragment : Fragment() {

    var data:String?=null
    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.register, container, false)
        return view
    }
    //View가 메모리에 할당된 후 호출되는 메소드에서 처리한다.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //프레그먼트의 각 뷰에 이벤트를 연결하기 위한 메소드
        btn_insert.setOnClickListener {
            val data = senddata()
            //프레그먼트가 붙어있는 액티비티를 받아오기
            //---------------------------
            // 부모 액티비티
            //프레그먼트에서 getActvity()하면 부모액티비티를 구할 수 있다.
            val parentview = activity as SetGetTestFragmentActivity
            parentview.fragment_data.setText(data)

            setdata_fragment.text = parentview.senddata.text
        }

    }

    //액티비티에 값을 보내고 액티비티에서 보내오는 값을 셋팅할 메소드를 준비
    //코틀린은 멤버변수를 이용해서 set/get메소드를 자동으로 구현하기 때문에 사용자정의 메소드명은 피해서 정의하기
    //1.액티비티로 데이터를 보내기 위한 메소드
    fun senddata():String{
        val data = "아이디:${edit_id.text}, 성명:${edit_name.text}, 패스워드:${edit_pass.text}"
        return data
    }
    //2.액티비티에서 보내오는 데이터를 받기 위한 메소드
    fun receivedata(data:String){
        setdata_fragment.setText(data)
    }



}