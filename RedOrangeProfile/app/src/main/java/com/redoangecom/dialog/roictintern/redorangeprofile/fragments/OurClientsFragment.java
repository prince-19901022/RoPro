package com.redoangecom.dialog.roictintern.redorangeprofile.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.redoangecom.dialog.roictintern.redorangeprofile.R;
import com.redoangecom.dialog.roictintern.redorangeprofile.adapters.AdapterClient;
import com.redoangecom.dialog.roictintern.redorangeprofile.models.OurClient;
import com.redoangecom.dialog.roictintern.redorangeprofile.utils.SpacesItemDecoration;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class OurClientsFragment extends Fragment {

    private RecyclerView clientRV;
    private AdapterClient adapter;
    private RecyclerView.LayoutManager lm;
    private static final int ROW_SPAN = 3;

    public OurClientsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View clientView = inflater.inflate(R.layout.fragment_our_clients , container , false);

        clientRV = (RecyclerView) clientView.findViewById(R.id.clientRV);
        adapter = new AdapterClient(getActivity() , getData());
        lm = new GridLayoutManager(getActivity() ,  ROW_SPAN);

        clientRV.setHasFixedSize(true);
        adapter.setHasStableIds(true);
        clientRV.setLayoutManager(lm);
        clientRV.setItemAnimator(new DefaultItemAnimator());
        clientRV.addItemDecoration(new SpacesItemDecoration(6 , 6 , ROW_SPAN , getActivity()));
        clientRV.setAdapter(adapter);

        return clientView;
    }

    private ArrayList<OurClient> getData(){
        ArrayList<OurClient> dataSource = new ArrayList<>();
        OurClient client;

        client = new OurClient(R.string.dutche_logo , R.string.dutche_url);
        dataSource.add(client);

        client = new OurClient(R.string.proofs_logo , -1);
        dataSource.add(client);

        client = new OurClient(R.string.nuffic_logo , R.string.nuffic_url);
        dataSource.add(client);

        client = new OurClient(R.string.giz_logo , R.string.giz_url);
        dataSource.add(client);

        client = new OurClient(R.string.sanmark_logo , R.string.sanmark_url);
        dataSource.add(client);

        client = new OurClient(R.string.plan_logo , R.string.plan_url);
        dataSource.add(client);

        client = new OurClient(R.string.pact_logo , R.string.pact_url);
        dataSource.add(client);

        client = new OurClient(R.string.terredes_logo , R.string.terredes_url);
        dataSource.add(client);

        client = new OurClient(R.string.ifc_logo , R.string.ifc_url);
        dataSource.add(client);

        client = new OurClient(R.string.wop_logo ,-1);
        dataSource.add(client);

        client = new OurClient(R.string.fao_logo , R.string.fao_url);
        dataSource.add(client);

        client = new OurClient(R.string.bandhu_logo , R.string.bandhu_url);
        dataSource.add(client);

        client = new OurClient(R.string.blast_logo , R.string.blast_url);
        dataSource.add(client);

        client = new OurClient(R.string.uddp_logo , R.string.uddp_url);
        dataSource.add(client);

        client = new OurClient(R.string.supra_logo , R.string.supra_url);
        dataSource.add(client);

        client = new OurClient(R.string.wecan_logo ,R.string.wecan_url);
        dataSource.add(client);

        client = new OurClient(R.string.ucep_logo , R.string.ucep_url);
        dataSource.add(client);

        client = new OurClient(R.string.german_logo , R.string.german_url);
        dataSource.add(client);

        client = new OurClient(R.string.undp_logo , R.string.undp_url);
        dataSource.add(client);

        client = new OurClient(R.string.kit_logo , R.string.kit_url);
        dataSource.add(client);

        client = new OurClient(R.string.icco_logo , R.string.icco_url);
        dataSource.add(client);

        client = new OurClient(R.string.wfp_logo , R.string.wfp_url);
        dataSource.add(client);

        client = new OurClient(R.string.simavi_logo , R.string.simavi_url);
        dataSource.add(client);

        client = new OurClient(R.string.ntr_logo , R.string.ntr_url);
        dataSource.add(client);

        client = new OurClient(R.string.snv_logo , R.string.snv_url);
        dataSource.add(client);

        client = new OurClient(R.string.ide_logo , R.string.ide_url);
        dataSource.add(client);

        client = new OurClient(R.string.zdf_logo , R.string.zdf_url);
        dataSource.add(client);

        client = new OurClient(R.string.a2i_logo , R.string.a2i_url);//
        dataSource.add(client);

        client = new OurClient(R.string.oxfam_logo , R.string.oxfam_url);
        dataSource.add(client);

        client = new OurClient(R.string.mottmac_logo , R.string.mottmac_url);
        dataSource.add(client);

        client = new OurClient(R.string.max_logo , R.string.max_url);
        dataSource.add(client);

        client = new OurClient(R.string.jpg_school_logo , R.string.jpg_school_url);
        dataSource.add(client);

        client = new OurClient(R.string.image_logo , R.string.image_url);
        dataSource.add(client);

        client = new OurClient(R.string.tno_logo , R.string.tno_url);
        dataSource.add(client);

        return dataSource;
    }

}
