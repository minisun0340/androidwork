package com.example.fragment.drawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.example.fragment.R
import kotlinx.android.synthetic.main.activity_drawer_test.*

class DrawerTest : AppCompatActivity() {
    var drawerLayout:DrawerLayout ?= null
    var actionBarDrawerToggle:ActionBarDrawerToggle ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer_test)
        //액션바에 출력되는 타이틀을 출력되지 않도록 정의
        supportActionBar?.setDisplayShowTitleEnabled(false)
        //drawerLayout = findViewById(R.id.root_drawer)
        //root_drawer -> DrawLayout객체
        //문자열은 화면에 출력할 문자열과 관련없이 drawer가 열린 상태, 닫힌 상태냐를 표현하기 위한 문자열
        actionBarDrawerToggle = ActionBarDrawerToggle(this, root_drawer, R.string.drawer_open, R.string.drawer_close)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        actionBarDrawerToggle?.syncState()
        main_drawer_view.setNavigationItemSelectedListener {
            item ->
            val id = item.itemId
            if (id == R.id.menu_drawer_1){
                showToast("내가 본 레시피 메뉴가 선택됨")
            }
            false
        }
    }
    //실제로 NavigationView 가 열리거나 닫히도록 하려면 onOptionsItemSelected메소드를 반드시 오버라이딩 해야 한다.
    //이 함수를 사용하는 이유는 ActionBarDrawerToggle 아이콘 클릭하는 것이 메뉴 이벤트로 처리되기 때문에
    //이벤트 로직에 벗어나도록 코드 구현
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(actionBarDrawerToggle!!.onOptionsItemSelected(item)){
            showToast("눌림")
            return false //일반 메뉴처리를 계속 하려면 false를 반환하고 사용하려면 true반환
        }
        return super.onOptionsItemSelected(item)
    }
    fun showToast(msg:String){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}