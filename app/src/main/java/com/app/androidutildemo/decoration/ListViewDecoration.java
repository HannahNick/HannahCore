package com.app.androidutildemo.decoration;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.app.androidutildemo.R;


/**
 * Created by duanlei on 2017/7/17.
 */

public class ListViewDecoration extends RecyclerView.ItemDecoration {

  private Drawable mDrawable;

  public ListViewDecoration(Activity activity) {
    mDrawable = activity.getResources().getDrawable(R.drawable.divider_recycler);
  }

  @Override
  public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
    final int left = parent.getPaddingLeft();
    final int right = parent.getWidth() - parent.getPaddingRight();

    final int childCount = parent.getChildCount();
    for (int i = 0; i < childCount - 1; i++) {
      final View child = parent.getChildAt(i);
      final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
      // 以下计算主要用来确定绘制的位置
      final int top = child.getBottom() + params.bottomMargin;
      final int bottom = top + mDrawable.getIntrinsicHeight();
      mDrawable.setBounds(left, top, right, bottom);
      mDrawable.draw(c);
    }
  }

  @Override
  public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
    outRect.set(0, 0, 0, mDrawable.getIntrinsicHeight());
  }
}
