package com.example.apniteam.service

import com.example.apniteam.model.Data
import com.example.apniteam.model.info.MatchInfo
import com.example.apniteam.model.scoreCard.ScoreData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface RetrofitServiceInter {
    @GET("livematches")
    fun listOfLiveMatch(): Call<Data>
    @GET("{matchId}")
    fun getMatchInfo(@Path("matchId") matchid:String):Call<MatchInfo>

    @GET("{matchId}/scorecard.json")
    fun getScoreCardInfo(@Path("matchId") matchid:String):Call<ScoreData>
}