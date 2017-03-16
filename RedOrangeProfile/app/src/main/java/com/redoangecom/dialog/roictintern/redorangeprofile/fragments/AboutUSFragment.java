package com.redoangecom.dialog.roictintern.redorangeprofile.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bluejamesbond.text.DocumentView;
import com.redoangecom.dialog.roictintern.redorangeprofile.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutUSFragment extends Fragment {

    private TextView padding;
    private DocumentView whoText , howText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View aboutusFrag = inflater.inflate(R.layout.fragment_about_us, container, false);

        whoText = (DocumentView) aboutusFrag.findViewById(R.id.whoText);
        howText = (DocumentView) aboutusFrag.findViewById(R.id.howText);
        padding = (TextView) aboutusFrag.findViewById(R.id.padding);

        whoText.setText(Html.fromHtml(getString(R.string.whoText)));
        howText.setText(Html.fromHtml(getString(R.string.howText)));
        padding.setText(Html.fromHtml(getString(R.string.paragraph_padding)));


        return aboutusFrag;
    }

}
