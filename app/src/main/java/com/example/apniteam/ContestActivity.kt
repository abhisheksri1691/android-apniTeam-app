package com.example.apniteam

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.apniteam.dao.DataBaseManager
import com.example.apniteam.model.PlayerModel
import com.example.apniteam.model.User
import com.example.apniteam.model.scoreCard.Inning
import com.example.apniteam.viewmodel.ScoreViewModel
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate.JOYFUL_COLORS
import kotlinx.android.synthetic.main.contest_activity.*
import java.util.*
import kotlin.collections.ArrayList


class ContestActivity : AppCompatActivity() {
    var  user1 = User()
    var user2 = User()
    var timer =Timer()
    var  mViewModel:ScoreViewModel?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contest_activity)
          mViewModel = ViewModelProviders.of(this).get(ScoreViewModel::class.java)
         mid = intent.getStringExtra("matchid")
        val time = intent.getStringExtra("mtime")

        val title = intent.getStringExtra("title")
        mViewModel!!.getMatchScoreCard(mid)

        val dbManager =  DataBaseManager(this)
        dbInstance = dbManager
        dbInstance.open()
        tvTitleLive.text=title
        tvTimeLive.text=time
        var arrayListOfEntry = ArrayList<PieEntry>()



        swipeToRefresh.setOnRefreshListener {
            println("referssh call:::")
            mViewModel!!.getMatchScoreCard(mid)
        }
        btCreateTeam.setOnClickListener {
            val i = Intent(
                this,
                RegisterUserActivity::class.java
            )
            i.putExtra("matchid",mid)
            //Intent is used to switch from one activity to another.
            startActivity(i)
       }

        mViewModel!!
            .matchScoreCardInfo.observe(this, Observer {
                swipeToRefresh.isRefreshing = false
                Log.i("inside  observer matchScoreCardInfo","i am dome")
                if(it.innings.size>0)
                {
                    val listPlayer = it.innings[0].batsmen
                    var score1=0
                    var score2=0
                    val  playerList1= dbInstance.fetchPlayerList(user1.id) // from User 1
                    val  playerList2= dbInstance.fetchPlayerList(user2.id) // from User 2
                    var index = 0
                    playerList1.forEach { plyer: PlayerModel? ->
                        index++
                        when(index)
                        {
                            1->{
                                tv_Player1Name1.text = plyer!!.name
                                updateScore(tv_Player1Name1,tv_Player1Name1Score,tv_Player1Name1Status,it.innings,plyer)
                            }

                            2->{
                                tv_Player1Name2.text = plyer!!.name
                                updateScore(tv_Player1Name2,tv_Player1Name2Score,tv_Player1Name2Status,it.innings,plyer)
                            }

                            3->{
                                tv_Player1Name3.text = plyer!!.name
                                updateScore(tv_Player1Name3,tv_Player1Name3Score,tv_Player1Name3Status,it.innings,plyer)
                            }
                            4->{
                                tv_Player1Name4.text = plyer!!.name
                                updateScore(tv_Player1Name4,tv_Player1Name4Score,tv_Player1Name4Status,it.innings,plyer)
                            }
                        }
                    }

                    index = 0
                    playerList2.forEach { plyer: PlayerModel? ->
                        index++
                        when(index) {
                            1 -> {
                                tv_Player2Name1.text = plyer!!.name
                                updateScore(tv_Player2Name1,tv_Player2Name1Score,tv_Player2Name1Status,it.innings,plyer)
                            }

                            2 -> {
                                tv_Player2Name2.text = plyer!!.name
                                updateScore(tv_Player2Name2,tv_Player2Name2Score,tv_Player2Name2Status,it.innings,plyer)
                            }

                            3 -> {
                                tv_Player2Name3.text = plyer!!.name
                                updateScore(tv_Player2Name3,tv_Player2Name3Score,tv_Player2Name3Status,it.innings,plyer)
                            }
                            4 -> {
                                tv_Player2Name4.text = plyer!!.name
                                updateScore(tv_Player2Name4,tv_Player2Name4Score,tv_Player2Name4Status,it.innings,plyer)
                            }
                        }
                    }
                     score1=dbInstance.fetchPlayerScoreByUser(user1.id)
                     score2= dbInstance.fetchPlayerScoreByUser(user2.id)
                    tvUser1Score.text= score1.toString()
                    tvUser2Score.text=score2.toString()
                    arrayListOfEntry.clear()
                    arrayListOfEntry.add(PieEntry(score1.toFloat(),"Abhishek"))
                    arrayListOfEntry.add(PieEntry(score2.toFloat(),"Abhinav"))
                    var pieDtaSet = PieDataSet(arrayListOfEntry,"")
                    pichart.invalidate()
                    pichart.data = PieData(pieDtaSet)
                    pieDtaSet.colors = JOYFUL_COLORS.toList()
                    pieDtaSet.valueTextColor = Color.WHITE;
                    pieDtaSet.valueTextSize = 10f

                }
                else // match not started yet
                {
                    var  playerList1= dbInstance.fetchPlayerList(user1.id) // from User 1
                    var  playerList2= dbInstance.fetchPlayerList(user2.id) // from User 2

                    if(playerList1.size>0 && playerList2.size>0)
                    {
                        tv_Player1Name1.text = playerList1[0]!!.name
                        tv_Player1Name1Score.text = playerList1[0].score.toString()
                        tv_Player1Name1Status.text=playerList1[0].status

                        tv_Player1Name2.text = playerList1[1]!!.name
                        tv_Player1Name2Score.text = playerList1[1].score.toString()
                        tv_Player1Name2Status.text=playerList1[1].status


                        tv_Player1Name3.text = playerList1[2]!!.name
                        tv_Player1Name3Score.text = playerList1[2].score.toString()
                        tv_Player1Name3Status.text=playerList1[2].status

                        tv_Player1Name4.text = playerList1[3]!!.name
                        tv_Player1Name4Score.text = playerList1[3].score.toString()
                        tv_Player1Name4Status.text=playerList1[3].status


                        tv_Player2Name1.text = playerList2[0]!!.name
                        tv_Player2Name1Score.text = playerList2[0].score.toString()
                        tv_Player2Name1Status.text=playerList2[0].status

                        tv_Player2Name2.text = playerList2[1]!!.name
                        tv_Player2Name2Score.text = playerList2[1].score.toString()
                        tv_Player2Name2Status.text=playerList2[1].status

                        tv_Player2Name3.text = playerList2[2]!!.name
                        tv_Player2Name3Score.text = playerList2[2].score.toString()
                        tv_Player2Name3Status.text=playerList2[2].status

                        tv_Player2Name4.text = playerList2[3]!!.name
                        tv_Player2Name4Score.text = playerList2[3].score.toString()
                        tv_Player2Name4Status.text=playerList2[3].status

                    }

                }
            })


    }

    override fun onResume() {
        super.onResume()
        println("onResume is Called of ContestActivity")
        val list = dbInstance.fetchUserList(mid)

        if( list.size>0) // user find ,team  already created
        {
            timer =Timer()
            timer.schedule(object : TimerTask() {
                override fun run() {
                    mViewModel!!.getMatchScoreCard(mid)
                }
            }, 2000, 15000) // call api on every 10 sec
            relativeLayout.visibility = View.VISIBLE
            tv_Player1Name.visibility = View.VISIBLE
            btCreateTeam.visibility= View.GONE
            //btRefersh.visibility=View.VISIBLE
            user1 = list[0]
            user2 = list[1]
            val socreTeam1 = dbInstance.fetchPlayerScoreByUser(user1.id)
            val score2 = dbInstance.fetchPlayerScoreByUser(user2.id)
            view.visibility = View.VISIBLE
            tvTeam1Live.text = user1.name
            tvTeam2Live.text = user2.name
            tv_Player1Name.text = user1.name
            tv_Player2Name.text = user2.name
            tvUser1Score.text=socreTeam1.toString()
            tvUser2Score.text=score2.toString()
            pichart.visibility=View.VISIBLE

            mViewModel!!.getMatchScoreCard(mid)
        }

        else
        {
            btCreateTeam.visibility= View.VISIBLE
            view.visibility = View.INVISIBLE
            tvTeam1Live.text = "N/A"
            tvTeam2Live.text = "N/A"
            tvUser1Score.text="0"
            tvUser2Score.text="0"
            //btRefersh.visibility=View.GONE
            relativeLayout.visibility = View.GONE
            tv_Player1Name.visibility = View.GONE
            pichart.visibility=View.GONE

        }


    }

    companion object {
        @JvmStatic lateinit var dbInstance: DataBaseManager
        @JvmStatic lateinit var mid: String
    }

    override fun onPause() {
        super.onPause()
        timer.cancel()
        println("onPause is called::")
    }

    override fun onStop() {
        super.onStop()
        timer.cancel()
        println("onStop is called::")
    }

    override fun finish() {
        super.finish()
        println("onFinish Call database connection closed")
        timer.cancel()
        dbInstance.close()
    }

    fun updateScore(
        tvPlayername: TextView,
        tvPlayernamescore: TextView,
        tvPlayernamestatus: TextView,
        innings: MutableList<Inning>,
        plyer: PlayerModel
    )
    {
        if(plyer.isOut==1) // score and status is fixed
        {
            tvPlayernamescore.text = plyer.score.toString()
            tvPlayernamestatus.text=plyer.status
        }
        else
        {
            val finalList= innings[0].batsmen.filter {
                it.id==plyer.playerId.toString()
            }
            if(finalList.isNotEmpty()){
                tvPlayernamestatus.text=finalList[0].outDesc
                tvPlayernamescore.text = finalList[0].r
                if(finalList[0].outDesc=="batting")
                {
                    tvPlayername.text = tvPlayername.text.toString()+"*"
                    dbInstance.updatePlayerScore(plyer.id,finalList[0].r,"0",finalList[0].outDesc)
                }
                else
                {
                    tvPlayername.text = tvPlayername.text.toString().replace("*","")
                    dbInstance.updatePlayerScore(plyer.id,finalList[0].r,"1",finalList[0].outDesc)
                }

            }
            else
            {
                if(innings.size>1) // search in Scond inning
                {
                    val finalList2= innings[1].batsmen.filter {
                        it.id==plyer.playerId.toString()
                    }

                    if(finalList2.isNotEmpty()){
                        tvPlayernamestatus.text=finalList[0].outDesc
                        tvPlayernamescore.text = finalList[0].r
                        if(finalList2[0].outDesc=="batting")
                        {
                            tvPlayername.text = tvPlayername.text.toString()+"*"
                            dbInstance.updatePlayerScore(plyer.id,finalList2[0].r,"0",finalList2[0].outDesc)
                        }
                        else
                        {
                            tvPlayername.text = tvPlayername.text.toString().replace("*","")
                            dbInstance.updatePlayerScore(plyer.id,finalList2[0].r,"1",finalList2[0].outDesc)
                        }

                    }
                    else
                    {
                        tvPlayernamestatus.text=plyer.status
                        tvPlayernamescore.text = plyer.score.toString()
                    }

                }
                else
                {
                    tvPlayernamestatus.text=plyer.status
                    tvPlayernamescore.text = plyer.score.toString()
                }

            }

        }

    }
}
