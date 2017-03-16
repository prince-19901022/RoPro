package com.redoangecom.dialog.roictintern.redorangeprofile.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.redoangecom.dialog.roictintern.redorangeprofile.R;
import com.redoangecom.dialog.roictintern.redorangeprofile.fragments.TeamFragment;
import com.redoangecom.dialog.roictintern.redorangeprofile.models.TeamMember;
import com.redoangecom.dialog.roictintern.redorangeprofile.utils.ProportionalImageView;
import com.redoangecom.dialog.roictintern.redorangeprofile.utils.RcyclerViewListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Nutrino on 12/31/2016.
 */

public class AdapterTeam extends RecyclerView.Adapter<AdapterTeam.MyViewHolder>{

    private Context context;
    private ArrayList<TeamMember> dataSource;
    private TeamFragment tfInstance;
    private Resources res;

    public AdapterTeam(Context context, ArrayList<TeamMember> dataSource, TeamFragment tfInstance) {
        this.context = context;
        this.dataSource = dataSource;
        this.tfInstance = tfInstance;
        res = context.getResources();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.team_grid_cell , parent , false);
        MyViewHolder holder = new MyViewHolder(itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.txtView.setText(res.getString(dataSource.get(position).getMemName()));
        Picasso.with(context).load(dataSource.get(position).getmImgPath()).into(holder.imgView);

        //aspect ratio is 1.1121 : 1
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ProportionalImageView imgView;
        private TextView txtView;
        private RcyclerViewListener rL;

        public MyViewHolder(View itemView) {
            super(itemView);

            imgView = (ProportionalImageView) itemView.findViewById(R.id.mImageGrid);
            txtView = (TextView) itemView.findViewById(R.id.mNameGrid);
            imgView.setOnClickListener(this);
            rL = tfInstance;
        }

        @Override
        public void onClick(View v) {

            int position = getAdapterPosition();
            rL.onRecyclerViewEvent(dataSource.get(position));
        }
    }
}
