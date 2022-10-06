package com.example.intent.upgradeversion

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intent.R
import kotlinx.android.synthetic.main.second2.*

class LauncherSecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second2)
        val intent = intent
        val data = intent.getStringExtra("data")
        val code = intent.getStringExtra("code")
        btnClose1.setOnClickListener{
            secondTxt.text = data
            intent.putExtra("second", "두번째 액티비티에서 실행완료")
            //ReturnDataSecondActivity를 호출한 ReturnDataFirstActivity로 되돌아 갈 때 값을 공유하기 위해서 intent객체를
            //다시 넘긴다. - setResult메소드를 이용해서 처리하기
            //Activity.RESULT_OK는 정상완료라는 의미를 담은 액티비티의 상수
            when (code){
                "call2"->{
                    intent.putExtra("second", "첫번째 액티비티의 두번째 버튼 : $code - $data")
                }
                "call3"->{
                    intent.putExtra("second", "첫번째 액티비티의 세번째 버튼 : $code - $data")
                }
            }

            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}