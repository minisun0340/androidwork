package com.example.basicview

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_edit_text_test.*

class EditTextTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_text_test)
        btngetdata.setOnClickListener {
            /*입력이 완료되면 키보드가 화면에서 없어지도록 설정, EditText의 내용이 지워지도록, 포커스가 사라지도록
            * 키보드제어는 os내부에서 제공되는 기능을 가져와서 사용해야 한다.
            * getSystemService메소드를 통해 안드로이드 운영체제의 기능을 가져다 사용할 수 있다.
            * 안드로이드가 제공하는 키보드는 하드웨어 키보드와 소프트웨어 키보드로 구분
            * 하드웨어 키보드는 스마트폰에서 물리적으로 제공하는 키보드로
            *  -우리 앱에서 창을 제어하는 것과 관련된 기능을 제공하는 것으로 InputMethodManager를 이용해서 작업*/
            txtinfo1.text = editmytext.text
            editmytext.setText("")
            //1. 안드로이드 OS내부에서 제공하는 서비스를 가져오기 - 키보드제어와 관련된 서비스
            var service = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            //2. 각각의 ServiceManager클래스에 맞는 기능을 호출해서 사용
            //windowToken 내부적으로 구분할 수 있는 값을 만들어주는것 <- 어떤 뷰에서 키보드를 발생시켰는지 값을 넘겨주기 위해서
            service.hideSoftInputFromWindow(editmytext.windowToken, 0)
            //3. 포커스 없애기
            editmytext.clearFocus()
        }
        //EditText에서 처리할 수 있는 이벤트
        //1. 사용자가 입력한 내용을 실시간으로 확인할 수 있는 이벤트 - TextWatcher
        //위의 이벤트를 처리하기 위해서 TextWatcher를 상속해서 익명의 리스너클래스를 작성
        var listener = object :TextWatcher{
            //문자열이 변경되기 전
            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
                txtinfo1.text = "before:$s"
            }
            //문자열의 변경이 완료되었을 때
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                txtinfo2.text = "TextChanged:$s"
            }
            //변경된 문자열이 화면에 표시되었을 때
            override fun afterTextChanged(s: Editable?) {
                txtinfo3.text = "after:$s"
            }

        }
        editmytext.addTextChangedListener(listener)

        //2. 키보드의 특정 키보드가 눌려졌을 때 선택 : 키보드의 Enter키가 눌려졌을 대 발생하는 이벤트
        // android:imeOptions="actionDone"  : 작업이 완료
        // android:imeOptions="actionGo"  : 이동
        // android:imeOptions="actionSearch"  : 검색
        //  => 구현해야하는 리스너에 리턴타입이 존재
        // false, true
        editmytext.setOnEditorActionListener { v, actionId, event -> //매개변수
            txtinfo1.text = "엔터키가 눌려짐"
            when (actionId) {//imeOptions에 설정한 값들이 발생
                EditorInfo.IME_ACTION_GO -> {
                    Toast.makeText(
                        applicationContext,
                        "editmytext의 Action_Go이벤트 받음",
                        Toast.LENGTH_LONG
                    ).show()
                    false
                }
                EditorInfo.IME_ACTION_DONE -> {
                    Toast.makeText(
                        applicationContext,
                        "editmytext의 Action_Done이벤트 받음",
                        Toast.LENGTH_LONG
                    ).show()
                    false
                }
                EditorInfo.IME_ACTION_NEXT -> {
                    Toast.makeText(
                        applicationContext,
                        "editmytext의 Action_Next이벤트 받음",
                        Toast.LENGTH_LONG
                    ).show()
                    false}
                else -> {
                    false
                    }
                }

            }

        }
    }



