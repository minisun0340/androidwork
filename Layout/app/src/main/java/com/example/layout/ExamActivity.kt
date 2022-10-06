package com.example.layout

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_exam.*

class ExamActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exam)
        myloginbtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.myloginbtn){
            Toast.makeText(this, "id:${myid.text}, password:${mypass.text}", Toast.LENGTH_SHORT).show()
            myid.setText("")
            mypass.setText("")
            var service = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            service.hideSoftInputFromWindow(mypass.windowToken, 0)
            mypass.clearFocus()
        }

    }
}