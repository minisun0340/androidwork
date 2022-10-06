package com.example.fragment.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragment.R

//프레그먼트의 lifecycle
class FirstFragment: Fragment() {
    //프레그먼트가 액티비티에 attach될 때 호출
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("lifecycle", "fragment===========================onAttach")
    }
    //프레그먼트가 생성될 때 호출
    //초기화작업 - View에 대한 초기화는 하지 않는다.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("lifecycle", "fragment===========================onCreate")
    }
    //프레그먼트뷰가 만들어질 때 호출되는 메소드
    //액티비티에 프레그먼트의 뷰들이 배치될 때 호출되는 메소드 - 프레그먼트에 보여줄 view를 그리기 위해서 호출하는 메소드
    // => 프레그먼트로 보여줄 뷰를 직접 만들고 리턴한다.
    //LayoutInflater를 이용해서 직접 뷰를 만든다.
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d("lifecycle", "fragment===========================onCreateView")
        //res -> 프레그먼트에 보여줄 뷰 리소스(layout파일 리소스명)
        //ViewGroup -> 프레그먼트가 추가될 뷰의 그룹
        //attachToRoot -> false선택, 만약 true로 선택하면 root의 하위 view로 자동추가
        val view =  inflater.inflate(R.layout.fragment_first2, container, false)
        return view
    }
    //프레그먼트 안의 뷰들이 모두 생성되면 호출
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("lifecycle", "fragment===========================onViewCreated")
    }
    //프레그먼트가 완전히 생성되면 호출
    //onViewCreated까지는 보여지는 것을 만드는 과정, onActivityCreated에서는 통제가 가능한 상태
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("lifecycle", "fragment===========================onActivityCreated")
    }
    //사용자가 프레그먼트를 볼 수 있는 시점 - 화면에 표시되기 시작할 때 호출
    //프레그먼트가 가동될 때
    override fun onStart() {
        super.onStart()
        Log.d("lifecycle", "fragment===========================onStart")
    }
    //상호작용이 가능한 상태
    override fun onResume() {
        super.onResume()
        Log.d("lifecycle", "fragment===========================onResume")
    }
    //프레그먼트가 일시정지될 때, 프레그먼트를 다른 액티비티가 가리기 시작할 때 호출
    override fun onPause() {
        super.onPause()
        Log.d("lifecycle", "fragment===========================onPause")
    }
    //프레그먼트가 화면에서 사라져서 보이지 않을 때
    override fun onStop() {
        super.onStop()
        Log.d("lifecycle", "fragment===========================onStop")
    }
    //프레그먼트에서 뷰를 지우기 - 프레그먼트가 제거될 때
    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("lifecycle", "fragment===========================onDestroyView")
    }
    //모두 지워지고 호출
    override fun onDestroy() {
        super.onDestroy()
        Log.d("lifecycle", "fragment===========================onDestroy")
    }
    //액티비티에서 프레그먼트가 교체될 때 - 프레그먼트와 액티비티의 연결이 완전히 끊어질 때 발생
    override fun onDetach() {
        super.onDetach()
        Log.d("lifecycle", "fragment===========================onDetach")
    }
}
