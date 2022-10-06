package com.example.fragment.tab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragment.R
import kotlinx.android.synthetic.main.subfragment_view.*

class SubFragment:Fragment {
    //var title:String?=null
    lateinit var title:String //title변수를 선언하고 바로 초기화하지 않고 뒤에서 초기화하겠다는 의미
    constructor(title:String){
        this.title = title
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.subfragment_view, null)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subfragment_txt.text = title
    }
}