package com.example.basicview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.check.*
import org.w3c.dom.Text

//리스너를 inner클래스(클래스 안에 클래스를 정의해서 사용할 수 있다.)로 정의하고 사용하기
class CheckBoxActivity : AppCompatActivity() {
    //체크박스를 저장할 수 있는 배열을 만들고 작업
    //3개의 요소를 갖고 있는 체크박스가 저장될 배열을 생성
    var checkArr = arrayOfNulls<CheckBox>(3)
    var myarr = arrayOf(2000, 1000, 2000) //배열 생성하기
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.check)
        //뷰의 주소값을 배열의 요소에 저장
        checkArr[0] = check1
        checkArr[1] = check2
        checkArr[2] = check3
        var size = checkArr.size
        //for문을 이용하다 보면 인덱스값(컬렉션에서 데이터의 위치를 나타내는 값)을 이용해서 작업하고 싶은 경우
        //0,1, .. indices속성을 이용해서 작업
        val listener = CheckBoxListener()
        for(i in checkArr.indices){
            checkArr[i]?.setOnCheckedChangeListener(listener)
        }

        /*checkArr[0]?.setOnCheckedChangeListener(listener)
        checkArr[1]?.setOnCheckedChangeListener(listener)
        checkArr[2]?.setOnCheckedChangeListener(listener)*/
        //setXXXListener메소드는 위젯과 이벤트를 연결해주는 메소드 - 위젯에 리스너가 뭔지 등록해주는 메소드
        switch1.setOnCheckedChangeListener(listener)
        btnchk1.setOnClickListener(listener)
        btnchk2.setOnClickListener(listener)
        btnchk3.setOnClickListener(listener)
        btnchk4.setOnClickListener(listener)
    }
    //액티비티에 있는 모든 위젯에 연결할 기능을 구현하는 리스너를 이너클래스로 구현
    internal inner class CheckBoxListener : CompoundButton.OnCheckedChangeListener, View.OnClickListener{
        //체크박스의 상태를 TextView에 출력하기
        //private은 외부에서 접근할 수 없는 메소드, 선언된 클래스 내부에서만 사용할 수 있는 메소드에는 private를 추가해서 작업
        private fun checkStatus():Unit{
            checkTxt?.text = ""
            for (i in checkArr.indices){
                //isChecked라는 속성은 체크박스가 선택되어 있으면 true를 리턴
                if (checkArr[i]?.isChecked == true){
                    val tag = checkArr[i]?.tag as String //태그값을 String으로 변경, 객체 타입을 바꾸는 것 -타입을 변경하는 경우는 오직 상속관계인 경우에만 가능- 부모타입의 객체를 자식타입의 객체로 바꾸고 싶을 때
                                                        //String객체가 반환될 때만 Object로 반환됨. 그래서 String으로 캐스팅 가능
                    //val tag = checkArr[i]?.tag.toString() //객체값을 스트링으로 바꾸는것
                    checkTxt?.append("$tag 번 체크박스의 체크가 설정됨")
                }
            }
        }
        //모든 체크박스의 상태를 체크 상태로 설정
        private fun setCheckVal(chkVal:Boolean){
            for (i in checkArr.indices){
                checkArr[i]?.isChecked = chkVal
            }
            Log.d("test", "setCheckVal")
        }
        //체크박스가 선택되어 있으면 해제, 해제되어 있으면 선택
        private fun toggle(){
            for (i in checkArr.indices){
                checkArr[i]?.toggle()
            }
            Log.d("test", "toggle")
        }
        //체크박스가 선택되면 Toast로 몇 번째 체크박스가 선택되었는지 출력, TextView에 출력
        //index는 체크박스의 태그값, checkedState는 OnCheckedChanged에서 발생되는 체크의 상태값이 저장된 isChecked값을 가져와 작업
        fun display(index:Int, txtView:TextView?, checkState:Boolean){
            if(checkState){ //Boolean인 경우 비교연산자를 이용해서 값을 비교하는 부분을 생략할 수 있다.
                txtView?.text = "$index 번째 체크박스가 선택 -${myarr[index-1]}"
            }else{
                txtView?.text = "$index 번째 체크박스가 해제- ${myarr[index-1]}"
            }
        }

        override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
            //CheckBox와 Swith가 동일한 이벤트를 발생시키지만 다르게 작업하고 싶은 경우
            if (buttonView is CheckBox){
                Log.d("test", "체크박스")
                display((buttonView.getTag().toString()).toInt(), checkTxt, isChecked)
            }
            else{
                if(buttonView?.id == R.id.switch1){
                    var msg = "" //string타입의 변수
                    msg = if(buttonView.isChecked){
                        "활성"
                    }else{
                        "비활성"
                    }
                    Log.d("test", msg)
                    Toast.makeText(applicationContext, msg, Toast.LENGTH_LONG).show()
                }
            }
            //Log.d("test", "checkbox:$buttonView====$isChecked")
        }

        override fun onClick(v: View?) {
            //Log.d("test", "Button")
            when(v?.id){
                R.id.btnchk1 -> setCheckVal(true)
                R.id.btnchk2 -> checkStatus()
                R.id.btnchk3 -> setCheckVal(false)
                R.id.btnchk4 -> toggle()
            }
        }

    }
}