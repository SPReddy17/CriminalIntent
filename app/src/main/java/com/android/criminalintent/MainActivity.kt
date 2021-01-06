package com.android.criminalintent

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.criminalintent.fragments.CrimeFragment
import com.android.criminalintent.fragments.CrimeListFragment

class MainActivity : AppCompatActivity() {

    private  val TAG = "MainActivity"

    private lateinit var appTitle : TextView

    private lateinit var progressBar : ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        appTitle = findViewById(R.id.app_title) as TextView

        progressBar = findViewById(R.id.progress_bar)

        appTitle.setOnClickListener{ view ->

            // hide the text in main activity layout..

            appTitle.visibility = View.GONE

            progressBar.visibility = View.VISIBLE

            Handler().postDelayed(Runnable { showFragment()}, 1500)


        }

    }



    private fun showFragment(){

        // to display the crime fragment
        val currentFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container)

        if(currentFragment == null){
            val fragment  = CrimeListFragment.newInstance()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container,fragment)
                .commit()
        }
        progressBar.visibility =View.GONE

    }



}