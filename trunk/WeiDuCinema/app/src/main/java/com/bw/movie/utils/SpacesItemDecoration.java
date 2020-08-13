package com.bw.movie.utils;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-6-21
 * INTRODUCE：设置item间距$
 */
//设置recyclerview item间距
public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    private int space;

    public SpacesItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.top = space;
        outRect.bottom = space;
        outRect.left = space;
        outRect.right = space;
    }
}
