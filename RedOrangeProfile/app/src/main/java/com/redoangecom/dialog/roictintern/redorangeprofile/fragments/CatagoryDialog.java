package com.redoangecom.dialog.roictintern.redorangeprofile.fragments;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.redoangecom.dialog.roictintern.redorangeprofile.R;
import com.redoangecom.dialog.roictintern.redorangeprofile.adapters.CatagoryAdapter;
import com.redoangecom.dialog.roictintern.redorangeprofile.utils.AppConstant;
import com.redoangecom.dialog.roictintern.redorangeprofile.utils.CatagoryListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CatagoryDialog extends DialogFragment {

    private ListView catagoryList;
    private ArrayList<String> dataSource;
    private CatagoryAdapter adapter;
    private String TAG;
    private CatagoryListener ctgryL;

    public static CatagoryDialog newInstance(String TAG , PortfolioCarousel pfc){
        CatagoryDialog cd = new CatagoryDialog();
        cd.TAG = TAG;
        cd.ctgryL = pfc;
        return cd;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View cdView = inflater.inflate(R.layout.fragment_catagory_dialog , null);

        dataSource = AppConstant.getProductionCatagories(TAG);

        initViews(cdView);
        initAction();

        builder.setView(cdView);
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                getDialog().dismiss();
            }
        });

        return builder.create();
    }

    private void initViews(View dView){

        catagoryList = (ListView) dView.findViewById(R.id.catagoryList);
        adapter      = new CatagoryAdapter(getActivity() , dataSource);
        catagoryList.setAdapter(adapter);
    }

    private void initAction(){

        catagoryList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ctgryL.onCatagorySelected(adapter.getItem(position));
                getDialog().dismiss();
            }
        });
    }
}
