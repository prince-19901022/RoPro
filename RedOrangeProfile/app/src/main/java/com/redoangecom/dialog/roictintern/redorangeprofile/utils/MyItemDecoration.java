package com.redoangecom.dialog.roictintern.redorangeprofile.utils;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Nutrino on 12/10/2016.
 */

public class MyItemDecoration extends RecyclerView.ItemDecoration{
    private int leftSpace;
    private int rightSpace;
    private int bottomSpace;

    public MyItemDecoration(int leftSpace, int rightSpace, int bottomSpace) {
        this.leftSpace = leftSpace;
        this.rightSpace = rightSpace;
        this.bottomSpace = bottomSpace;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        outRect.left = leftSpace;
        outRect.right = rightSpace;

        if(parent.getChildAdapterPosition(view) != parent.getAdapter().getItemCount() - 1){
            outRect.bottom = bottomSpace;
        }
    }
}
