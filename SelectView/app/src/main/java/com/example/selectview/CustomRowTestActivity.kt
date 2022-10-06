package com.example.selectview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter
import kotlinx.android.synthetic.main.listview_test.*

class CustomRowTestActivity : AppCompatActivity() {
    //arrayOf와 intArrayOf모두 배열을 만드는 함수
    //intArrayOf는 int형 배열을 만들겠다는 의미, arrayOf는 모든 타입의 배열을 만들 때 사용
    var imageRes = intArrayOf(R.drawable.kimdong, R.drawable.ansoccer, R.drawable.jjangkim, R.drawable.leemin, R.drawable.kbr)
    var data1 = arrayOf("사람1", "사람2", "사람3", "사람4", "사람5")
    var data2 = arrayOf("한소희이쁘다", "한소희짱", "존예", "미소", "예쁜사람최고")
    var imageRes2 = intArrayOf(R.drawable.han1, R.drawable.han2, R.drawable.han3, R.drawable.han4,R.drawable.han5)
    var listdata = ArrayList<HashMap<String, Any>>() //Any는 코틀린의 최상위
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listview_test)
        //SimpleAdapter에 셋팅할 데이터를 설정하기
        for (i in imageRes.indices){
            var map = HashMap<String, Any>()
            map["img"] = imageRes[i]
            map["data1"] = data1[i]
            map["data2"] = data2[i]
            map["img2"] = imageRes2[i]
            listdata.add(map)
        }
        val keyarr = arrayOf("img", "data1", "data2", "img2")
        val layoutidarr = intArrayOf(R.id.myimg, R.id.txtcust1, R.id.txtcust2, R.id.myimg2)
        val myadapter = SimpleAdapter(this, listdata, R.layout.custrow3, keyarr, layoutidarr)

        listview1.adapter = myadapter
    }
}