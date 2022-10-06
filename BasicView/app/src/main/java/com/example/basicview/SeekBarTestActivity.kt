package com.example.basicview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_seek_bar_test.*

class SeekBarTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seek_bar_test)
        var listener = object: SeekBar.OnSeekBarChangeListener{
            //seekbar의 값이 변경되었을 때
            //fromUser -> 사용자에 의해서 설정이 된 것인지 코드로 설정된 것인지 구분
            //             사용자가 설정하면 true, 코드로 설정하면 false
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                when (seekBar?.id){
                    R.id.seekBar -> {
                        txtinfo1.text = "seekbar1의 값: $progress"
                    }
                    R.id.seekBar2 -> {
                        txtinfo2.text = "seekbar2의 값: $progress"
                    }
                }
                if (fromUser){
                    Toast.makeText(applicationContext, "사용자가 설정함", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(applicationContext, "코드로 설정함", Toast.LENGTH_SHORT).show()
                }

            }
            //사용자가 터치했을 때
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                when (seekBar?.id){
                    R.id.seekBar -> {
                        txtinfo1.text = "seekbar1터치 시작"
                    }
                    R.id.seekBar2 -> {
                        txtinfo2.text = "seekbar2터치 시작"
                    }
                }
            }
            //사용자가 터치를 끝냈을 때
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                when (seekBar?.id){
                    R.id.seekBar -> {
                        txtinfo1.text = "seekbar1터치 종료"
                    }
                    R.id.seekBar2 -> {
                        txtinfo2.text = "seekbar2터치 종료"
                   }
                }
            }

        }
        seekBar.setOnSeekBarChangeListener(listener)
        seekBar2.setOnSeekBarChangeListener(listener)

        var btnlistener = View.OnClickListener { v ->
            when (v?.id){
                R.id.btnseek1 -> {
                    seekBar.incrementProgressBy(1)
                    seekBar2.incrementProgressBy(3)
                }
                R.id.btnseek2 -> {
                    seekBar.incrementProgressBy(-1)
                    seekBar2.incrementProgressBy(-3)
                }
                R.id.btnseek3 -> {
                    seekBar.progress = 5
                    seekBar2.progress = 5
                }
                R.id.btnseek4 -> {
                    txtinfo1.text = seekBar.progress.toString()
                    txtinfo2.text = seekBar2.progress.toString()
                }
            }
        }
        btnseek1.setOnClickListener(btnlistener)
        btnseek2.setOnClickListener(btnlistener)
        btnseek3.setOnClickListener(btnlistener)
        btnseek4.setOnClickListener(btnlistener)
    }
}