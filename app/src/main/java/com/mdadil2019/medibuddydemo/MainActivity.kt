package com.mdadil2019.medibuddydemo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.mdadil2019.medibuddydemo.fragments.DashboardFragment
import com.mdadil2019.medibuddydemo.fragments.StartupFragment

class MainActivity : AppCompatActivity() {
    val APP_SHARED_PREF = "APP_SHARED_PREF"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(!isFirstVisit()){
            changeFragment(DashboardFragment())
        }else{
            changeFragment(StartupFragment())
        }
    }

    fun changeFragment(fragment : Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer,fragment).commit()
    }

    private fun isFirstVisit():Boolean{
        val sharedPref = getSharedPreferences(APP_SHARED_PREF, Context.MODE_PRIVATE)
        return sharedPref.getBoolean("isFirstVisit",true)
    }

}