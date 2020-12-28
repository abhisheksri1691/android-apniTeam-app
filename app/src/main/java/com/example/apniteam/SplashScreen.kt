package com.example.apniteam

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.apniteam.viewmodel.ScoreViewModel
import com.google.gson.Gson


class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val SPLASH_SCREEN_TIME_OUT=2000L
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)
        val  mViewModel = ViewModelProviders.of(this).get(ScoreViewModel::class.java)
        mViewModel.init()
        mViewModel.newsRepository.observe(this, Observer {
            println("inside observer Splash screen")
            val matchList = it.matches.filter {
                it.seriesId == "3130" &&
                        it.header.stateTitle == "Preview" || it.header.stateTitle == "In Progress" || it.header.stateTitle =="Ings Break"
                        || it.header.stateTitle =="Toss"
            }

            val i = Intent(
                this@SplashScreen,
                MainActivity::class.java
            )
            val gson = Gson()
            i.putExtra("matchList",gson.toJson(matchList))
            //Intent is used to switch from one activity to another.
            startActivity(i)
            //invoke the SecondActivity.
            finish()
        })

        Handler().postDelayed({

            //the current activity will get finished.
        }, SPLASH_SCREEN_TIME_OUT)
    }
}
