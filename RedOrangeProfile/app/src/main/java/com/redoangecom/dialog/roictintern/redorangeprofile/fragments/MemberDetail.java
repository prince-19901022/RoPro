package com.redoangecom.dialog.roictintern.redorangeprofile.fragments;

import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.redoangecom.dialog.roictintern.redorangeprofile.R;
import com.redoangecom.dialog.roictintern.redorangeprofile.models.TeamMember;
import com.redoangecom.dialog.roictintern.redorangeprofile.utils.ProportionalImageView;
import com.squareup.picasso.Picasso;

/**
 * Created by Nutrino on 12/31/2016.
 */

public class MemberDetail extends DialogFragment {

    private ProportionalImageView memImage;
    private TextView  memName;
    private TextView  desig;
    private TextView  profile;
    private Button ok;

    private TeamMember member;

    public static MemberDetail newInstance(TeamMember member){

        MemberDetail md = new MemberDetail();
        md.member = member;
        return md;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        View memberDetail = inflater.inflate(R.layout.fragment_member_desc_dialog , container , false);

        memImage = (ProportionalImageView) memberDetail.findViewById(R.id.member_imageDsc);
        desig    = (TextView) memberDetail.findViewById(R.id.desigDsc);
        memName  = (TextView) memberDetail.findViewById(R.id.member_nameDsc);
        profile  = (TextView) memberDetail.findViewById(R.id.desc);
        ok       = (Button) memberDetail.findViewById(R.id.OK);

        Picasso.with(getActivity()).load(member.getmImgPath()).into(memImage);
        desig.setText(getActivity().getResources().getString(member.getMemDesig()));
        memName.setText(getActivity().getResources().getString(member.getMemName()));
        profile.setText(getActivity().getResources().getString(member.getMemDescription()));

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        return memberDetail;
    }
}
