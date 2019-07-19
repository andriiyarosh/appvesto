package com.example.appvesto.view.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.appvesto.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var flutterFragment: Fragment = FlutterFragment()
    private var firebaseFragment: Fragment = FirebaseFragment()
    private var appleFragment: Fragment = AppleFragment()
    private var fragmentManager: FragmentManager = supportFragmentManager
    private var activeFragment = flutterFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initListener()
        initFragments()

    }

    private fun initListener() {

        bottom_navigation_view.setOnNavigationItemSelectedListener { item ->

            when (item.itemId) {
                R.id.nav_flutter -> {
                    fragmentManager.beginTransaction().hide(activeFragment).show(flutterFragment).commit()
                    activeFragment = flutterFragment
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.nav_firebase -> {
                    fragmentManager.beginTransaction().hide(activeFragment).show(firebaseFragment).commit()
                    activeFragment = firebaseFragment
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.nav_apple -> {
                    fragmentManager.beginTransaction().hide(activeFragment).show(appleFragment).commit()
                    activeFragment = appleFragment
                    return@setOnNavigationItemSelectedListener true
                }
                else -> {
                    return@setOnNavigationItemSelectedListener false
                }
            }

        }

    }

    private fun initFragments() {

        fragmentManager.beginTransaction().add(R.id.navigation_container, flutterFragment, "1").hide(flutterFragment).commit()
        fragmentManager.beginTransaction().add(R.id.navigation_container, firebaseFragment, "2").hide(firebaseFragment).commit()
        fragmentManager.beginTransaction().add(R.id.navigation_container, appleFragment, "3").hide(appleFragment).commit()
        bottom_navigation_view.selectedItemId = R.id.nav_flutter

    }

}
