package com.suleymanince.retrofitadvancedlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


import com.suleymanince.retrofitadvancedlist.Models.Result;
import com.suleymanince.retrofitadvancedlist.RestApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListeDetay extends AppCompatActivity {

    String id,postid;
    TextView txtDetayPostId,txtDetayId,txtDetayName,txtDetayEmail,txtDetayBody;
    List liste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_detay);

        tanimla();
        mainActivitydenAl();
        detayIstek();
    }

    public void tanimla(){
        txtDetayPostId = findViewById(R.id.txt_detay_postId);
        txtDetayId = findViewById(R.id.txt_detay_id);
        txtDetayName = findViewById(R.id.txt_detay_name);
        txtDetayEmail = findViewById(R.id.txt_detay_email);
        txtDetayBody = findViewById(R.id.txt_detay_body);
    }

    public void mainActivitydenAl(){
        Bundle bundle = getIntent().getExtras();
        id = bundle.getString("id");
        postid = bundle.getString("post_id");


    }

    public void  atama(List<Result> list){
        txtDetayPostId.setText(""+list.get(0).getPostId());
        txtDetayId.setText(""+list.get(0).getId());
        txtDetayName.setText(""+list.get(0).getName());
        txtDetayEmail.setText(""+list.get(0).getEmail());
        txtDetayBody.setText(""+list.get(0).getBody());

    }

    public void detayIstek(){

        liste = new ArrayList();

        Call<List<Result>> resultList = ManagerAll.getInstance().managerGetResult(postid,id);

        resultList.enqueue(new Callback<List<Result>>() {
            @Override
            public void onResponse(Call<List<Result>> call, Response<List<Result>> response) {
                if(response.isSuccessful()){
                    liste = response.body();
                    atama(liste);
                }

            }

            @Override
            public void onFailure(Call<List<Result>> call, Throwable t) {

            }
        });

    }
}
