package com.example.basicview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.CompoundButton
import kotlinx.android.synthetic.main.check_box_exam.*

class CheckBoxExam : AppCompatActivity() {
    var checkarray = arrayOfNulls<CheckBox>(4)
    var myarr = arrayOf(2000, 1000, 2000, 500)
    var price = 7000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.check_box_exam)
        //체크박스배열에 메모리에 있는 체크박스 가져와서 저장하기
        checkarray[0] = mycheck01
        checkarray[1] = mycheck02
        checkarray[2] = mycheck03
        checkarray[3] = mycheck04
        //리스너객체 만들기
        val listener = CheckBoxExamActivity()
        //모든 체크박스에 리스너 연결하기
        for (i in checkarray.indices){
            checkarray[i]?.setOnCheckedChangeListener(listener)
        }
        //실행되면 기본 메뉴의 선택가격이 출력되기
        mytotalprice.text = "총금액: $price"
    }
    internal inner class CheckBoxExamActivity : CompoundButton.OnCheckedChangeListener{
        override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
            //어떤 체크박스를 선택했는지 tag의 셋팅된 값을 가져와서 만들기
            var index = buttonView?.tag.toString().toInt() -1
            //체크박스가 선택되면 기본가격에 옵션가격 더하기
            if(isChecked){
                //체크박스가 선택된 상태
                price += myarr[index]
            }else{
                //체크박스가 해제된 상태 - 기본가격에 옵션가격빼기
                price -= myarr[index]
            }
            //체크박스가 선택 또는 해제될 때마다 텍스트뷰에 가격계산해서 출력하기
            mytotalprice.text = "총금액: $price"
        }

    }
}
