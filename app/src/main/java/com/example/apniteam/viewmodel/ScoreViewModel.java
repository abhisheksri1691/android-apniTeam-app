package com.example.apniteam.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.apniteam.RetrofitRepository;
import com.example.apniteam.model.Data;
import com.example.apniteam.model.info.MatchInfo;
import com.example.apniteam.model.scoreCard.ScoreData;

public class ScoreViewModel extends ViewModel {
    private MutableLiveData<Data> mutableLiveData;
    private MutableLiveData<MatchInfo> matchInfoLiveData;
    private MutableLiveData<ScoreData> matchScoreCardLiveData;
    private RetrofitRepository retrofitRepository;


    public void init(){
        if (mutableLiveData != null){
            return;
        }
        retrofitRepository = RetrofitRepository.getInstance();
        mutableLiveData = retrofitRepository.getLiveScore();

    }
    public void getMatchInfoDate(  String mid){
        retrofitRepository = RetrofitRepository.getInstance();
        matchInfoLiveData = retrofitRepository.getMatchInfo(mid);
    }

    public void getMatchScoreCard(  String mid){
        retrofitRepository = RetrofitRepository.getInstance();
        matchScoreCardLiveData = retrofitRepository.getMatchScoreInfo(mid);
    }

    public LiveData<Data> getNewsRepository() {
        return mutableLiveData;
    }

    public LiveData<MatchInfo> getMatchInfo() {

        return matchInfoLiveData;
    }

    public LiveData<ScoreData> getMatchScoreCardInfo() {

        return matchScoreCardLiveData;
    }


}
