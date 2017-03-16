package com.redoangecom.dialog.roictintern.redorangeprofile.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.redoangecom.dialog.roictintern.redorangeprofile.R;
import com.redoangecom.dialog.roictintern.redorangeprofile.adapters.AdapterTeam;
import com.redoangecom.dialog.roictintern.redorangeprofile.models.TeamMember;
import com.redoangecom.dialog.roictintern.redorangeprofile.utils.RcyclerViewListener;
import com.redoangecom.dialog.roictintern.redorangeprofile.utils.SpacesItemDecoration;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TeamFragment extends Fragment implements RcyclerViewListener{


    private RecyclerView teamRV;
    private AdapterTeam adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static final int COLUMNS = 3;

    public TeamFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View teamView = inflater.inflate(R.layout.fragment_team, container, false);

        teamRV = (RecyclerView) teamView.findViewById(R.id.teamRV);
        adapter = new AdapterTeam(getActivity() , getData() , this);
        layoutManager = new GridLayoutManager(getActivity() , COLUMNS);

        teamRV.addItemDecoration(new SpacesItemDecoration(5 , 5 , COLUMNS , getActivity()));
        teamRV.setItemAnimator(new DefaultItemAnimator());

        teamRV.setLayoutManager(layoutManager);
        teamRV.setAdapter(adapter);

        return teamView;
    }

    private ArrayList<TeamMember> getData(){
        ArrayList<TeamMember> dataSource = new ArrayList<>();
        TeamMember member;

        member = new TeamMember();
        member.setmImgPath("file:///android_asset/team/arnobweb.jpg");
        member.setMemName(R.string.arnob);
        member.setMemDesig(R.string.arnob_post);
        member.setMemDescription(R.string.arnob_profile);
        dataSource.add(member);

        member = new TeamMember();
        member.setmImgPath("file:///android_asset/team/geertweb.jpg");
        member.setMemName(R.string.geert);
        member.setMemDesig(R.string.geert_post);
        member.setMemDescription(R.string.geert_profile);
        dataSource.add(member);

        member = new TeamMember();
        member.setmImgPath("file:///android_asset/team/wijnand2.jpg");
        member.setMemName(R.string.wiznand);
        member.setMemDesig(R.string.wiznand_post);
        member.setMemDescription(R.string.wiznand_profile);
        dataSource.add(member);

        member = new TeamMember();
        member.setmImgPath("file:///android_asset/team/shafi.png");
        member.setMemName(R.string.shafi);
        member.setMemDesig(R.string.shafi_post);
        member.setMemDescription(R.string.shafi_profile);
        dataSource.add(member);

        member = new TeamMember();
        member.setmImgPath("file:///android_asset/team/nakib.jpg");
        member.setMemName(R.string.nakib);
        member.setMemDesig(R.string.nakib_post);
        member.setMemDescription(R.string.nakib_profile);
        dataSource.add(member);

        member = new TeamMember();
        member.setmImgPath("file:///android_asset/team/ireneweb.jpg");
        member.setMemName(R.string.irene);
        member.setMemDesig(R.string.irene_post);
        member.setMemDescription(R.string.irene_profile);
        dataSource.add(member);

        member = new TeamMember();
        member.setmImgPath("file:///android_asset/team/shahid.jpg");
        member.setMemName(R.string.shahidul);
        member.setMemDesig(R.string.shahidul_post);
        member.setMemDescription(R.string.shahidul_profile);
        dataSource.add(member);

        member = new TeamMember();
        member.setmImgPath("file:///android_asset/team/zimran.jpg");
        member.setMemName(R.string.zimran);
        member.setMemDesig(R.string.zimran_post);
        member.setMemDescription(R.string.zimranl_profile);
        dataSource.add(member);

        member = new TeamMember();
        member.setmImgPath("file:///android_asset/team/haiderweb.jpg");
        member.setMemName(R.string.haider);
        member.setMemDesig(R.string.haider_post);
        member.setMemDescription(R.string.haider_profile);
        dataSource.add(member);

        member = new TeamMember();
        member.setmImgPath("file:///android_asset/team/apuweb.jpg");
        member.setMemName(R.string.apu);
        member.setMemDesig(R.string.apu_post);
        member.setMemDescription(R.string.apu_profile);
        dataSource.add(member);

        member = new TeamMember();
        member.setmImgPath("file:///android_asset/team/jewelweb.jpg");
        member.setMemName(R.string.jewel);
        member.setMemDesig(R.string.jewel_post);
        member.setMemDescription(R.string.jewel_profile);
        dataSource.add(member);

        member = new TeamMember();
        member.setmImgPath("file:///android_asset/team/Nico.png");
        member.setMemName(R.string.nico);
        member.setMemDesig(R.string.nico_post);
        member.setMemDescription(R.string.nico_profile);
        dataSource.add(member);

        member = new TeamMember();
        member.setmImgPath("file:///android_asset/team/ratan.jpg");
        member.setMemName(R.string.ratan);
        member.setMemDesig(R.string.ratan_post);
        member.setMemDescription(R.string.ratan_profile);
        dataSource.add(member);

        member = new TeamMember();
        member.setmImgPath("file:///android_asset/team/luckyweb.jpg");
        member.setMemName(R.string.lucky);
        member.setMemDesig(R.string.lucky_post);
        member.setMemDescription(R.string.lucky_profile);
        dataSource.add(member);

        member = new TeamMember();
        member.setmImgPath("file:///android_asset/team/ferdous.jpg");
        member.setMemName(R.string.ferdous);
        member.setMemDesig(R.string.ferdous_post);
        member.setMemDescription(R.string.ferdous_profile);
        dataSource.add(member);

        member = new TeamMember();
        member.setmImgPath("file:///android_asset/team/neela.jpg");
        member.setMemName(R.string.neela);
        member.setMemDesig(R.string.neela_post);
        member.setMemDescription(R.string.neela_profile);
        dataSource.add(member);

        member = new TeamMember();
        member.setmImgPath("file:///android_asset/team/pervezweb.jpg");
        member.setMemName(R.string.pervez);
        member.setMemDesig(R.string.pervez_post);
        member.setMemDescription(R.string.pervez_profile);
        dataSource.add(member);

        member = new TeamMember();
        member.setmImgPath("file:///android_asset/team/tania.jpg");
        member.setMemName(R.string.tania);
        member.setMemDesig(R.string.tania_post);
        member.setMemDescription(R.string.tania_profile);
        dataSource.add(member);

        member = new TeamMember();
        member.setmImgPath("file:///android_asset/team/rupok.png");
        member.setMemName(R.string.mazharul);
        member.setMemDesig(R.string.mazharul_post);
        member.setMemDescription(R.string.mazharul_profile);
        dataSource.add(member);

        member = new TeamMember();
        member.setmImgPath("file:///android_asset/team/arif.jpg");
        member.setMemName(R.string.arif);
        member.setMemDesig(R.string.arif_post);
        member.setMemDescription(R.string.arif_profile);
        dataSource.add(member);

        member = new TeamMember();
        member.setmImgPath("file:///android_asset/team/sabrina.png");
        member.setMemName(R.string.sabrina);
        member.setMemDesig(R.string.sabrina_post);
        member.setMemDescription(R.string.sabrina_profile);
        dataSource.add(member);

        member = new TeamMember();
        member.setmImgPath("file:///android_asset/team/noman.jpg");
        member.setMemName(R.string.noman);
        member.setMemDesig(R.string.noman_post);
        member.setMemDescription(R.string.noman_profile);
        dataSource.add(member);

        member = new TeamMember();
        member.setmImgPath("file:///android_asset/team/shirin.jpg");
        member.setMemName(R.string.shirin);
        member.setMemDesig(R.string.shirin_post);
        member.setMemDescription(R.string.shirin_profile);
        dataSource.add(member);

        member = new TeamMember();
        member.setmImgPath("file:///android_asset/team/sharif.jpg");
        member.setMemName(R.string.shariful);
        member.setMemDesig(R.string.shariful_post);
        member.setMemDescription(R.string.shariful_profile);
        dataSource.add(member);

        member = new TeamMember();
        member.setmImgPath("file:///android_asset/team/anikaro.jpg");
        member.setMemName(R.string.anika);
        member.setMemDesig(R.string.anika_post);
        member.setMemDescription(R.string.anika_profile);
        dataSource.add(member);

        member = new TeamMember();
        member.setmImgPath("file:///android_asset/team/shuchi.jpg");
        member.setMemName(R.string.suchi);
        member.setMemDesig(R.string.suchi_post);
        member.setMemDescription(R.string.suchi_profile);
        dataSource.add(member);

        member = new TeamMember();
        member.setmImgPath("file:///android_asset/team/ronni.jpg");
        member.setMemName(R.string.ronni);
        member.setMemDesig(R.string.ronni_post);
        member.setMemDescription(R.string.ronni_profile);
        dataSource.add(member);

        member = new TeamMember();
        member.setmImgPath("file:///android_asset/team/mitali.jpg");
        member.setMemName(R.string.mitali);
        member.setMemDesig(R.string.mitali_post);
        member.setMemDescription(R.string.mitali_profile);
        dataSource.add(member);

        member = new TeamMember();
        member.setmImgPath("file:///android_asset/team/syed.jpg");
        member.setMemName(R.string.syed);
        member.setMemDesig(R.string.syed_post);
        member.setMemDescription(R.string.syed_profile);
        dataSource.add(member);

        member = new TeamMember();
        member.setmImgPath("file:///android_asset/team/jibonweb1.jpg");
        member.setMemName(R.string.jibon);
        member.setMemDesig(R.string.jibon_post);
        member.setMemDescription(R.string.jibon_profile);
        dataSource.add(member);

        member = new TeamMember();
        member.setmImgPath("file:///android_asset/team/sabujweb.jpg");
        member.setMemName(R.string.sabuj);
        member.setMemDesig(R.string.sabuj_post);
        member.setMemDescription(R.string.sabuj_profile);
        dataSource.add(member);

        member = new TeamMember();
        member.setmImgPath("file:///android_asset/team/hridoy.jpg");
        member.setMemName(R.string.hridoy);
        member.setMemDesig(R.string.hridoy_post);
        member.setMemDescription(R.string.hridoy_profile);
        dataSource.add(member);

        member = new TeamMember();
        member.setmImgPath("file:///android_asset/team/ripon.jpg");
        member.setMemName(R.string.ripon);
        member.setMemDesig(R.string.ripon_post);
        member.setMemDescription(R.string.ripon_profile);
        dataSource.add(member);

        member = new TeamMember();
        member.setmImgPath("file:///android_asset/team/ruhulweb.jpg");
        member.setMemName(R.string.ruhul);
        member.setMemDesig(R.string.ruhul_post);
        member.setMemDescription(R.string.ruhul_profile);
        dataSource.add(member);

        return dataSource;
    }

    @Override
    public void onRecyclerViewEvent(Object ob) {

        TeamMember member = (TeamMember) ob;
        MemberDetail md = MemberDetail.newInstance(member);
        md.show(getFragmentManager() , "Member Detail");
    }
}
