// Generated code from Butter Knife. Do not modify!
package com.bw.movie.view.activity;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SlidingDrawer;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.bw.movie.R;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.tabs.TabLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DetailMovieActivity_ViewBinding implements Unbinder {
  private DetailMovieActivity target;

  private View view7f080080;

  private View view7f0800b5;

  private View view7f0800ac;

  private View view7f08008c;

  @UiThread
  public DetailMovieActivity_ViewBinding(DetailMovieActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DetailMovieActivity_ViewBinding(final DetailMovieActivity target, View source) {
    this.target = target;

    View view;
    target.sdvDetailPic = Utils.findRequiredViewAsType(source, R.id.sdv_detail_pic, "field 'sdvDetailPic'", SimpleDraweeView.class);
    view = Utils.findRequiredView(source, R.id.but_back_loign, "field 'butBackLoign' and method 'onViewClicked'");
    target.butBackLoign = Utils.castView(view, R.id.but_back_loign, "field 'butBackLoign'", Button.class);
    view7f080080 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvDetailScore = Utils.findRequiredViewAsType(source, R.id.tv_detail_score, "field 'tvDetailScore'", TextView.class);
    target.tvDetailComNum = Utils.findRequiredViewAsType(source, R.id.tv_detail_com_num, "field 'tvDetailComNum'", TextView.class);
    target.tvDetailName = Utils.findRequiredViewAsType(source, R.id.tv_detail_name, "field 'tvDetailName'", TextView.class);
    target.tvDetailName2 = Utils.findRequiredViewAsType(source, R.id.tv_detail_name2, "field 'tvDetailName2'", TextView.class);
    target.tvDetailType = Utils.findRequiredViewAsType(source, R.id.tv_detail_type, "field 'tvDetailType'", TextView.class);
    target.tvDetailTime = Utils.findRequiredViewAsType(source, R.id.tv_detail_time, "field 'tvDetailTime'", TextView.class);
    target.tvDetailDate = Utils.findRequiredViewAsType(source, R.id.tv_detail_date, "field 'tvDetailDate'", TextView.class);
    target.tvDetailPlace = Utils.findRequiredViewAsType(source, R.id.tv_detail_place, "field 'tvDetailPlace'", TextView.class);
    target.Image = Utils.findRequiredViewAsType(source, R.id.Image, "field 'Image'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.cb_detail_guanzhu, "field 'cbDetailGuanzhu' and method 'onViewClicked'");
    target.cbDetailGuanzhu = Utils.castView(view, R.id.cb_detail_guanzhu, "field 'cbDetailGuanzhu'", CheckBox.class);
    view7f0800b5 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.layout1 = Utils.findRequiredViewAsType(source, R.id.layout1, "field 'layout1'", RelativeLayout.class);
    target.tlDetaiXx = Utils.findRequiredViewAsType(source, R.id.tl_detai_xx, "field 'tlDetaiXx'", TabLayout.class);
    target.myView = Utils.findRequiredViewAsType(source, R.id.myView, "field 'myView'", RelativeLayout.class);
    target.SlidingDrawer = Utils.findRequiredViewAsType(source, R.id.SlidingDrawer, "field 'SlidingDrawer'", SlidingDrawer.class);
    view = Utils.findRequiredView(source, R.id.but_writeMovieComment, "field 'butWriteMovieComment' and method 'onViewClicked'");
    target.butWriteMovieComment = Utils.castView(view, R.id.but_writeMovieComment, "field 'butWriteMovieComment'", Button.class);
    view7f0800ac = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.but_buyMovieTickets, "field 'butBuyMovieTickets' and method 'onViewClicked'");
    target.butBuyMovieTickets = Utils.castView(view, R.id.but_buyMovieTickets, "field 'butBuyMovieTickets'", Button.class);
    view7f08008c = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.vpDetail = Utils.findRequiredViewAsType(source, R.id.vp_detail, "field 'vpDetail'", ViewPager.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DetailMovieActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.sdvDetailPic = null;
    target.butBackLoign = null;
    target.tvDetailScore = null;
    target.tvDetailComNum = null;
    target.tvDetailName = null;
    target.tvDetailName2 = null;
    target.tvDetailType = null;
    target.tvDetailTime = null;
    target.tvDetailDate = null;
    target.tvDetailPlace = null;
    target.Image = null;
    target.cbDetailGuanzhu = null;
    target.layout1 = null;
    target.tlDetaiXx = null;
    target.myView = null;
    target.SlidingDrawer = null;
    target.butWriteMovieComment = null;
    target.butBuyMovieTickets = null;
    target.vpDetail = null;

    view7f080080.setOnClickListener(null);
    view7f080080 = null;
    view7f0800b5.setOnClickListener(null);
    view7f0800b5 = null;
    view7f0800ac.setOnClickListener(null);
    view7f0800ac = null;
    view7f08008c.setOnClickListener(null);
    view7f08008c = null;
  }
}
