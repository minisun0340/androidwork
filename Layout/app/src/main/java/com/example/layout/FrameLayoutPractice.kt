package com.example.layout

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_frame_layout_practice.*

class FrameLayoutPractice : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame_layout_practice)
        btn01.setOnClickListener(this)
        btn02.setOnClickListener(this)
        btn03.setOnClickListener(this)
        registerok.setOnClickListener {
            myinfo.setText("Name: ${namecheck.text}, \n Id: ${idcheck.text}, \n Password: ${passcheck.text}")
            namecheck.setText("")
            idcheck.setText("")
            passcheck.setText("")
            var nokeyboard = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            nokeyboard.hideSoftInputFromWindow(passcheck.windowToken, 0)
            passcheck.clearFocus()
        }
        passcheck.setOnEditorActionListener { v, actionId, event ->
            when (actionId) {EditorInfo.IME_ACTION_DONE->{
                Toast.makeText(applicationContext, "Done", Toast.LENGTH_SHORT).show()
                false}
                else
                -> {false}
            }
        }
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn01){
            myframe01.visibility = View.VISIBLE
            myframe02.visibility = View.INVISIBLE
            myframe03.visibility = View.INVISIBLE
        }
        else if(v?.id == R.id.btn02){
            myframe01.visibility = View.INVISIBLE
            myframe02.visibility = View.VISIBLE
            myframe03.visibility = View.INVISIBLE
        }
        else if(v?.id == R.id.btn03){
            myframe01.visibility = View.INVISIBLE
            myframe02.visibility = View.INVISIBLE
            myframe03.visibility = View.VISIBLE
        }
    }
}