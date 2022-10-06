package com.example.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.first2.*
//상수정의
const val FIRST_BUTTON = 10
const val SECOND_BUTTON = 20

class ReturnDataFirstActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first2)
        call1.setOnClickListener(this)
        call2.setOnClickListener(this)
        call3.setOnClickListener(this)
        btnExit.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnExit -> finish()
            R.id.call1 -> {
                val intent = Intent(this, ReturnDataSecondActivity::class.java).apply {
                    putExtra("info", "첫번째 액티비티가 넘기는 메시지")
                }
                startActivity(intent) //실행되는 액티비티가 넘겨주는 데이터를 가지고 올 수 없다.
                                      //액티비티를 실행할 목적
            }
            R.id.call2 -> {
                val intent = Intent(this, ReturnDataSecondActivity::class.java).apply{
                    putExtra("code", "call2")
                    putExtra("data", "첫번째 액티비티가 넘기는 메시지-call2")
                }
                //두번째 액티비티를 실행하고 다시 되돌아올때 값을 가지고 오는 경우 - startActivityForResult
                //인텐트객체와 함께 request_code를 넘긴다.(request_code는 사용자가 정의
                //                -----------
                //                 이 액티비티 안에서 어떤 위젯이 요청한 것인지 구분하기 위한 코드
                startActivityForResult(intent, FIRST_BUTTON) //어떤 버튼에의해 실행되었는지(요청)
            }
            R.id.call3 -> {
                val intent = Intent(this, ReturnDataSecondActivity::class.java).apply{
                    putExtra("code", "call3")
                    putExtra("data", "첫번째 액티비티가 넘기는 메시지-call3")
                }
                //두번째 액티비티를 실행하고 다시 되돌아올때 값을 가지고 오는 경우 - startActivityForResult
                //인텐트객체와 함께 request_code를 넘긴다.(request_code는 사용자가 정의
                //                -----------
                //                 이 액티비티 안에서 어떤 위젯이 요청한 것인지 구분하기 위한 코드
                startActivityForResult(intent, SECOND_BUTTON) //어떤 버튼에의해 실행되었는지(요청)
            }
        }
    }
    /*
    * setResult를 호출하고 첫 번째 액티비티로 되돌아오는 경우 onActivityResult메소드를 자동으로 호출한다.
    * requestCode는 요청했던 위젯을 구분하기 위한 코드
    * resultCode는 결과코드(두 번째 액티비티에서 셋팅한 결과 코드)
    * data - Intent객체(두 번째 액티비티에서 넘긴 인텐트객체)
    */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("myintent", "값을 가지고 올까?")
        when(requestCode){
            FIRST_BUTTON -> intent_info.text = data?.getStringExtra("second")
            SECOND_BUTTON -> Toast.makeText(this, data?.getStringExtra("second"), Toast.LENGTH_SHORT).show()
        }
    }

}