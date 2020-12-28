package com.example.apniteam

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.apniteam.model.Match
import com.example.apniteam.viewmodel.ScoreViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         var  matchId1=""
        var  matchId2=""
        var  time1=""
        var  time2=""
        var title ="N/A"
        val gson = Gson()
        val  matchList=
            gson.fromJson<List<Match>>(intent.getStringExtra("matchList"),
                object : TypeToken<List<Match?>?>() {}.type
            )
        var cal = Calendar.getInstance()
        val sformat = SimpleDateFormat("EEE, dd MMM hh:mm aa")
        if(matchList.isNotEmpty()) {

            tvTitleLive.text = matchList[0].header.matchDesc +"* IPL , 2020"
            tvStatus.text = matchList[0].header.status
            cal = Calendar.getInstance()
            cal.timeInMillis = matchList[0].header.startTime.toLong() * 1000

            time1 = sformat.format(cal.time)
            tvTimeLive.text = sformat.format(cal.time)
            tvTeam1Live.text = matchList[0].team1.name
            tvTeam2Live.text = matchList[0].team2.name
            title = matchList[0].team1.sName + " vs " + matchList[0].team2.sName
            matchId1 = matchList[0].matchId
        }
        if(matchList.size>1)
        {
            tvTitlePrevious.text = matchList[1].header.matchDesc +"* IPL , 2020"
            tvStatusPrevious.text = matchList[1].header.status
            cal.timeInMillis = matchList[1].header.startTime.toLong()*1000
            tvTimePrevious.text=sformat.format(cal.time)
            time2 = sformat.format(cal.time)
            tvTeam1Previous.text = matchList[1].team1.name
            tvTeam2Previous.text = matchList[1].team2.name
            matchId2=matchList[1].matchId

        }
        else
            cardview_id_Previous.visibility = View.GONE

        cardview_id_live.setOnClickListener {
            println("time1::"+time1)
            println("live match card click::::")

            val i = Intent(
                this,
                ContestActivity::class.java
            )
            i.putExtra("matchid",matchId1)
            i.putExtra("title",title)
            i.putExtra("mtime",time1)
            //Intent is used to switch from one activity to another.
            startActivity(i)
            //invoke the SecondActivity.
        }

        cardview_id_Previous.setOnClickListener {
println("time2::"+time2)
            val i = Intent(
                this,
                ContestActivity::class.java
            )
            i.putExtra("matchid",matchId2)
            i.putExtra("title",title)
            i.putExtra("mtime",time2)
            //Intent is used to switch from one activity to another.
            startActivity(i)
            //invoke the SecondActivity.
        }


    }
}
