package com.suleymanince.retrofitadvancedlist.RestApi;

import com.suleymanince.retrofitadvancedlist.Models.Bilgiler;
import com.suleymanince.retrofitadvancedlist.Models.Result;

import java.util.List;

import retrofit2.Call;

public class ManagerAll extends BaseManager{
    private static ManagerAll ourInstance = new ManagerAll();

    public static synchronized ManagerAll getInstance(){
        return ourInstance;
    }

    public Call<List<Bilgiler>> getirBilgileri(){
        Call<List<Bilgiler>> call =  getRestApiClient().bilgiGetir();
        return call;
    }

    public Call<List<Result>> managerGetResult(String post, String id){
        Call<List<Result>> call =  getRestApiClient().getirResult(post,id);
        return call;
    }
}
