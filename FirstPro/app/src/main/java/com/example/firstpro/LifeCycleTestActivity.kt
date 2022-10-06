package com.example.firstpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast

// Lifecycle
/*
* 액티비티 실행
* onCreate -> onStart -> onResume
*
* 일시정지(액티비티 화면이 실행 중이 아닌 경우 - 현재 액티비티 위에 다른 액티비티가 있는 경우
* onPause -> onStop
*
* 일시정지 해제(현재 작업 중인 액티비티가 화면 위에 있는 경우 - foreground로 이동)
* onRestart -> onStart -> onResume
*
* 앱 종료
* onPause -> onStop -> onDestroy
*/
class LifeCycleTestActivity : AppCompatActivity() {
    //Activity가 생성될 때 자동으로 호출 -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 레이아웃리소를 해석하고 실행해서 화면에 배치하라는 의미
        setContentView(R.layout.activity_life_cycle_test)
        Log.d("mytest" ,"onCreate()호출..")
    }
    //onCreate 다음으로 호출되는 메소드 -2
    //액티비티가 활성화될 때 다시 호출 - UI관련 코드를 초기화
    override fun onStart() {
        super.onStart()
        Log.d("mytest" ,"onStart()호출..")
    }
    //onStart 다음으로 호출되는 메소드 -3
    //리소스에 대한 초기화 작업 시작, 액티비티 활성화된 상태에서 실행하는 모든 기능을 초기화하고 활성화
    override fun onResume() {
        super.onResume()
        Log.d("mytest" ,"onResume()호출..")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("mytest" ,"onRestart()호출..")
    }
    // 일시정지 상태로 바뀔 때 호출되는 메소드
    // Activity가 비활성화(맨 앞에 있지 않는 경우)될 때 제일 먼저 호출되는 메소드
    // - 배터리 수명에 영향을 줄 수 있는 실행 흐름을 중지하거나 리소스의 해제 등을 해야한다.
    // 필요없는 기능 중지
    override fun onPause() {
        super.onPause()
        Log.d("mytest" ,"onPause()호출..")
    }
    //앱이 실행되지 않는 동안 사용하지 않는 리소스를 해제
    //작업이 완료된 시점에 데이터베이스에 저장하기
    override fun onStop() {
        super.onStop()
        Log.d("mytest" ,"onStop()호출..")
    }
    //활동이 중지되는 경우(앱이 중지되는 경우) - 해제되지 않은 리소스를 해제
    override fun onDestroy() {
        super.onDestroy()
        Log.d("mytest" ,"onDestroy()호출..")
    }

    //버튼을 클릭했을 때 실행할 메소드를 정의
    //메소드의 매개변수에 Button의 상위 클래스인 View타입의 매개변수를 반드시 정의해야 한다.

    //length_long은 팝업 뜨는 시간 길게
    fun btnClick(view:View){
        Log.d("mytest", "버튼이 눌려졌습니다.")
        Toast.makeText(this, "버튼이 눌려졌습니다.", Toast.LENGTH_LONG).show()
    }

}