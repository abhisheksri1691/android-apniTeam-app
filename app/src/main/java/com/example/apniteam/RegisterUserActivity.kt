package com.example.apniteam

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apniteam.model.PlayerModel
import com.example.apniteam.viewmodel.ScoreViewModel
import kotlinx.android.synthetic.main.reguser_activity.*
import kotlin.collections.set


class RegisterUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.reguser_activity)
        val dbManager = ContestActivity.dbInstance


        var mid = intent.getStringExtra("matchid")
        val playerModelList = ArrayList<PlayerModel>()
        val playerModelList2 = ArrayList<PlayerModel>()
        val playerListFinalList = ArrayList<PlayerModel>()
        val playerListFinalList1 = ArrayList<PlayerModel>()
        val playerListFinalList2 = ArrayList<PlayerModel>()
       val  mViewModel = ViewModelProviders.of(this).get(ScoreViewModel::class.java)
        mViewModel.getMatchInfoDate(mid)
        mViewModel.matchInfo.observe(this, Observer {
             val team1= it.team1.sName
             val team2= it.team2.sName
            it.team1.squad.forEach { pid->

                val pModel = PlayerModel()
                val pModel2 = PlayerModel()
                pModel.playerId = pid.toInt()
                pModel.userId =1
                pModel2.playerId = pid.toInt()
                pModel2.userId = 2
                val playerInfoList= it.players.filter { player ->
                    player.id ==pid.toString()
                }
                pModel.teamName = team1
                pModel.teamId = it.team1.id.toInt()
                pModel.name = playerInfoList[0].fName

                pModel2.teamName = team1
                pModel2.teamId = it.team1.id.toInt()
                pModel2.name = playerInfoList[0].fName
                playerModelList.add(pModel)
                playerModelList2.add(pModel2)
            }

            it.team2.squad.forEach { pid->

                val pModel = PlayerModel()
                val pModel2 = PlayerModel()
                pModel.playerId = pid.toInt()
                pModel2.playerId = pid.toInt()
                pModel.userId = 1
                pModel2.userId = 2
                val playerInfoList= it.players.filter { player ->
                    player.id ==pid.toString()
                }
                pModel.teamName = team2
                pModel.teamId = it.team2.id.toInt()
                pModel.name = playerInfoList[0].fName
                playerModelList.add(pModel)


                pModel2.teamName = team2
                pModel2.teamId = it.team2.id.toInt()
                pModel2.name = playerInfoList[0].fName
                playerModelList2.add(pModel2)
            }


            println("Total player model list 1 size is:::--->"+playerModelList.size)
            println("Total player model list 2 size is:::--->"+playerModelList2.size)
            if (playerModelList.size>0)
            {
                formlayout.visibility = View.VISIBLE
                tvWarnning.visibility = View.GONE
            }
            else
            {
                formlayout.visibility = View.GONE
                tvWarnning.visibility = View.VISIBLE
            }

        })

        tv_choose1.setOnClickListener {
            playerListFinalList1.clear()
            val viewmanager= LinearLayoutManager(this)
            val dialogView = LayoutInflater.from(applicationContext).inflate(R.layout.alert_dialog_activity, null)
            val alertDialog = AlertDialog.Builder(this)

            alertDialog.setView(dialogView)
            val alert= alertDialog.create()
            val viewAdapter = MyAdapter(playerModelList,this)
            dialogView.findViewById<Button>(R.id.bt_save_player).setOnClickListener {
                println("user1 choose players :: "+viewAdapter.playerListUser1.toString())
                alert.cancel()
                var finalPlayers =""
                viewAdapter.playerListUser1.forEach {
                    finalPlayers = finalPlayers+it.name+" , "
                }

                tv_player1_preview.text = finalPlayers
                playerListFinalList1.addAll(viewAdapter.playerListUser1)
            }

           val recyclerView = dialogView.findViewById<RecyclerView>(R.id.listViewId).apply {
                // use this setting to improve performance if you know that changes
                // in content do not change the layout size of the RecyclerView
                setHasFixedSize(true)

                // use a linear layout manager
                layoutManager = viewmanager

                // specify an viewAdapter (see also next example)
                adapter = viewAdapter

            }

            alert.show()
        }

        tv_choose2.setOnClickListener {
            playerListFinalList2.clear()
            val viewmanager= LinearLayoutManager(this)
            val dialogView = LayoutInflater.from(applicationContext).inflate(R.layout.alert_dialog_activity, null)
            val alertDialog = AlertDialog.Builder(this)

            alertDialog.setView(dialogView)
            val alert= alertDialog.create()
            val viewAdapter = MyAdapter(playerModelList2,this)
            dialogView.findViewById<Button>(R.id.bt_save_player).setOnClickListener {
                println("user2 choose players :: "+viewAdapter.playerListUser2.toString())
                playerListFinalList2.addAll(viewAdapter.playerListUser2)

                alert.cancel()
                var finalPlayers =""
                viewAdapter.playerListUser2.forEach {
                    finalPlayers = finalPlayers+it.name+" , "
                }

                tv_player2_preview.text = finalPlayers
            }

            val recyclerView = dialogView.findViewById<RecyclerView>(R.id.listViewId).apply {
                // use this setting to improve performance if you know that changes
                // in content do not change the layout size of the RecyclerView
                setHasFixedSize(true)

                // use a linear layout manager
                layoutManager =  viewmanager

                // specify an viewAdapter (see also next example)
                adapter = viewAdapter

            }

            alert.show()
        }
        btSaveUser.setOnClickListener {
            playerListFinalList.addAll(playerListFinalList1)
            playerListFinalList.addAll(playerListFinalList2)
            println("final playe lsit to save in db::$playerListFinalList")
            dbManager.deleteAllUser()
            dbManager.deleteAllPlayer()
            dbManager.insertIntoUser(edFUserName.text.toString(),mid)
            dbManager.insertIntoUser(edSUserName.text.toString(),mid)
            val uList = dbManager.fetchUserList(mid)
            playerListFinalList.forEach {

                if(it.userId==1)
                dbManager.insertIntoPlayer(it.name,it.playerId.toString(),"0","0",uList.get(0).id.toString(),"not yet batting")
                else
                    dbManager.insertIntoPlayer(it.name,it.playerId.toString(),"0","0",uList.get(1).id.toString(),"not yet batting")
           }
            finish()

       }


    }
}
