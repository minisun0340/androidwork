package com.example.fragment.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.fragment.R
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.login.*

class LoginFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.login, container, false)
        return view

    }

}