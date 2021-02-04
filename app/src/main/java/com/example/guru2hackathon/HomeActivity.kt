package com.example.guru2hackathon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.time.Month
import java.time.MonthDay
import java.time.Year

class HomeActivity : AppCompatActivity() {
    lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)

        setCurrentFragment(Main())

        bottomNavigationView.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.navigation_main-> setCurrentFragment(Main())
                R.id.navigation_calendar -> setCurrentFragment(Calendar())
                R.id.navigation_friends -> setCurrentFragment(Friends())
                R.id.navigation_settings -> setCurrentFragment(Settings())
            }
            true
        }

    }
    private fun setCurrentFragment(fragment: Fragment)=
            supportFragmentManager.beginTransaction().apply{
                replace(R.id.flFragment,fragment)
                commit()
            }
}