package com.redoangecom.dialog.roictintern.redorangeprofile.utils;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * Created by roictintern on 14-Dec-16.
 */

public class SpacesItemDecoration extends RecyclerView.ItemDecoration {

    private int verticalSpace;
    private int horizontalSpace;
    private int ROW_SPAN;

    public SpacesItemDecoration(int verticalSpace, int horizontalSpace , int row_span , Context context) {
        this.verticalSpace = dpToPx(context,verticalSpace);
        this.horizontalSpace = dpToPx(context, horizontalSpace);
        ROW_SPAN = row_span;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.top = verticalSpace;
        outRect.left = horizontalSpace;
        outRect.right = horizontalSpace;
        outRect.bottom = verticalSpace;

        // Add top margin only for the first row to avoid double space between items
        if(parent.getChildAdapterPosition(view)% ROW_SPAN <= ROW_SPAN) {
            outRect.top = verticalSpace * 2;
        } else if(parent.getAdapter().getItemCount()%
                parent.getChildAdapterPosition(view)<ROW_SPAN) {
            outRect.bottom = verticalSpace *2;
        }
    }

    private  int dpToPx(Context context, int dp) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int px = Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        return px;
    }
}
