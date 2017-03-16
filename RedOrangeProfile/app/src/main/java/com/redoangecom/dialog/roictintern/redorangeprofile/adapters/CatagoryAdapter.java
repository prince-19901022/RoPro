package com.redoangecom.dialog.roictintern.redorangeprofile.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.redoangecom.dialog.roictintern.redorangeprofile.R;

import java.util.ArrayList;

/**
 * Created by roictintern on 09-Jan-17.
 */

public class CatagoryAdapter extends BaseAdapter{

    private ArrayList<String> dataSource;
    private Context context;
    private LayoutInflater inflater;

    public CatagoryAdapter(Context context, ArrayList<String> dataSource) {
        this.context = context;
        this.dataSource = dataSource;
    }


    @Override
    public int getCount() {
        return dataSource.size();
    }

    @Override
    public String getItem(int position) {
        return dataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MyViewHolder holder;

        if(convertView == null){

            inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.catagory_row , parent , false);
            holder = new MyViewHolder(convertView);
            convertView.setTag(holder);
        }else{

            holder = (MyViewHolder) convertView.getTag();
        }

        holder.catagory.setText(dataSource.get(position));

        return convertView;
    }

    private class MyViewHolder{
        private TextView catagory;

        public MyViewHolder(View convertView) {

            catagory = (TextView) convertView.findViewById(R.id.ctgryTitle);
        }
    }
}
