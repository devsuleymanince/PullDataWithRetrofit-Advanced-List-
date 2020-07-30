package com.suleymanince.retrofitadvancedlist.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.suleymanince.retrofitadvancedlist.ListeDetay;
import com.suleymanince.retrofitadvancedlist.Models.Bilgiler;
import com.suleymanince.retrofitadvancedlist.R;

import java.util.List;

public class AdapterBilgi extends BaseAdapter {

    List<Bilgiler> list;
    Context context;
    Activity activity; // Bu class aktiviteli class olmadığı için böyle tanım şart

    public AdapterBilgi(List<Bilgiler> list, Context context, Activity activity) {
        this.list = list;
        this.context = context;
        this.activity = activity;
    }



    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.layout_tek_liste,parent,false);

        LinearLayout linLayTekList = convertView.findViewById(R.id.lin_lay_tek_list);
        TextView txtPostId = convertView.findViewById(R.id.txt_post_id);
        TextView txtId = convertView.findViewById(R.id.txt_id);
        TextView txtName = convertView.findViewById(R.id.txt_name);
        TextView txtEmail = convertView.findViewById(R.id.txt_email);
        TextView txtBody = convertView.findViewById(R.id.txt_body);

        txtPostId.setText(""+list.get(position).getPostId());
        txtId.setText(""+list.get(position).getId());
        txtName.setText(""+list.get(position).getName());
        txtEmail.setText(""+list.get(position).getEmail());
        txtBody.setText(""+list.get(position).getBody());

        final String postPutExtra = ""+list.get(position).getPostId();
        final String idPutExtra = ""+list.get(position).getId();

        linLayTekList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, ListeDetay.class);
                intent.putExtra("post_id",postPutExtra);
                intent.putExtra("id",idPutExtra);
                activity.startActivity(intent);
            }
        });

        return convertView;
    }
}
