package com.example.apniteam;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.apniteam.model.Data;
import com.example.apniteam.model.info.MatchInfo;
import com.example.apniteam.model.scoreCard.ScoreData;
import com.example.apniteam.service.RetrofitService;
import com.example.apniteam.service.RetrofitServiceInter;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitRepository {
    private static RetrofitRepository retrofitRepository;
    private RetrofitServiceInter rService;
    final MutableLiveData<ScoreData> scoredata = new MutableLiveData<>();

    public static RetrofitRepository getInstance(){
        if (retrofitRepository == null){
            retrofitRepository = new RetrofitRepository();
        }
        return retrofitRepository;
    }

    public RetrofitRepository(){
        rService = RetrofitService.createService(RetrofitServiceInter.class);
    }

    public MutableLiveData<Data> getLiveScore()
    {
        final MutableLiveData<Data> data = new MutableLiveData<>();
        rService.listOfLiveMatch().enqueue(
                new Callback<Data>() {
                    @Override
                    public void onResponse(Call<Data> call, Response<Data> response) {
                        System.out.println("inside onRespnse");
                        Log.e("onRespose::",response.body().toString());
                        if (response.isSuccessful()){
                            data.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<Data> call, Throwable t) {

                    }
                }

        );
        return data;
    }


    public MutableLiveData<MatchInfo> getMatchInfo(String mid)
    {
        final MutableLiveData<MatchInfo> data = new MutableLiveData<>();
        rService.getMatchInfo(mid).enqueue(
                new Callback<MatchInfo>() {
                    @Override
                    public void onResponse(Call<MatchInfo> call, Response<MatchInfo> response) {
                        System.out.println("inside onRespnse");

                        if (response.isSuccessful()){
                            data.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<MatchInfo> call, Throwable t) {

                    }
                }

        );
        return data;
    }

    public MutableLiveData<ScoreData> getMatchScoreInfo(String mid)
    {

        rService.getScoreCardInfo(mid).enqueue(
                new Callback<ScoreData>() {
                    @Override
                    public void onResponse(Call<ScoreData> call, Response<ScoreData> response) {
                        System.out.println("inside onRespnse getMatchScoreInfo");

                        if (response.isSuccessful()){
                            System.out.println("inside onRespnse getMatchScoreInfo isSuccessful");
                            scoredata.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<ScoreData> call, Throwable t) {

                    }
                }

        );
        return scoredata;
    }

}
