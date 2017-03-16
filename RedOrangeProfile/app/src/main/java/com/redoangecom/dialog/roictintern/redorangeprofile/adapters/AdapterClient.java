package com.redoangecom.dialog.roictintern.redorangeprofile.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.redoangecom.dialog.roictintern.redorangeprofile.R;
import com.redoangecom.dialog.roictintern.redorangeprofile.models.OurClient;
import com.redoangecom.dialog.roictintern.redorangeprofile.utils.AlertMessage;
import com.redoangecom.dialog.roictintern.redorangeprofile.utils.ProportionalImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by roictintern on 14-Dec-16.
 */

public class AdapterClient extends RecyclerView.Adapter<AdapterClient.ClientViewHolder>{

    private ArrayList<OurClient> dataSource;
    private Context context;
    private LayoutInflater inflater;
    public AdapterClient(Context context, ArrayList<OurClient> dataSource) {
        this.context = context;
        this.dataSource = dataSource;
    }

    @Override
    public ClientViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.client_cell , parent , false);
        ClientViewHolder holder = new ClientViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(ClientViewHolder holder, int position) {

        Picasso.with(context).load(context.getString(dataSource.get(position).getLogoId())).into(holder.logo);
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }

    @Override
    public long getItemId(int position) {
        OurClient client = dataSource.get(position);
        return client.hashCode();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    class ClientViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ProportionalImageView logo;

        public ClientViewHolder(View itemView) {
            super(itemView);
            logo = (ProportionalImageView) itemView.findViewById(R.id.client_logo);

            logo.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            int pos =  getAdapterPosition();
            if(!isNetworkAvailable()){

                AlertMessage am = new AlertMessage("You Are Not Connected To Internet" , "Network Alert" , -1 , context);
                am.ShowAlertDialog();
                return;
            }

            if(dataSource.get(pos).getUrlId() < 0){
                AlertMessage am = new AlertMessage("URL Not Available" , "Warning Message" , -1 , context);
                am.ShowAlertDialog();
                return;
            }

            Intent browserIntent = new Intent(Intent.ACTION_VIEW , Uri.parse(context.getString(dataSource.get(pos).getUrlId())));
            context.startActivity(browserIntent);
        }

        private boolean isNetworkAvailable(){
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
            NetworkInfo nInfo = cm.getActiveNetworkInfo();
            return nInfo != null && nInfo.isConnectedOrConnecting();
        }
    }
}
