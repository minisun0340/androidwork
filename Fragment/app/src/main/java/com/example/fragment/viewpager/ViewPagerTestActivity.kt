package com.example.fragment.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.fragment.R
import kotlinx.android.synthetic.main.activity_view_pager_test.*

/*
* 화면전환을 위해서 ViewPager를 사용하는 경우(ListView와 동일)
* 1. ViewPager에 담을 데이터를 정의 (데이터 : ViewPager에 담을 View객체(View, Fragment)
* 2. Adapter커스트마이징 - ViewPager에 보여주는 방식이나 ViewPager에 담을 뷰들이 달라지고 각각 동작할 수 있도록 해야 하므로
*                         Adapter를 상속받아서 작업
*    => PagerAdapter
* 3. ViewPager에 Adapter연결하기
*/
class ViewPagerTestActivity : AppCompatActivity() {
    val viewlist = ArrayList<View>() //ViewPager에 담을 뷰들을 보관할 자료구조
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager_test)
        //1. ViewPager에 담을 View객체를 생성
        //   => root를 레이아웃을 지정하면 그 레이아웃에 가서 추가된다.
        val view1 = layoutInflater.inflate(R.layout.register, null)
        val view2 = layoutInflater.inflate(R.layout.login, null)
        val view3 = layoutInflater.inflate(R.layout.mypage, null)
        viewlist.add(view1)
        viewlist.add(view2)
        viewlist.add(view3)
        //2. Adapter를 커스트마이징(Adapter를 상속받아서 구현)
        val my_viewpager_adapter = object: PagerAdapter(){
            //ViewPager를 통해 보여줄 뷰의 갯수를 리턴
            override fun getCount(): Int {
                return viewlist.size
            }
            //ViewPager에 보여줄 뷰를 등록 - 뷰페이저에서 뷰가 전환될 때마다 보여줄 뷰를 만들어서 리턴
            override fun instantiateItem(container: ViewGroup, position: Int): Any {
                pager1.addView(viewlist[position])
                return  viewlist[position]
            }
            //instantiateItem에서 만든 뷰를 실제 사용할 것인지 의무를 결정함 - 매개변수로 전달된 뷰들끼리 비교
            //첫번째 매개변수로 전다로딘 뷰객체와 instantiateItem메소드를 창출한 한 후 리턴되는 객체를 비교
            //'object' =코틀린에서 키워드를 식별자로 사용할 때 ''로 묶어준다
            override fun isViewFromObject(view: View, obj: Any): Boolean {
                return view == obj
            }
            //ViewPager에서 View가 사라질 때 뷰를 제거하는 작업을 수행
            override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
                pager1.removeView(obj as View)
            }

        }//end Adapter
         //3. ViewPager에 어댑터 연결
        pager1.adapter = my_viewpager_adapter

        // ViewPage에 이벤트 연결하기
        val listener1 = object: ViewPager.OnPageChangeListener{
            //페이지스크롤이 끝나는 경우 호출되는 메소드
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                pager_text.text = "${position}번째 뷰가 선택됨"
            }
            // 페이지 선택했을 때 호출되는 메소드
            override fun onPageSelected(position: Int) {

            }
            // 페이지 상태가 변경되었을 대 호출되는 메소드
            override fun onPageScrollStateChanged(state: Int) {

            }


        }
        pager1.addOnPageChangeListener(listener1)
    }
}