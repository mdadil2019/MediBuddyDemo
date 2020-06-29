package com.mdadil2019.medibuddydemo.fragments

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mdadil2019.medibuddydemo.R
import kotlinx.android.synthetic.main.fragment_startup.*

class StartupFragment : Fragment() {


    val APP_SHARED_PREF = "APP_SHARED_PREF"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_startup, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btnStart.setOnClickListener {
            setVisit()
            changeFragment(DashboardFragment())
        }
    }

    fun changeFragment(fragment : Fragment){
        fragmentManager?.beginTransaction()?.replace(R.id.fragmentContainer,fragment)?.commit()

    }

    fun setVisit(){
        val sharedPref = activity?.getSharedPreferences(APP_SHARED_PREF,MODE_PRIVATE)
        sharedPref?.edit()?.putBoolean("isFirstVisit",false)?.apply()
    }


}