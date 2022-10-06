package com.example.intent.upgradeversion

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.intent.R
import kotlinx.android.synthetic.main.first2.*
//상수정의
const val FIRST_BUTTON = 10
const val SECOND_BUTTON = 20

class LauncherFirstActivity : AppCompatActivity(), View.OnClickListener {
    //lateinit은 객체를 정의하면서 초기화하지 않고 뒤에서 초기화할 때 사용하는 키워드, var로 선언된 경우에만 가능
    //1. ActivityResultLauncher객체를 정의
    private lateinit var resultLauncher1:ActivityResultLauncher<Intent>
    private lateinit var resultLauncher2:ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first2)
        call1.setOnClickListener(this)
        call2.setOnClickListener(this)
        call3.setOnClickListener(this)
        btnExit.setOnClickListener(this)

        //인텐트에 명시한 액티비티를 실행하고 되돌아오는 경우 자동으로 호출된다.
        resultLauncher1 = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
            //result매개변수로 - onActivityResult메소드의 매개변수로 전달되던 모든 값들을 가지고 있다.
            if (result.resultCode == Activity.RESULT_OK){
                intent_info.text = result.data?.getStringExtra("second")
            }

        }
        resultLauncher2 = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
            //result매개변수로 - onActivityResult메소드의 매개변수로 전달되던 모든 값들을 가지고 있다.
            if (result.resultCode == Activity.RESULT_OK){
                Toast.makeText(this,result.data?.getStringExtra("second"), Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnExit -> finish()
            R.id.call1 -> {
                val intent = Intent(this, LauncherSecondActivity::class.java).apply {
                    putExtra("info", "첫번째 액티비티가 넘기는 메시지")
                }
                startActivity(intent) //실행되는 액티비티가 넘겨주는 데이터를 가지고 올 수 없다.
                                      //액티비티를 실행할 목적
            }
            R.id.call2 -> {
                val intent = Intent(this, LauncherSecondActivity::class.java).apply{
                    putExtra("code", "call2")
                    putExtra("data", "첫번째 액티비티가 넘기는 메시지-call2")
                }
                //두번째 액티비티를 실행하고 다시 되돌아올때 값을 가지고 오는 경우 - startActivityForResult
                //인텐트객체와 함께 request_code를 넘긴다.(request_code는 사용자가 정의
                //                -----------
                //                 이 액티비티 안에서 어떤 위젯이 요청한 것인지 구분하기 위한 코드
                resultLauncher1.launch(intent)
            }
            R.id.call3 -> {
                val intent = Intent(this, LauncherSecondActivity::class.java).apply{
                    putExtra("code", "call3")
                    putExtra("data", "첫번째 액티비티가 넘기는 메시지-call3")
                }
                //두번째 액티비티를 실행하고 다시 되돌아올때 값을 가지고 오는 경우 - startActivityForResult
                //인텐트객체와 함께 request_code를 넘긴다.(request_code는 사용자가 정의
                //                -----------
                //                 이 액티비티 안에서 어떤 위젯이 요청한 것인지 구분하기 위한 코드
                resultLauncher2.launch(intent)
            }
        }
    }
    //SECOND_BUTTON -> Toast.makeText(this, data?.getStringExtra("second"), Toast.LENGTH_SHORT).show()
}