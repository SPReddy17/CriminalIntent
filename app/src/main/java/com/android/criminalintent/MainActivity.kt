package com.android.criminalintent

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.criminalintent.fragments.CrimeFragment
import com.android.criminalintent.fragments.CrimeListFragment
import java.util.*

class MainActivity : AppCompatActivity(),CrimeListFragment.Callbacks {

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

            Handler().postDelayed(Runnable { showFragment()}, 500)


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
                .setCustomAnimations(
                    R.anim.slide_in_right,  // enter
                    R.anim.fade_out,  // exit
                    R.anim.fade_in,   // popEnter
                    R.anim.slide_out_right  // popExit

                )
                .add(R.id.fragment_container,fragment)
                .commit()
        }
        progressBar.visibility =View.GONE

    }

    override fun onCrimeSelected(crimeId: UUID) {
        Log.d(TAG, "onCrimeSelected: $crimeId")
        val fragment = CrimeFragment.newInstance(crimeId)
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                R.anim.slide_in_right,  // enter
                R.anim.fade_out,  // exit
                R.anim.fade_in,   // popEnter
                R.anim.slide_out_right  // popExit

            )
            .replace(R.id.fragment_container,fragment)
            .addToBackStack(null)
            .commit()
    }


}


