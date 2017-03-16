package com.redoangecom.dialog.roictintern.redorangeprofile.fragments;


import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import com.redoangecom.dialog.roictintern.redorangeprofile.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private Handler handler;
    private Runnable runnable;
    private FragmentTransaction ft;
    private ArrayList<Fragment> sliders;
    private int ptr;

    private ImageView iv;
    private static final float ICT_ASPECT_RATIO = 0.7355f;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View homeView = inflater.inflate(R.layout.fragment_home, container, false);
        iv = (ImageView) homeView.findViewById(R.id.homeBg);
        Picasso.with(getActivity()).load("file:///android_asset/sliders/ict_potrait.jpg").into(iv);
        activateSlide();
        return homeView;
    }

    private void activateSlide(){

        ft = getFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.enter_from_left , R.anim.exit_to_right);

        sliders = new ArrayList<>();
        sliders.add(new Slide1());
        sliders.add(new Slide2());
        sliders.add(new Slide3());
        sliders.add(new Slide4());
        ptr = 0;

        ft.add(R.id.slideHolder , sliders.get(0)).commit();
        ptr = ptr + 1;
        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                ft = getFragmentManager().beginTransaction();

                if(ptr == 0){
                    ft.setCustomAnimations(R.anim.enter_from_left , R.anim.exit_to_right);
                }

                if(ptr == 1){
                    ft.setCustomAnimations(R.anim.enter_from_right , R.anim.exit_to_left);
                }

                if(ptr == 2){
                    ft.setCustomAnimations(R.anim.enter_from_top , R.anim.exit_to_bottom);
                }

                if(ptr == 3){
                    ft.setCustomAnimations(R.anim.enter_from_bottom , R.anim.exit_to_top);
                }

                ft.replace(R.id.slideHolder , sliders.get(ptr));
                ft.commitAllowingStateLoss();
                ptr = ptr + 1;
                ptr = ptr % 4;

                handler.postDelayed(runnable , 6000);
            }
        };

        handler.post(runnable);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        handler.removeCallbacks(runnable);
    }

    private void LoadImage(){

        ViewTreeObserver vto = iv.getViewTreeObserver();

        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {

                int h = iv.getHeight();
                int w = (int) Math.ceil(1118 * ICT_ASPECT_RATIO);

                h = Math.abs(h);
                w = Math.abs(w);

                Picasso.with(getActivity()).load("file:///android_asset/sliders/ict_potrait.jpg").resize(w , h).into(iv);

                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                    iv.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    iv.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            }
        });
    }
}
