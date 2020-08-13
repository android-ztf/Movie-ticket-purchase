// Generated code from Butter Knife. Do not modify!
package com.bw.movie.view.activity;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.bw.movie.R;
import com.google.android.material.tabs.TabLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CinemaInfoActivity_ViewBinding implements Unbinder {
  private CinemaInfoActivity target;

  private View view7f08007b;

  private View view7f0800b3;

  private View view7f08028b;

  private View view7f080240;

  @UiThread
  public CinemaInfoActivity_ViewBinding(CinemaInfoActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CinemaInfoActivity_ViewBinding(final CinemaInfoActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.but_back_cinemainfo, "field 'butBackCinemainfo' and method 'onViewClicked'");
    target.butBackCinemainfo = Utils.castView(view, R.id.but_back_cinemainfo, "field 'butBackCinemainfo'", Button.class);
    view7f08007b = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvCinfoName = Utils.findRequiredViewAsType(source, R.id.tv_cinfo_name, "field 'tvCinfoName'", TextView.class);
    view = Utils.findRequiredView(source, R.id.cb_cinfo_guanzhu, "field 'cb_cinfo_guanzhu' and method 'onViewClicked'");
    target.cb_cinfo_guanzhu = Utils.castView(view, R.id.cb_cinfo_guanzhu, "field 'cb_cinfo_guanzhu'", CheckBox.class);
    view7f0800b3 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tlCinfo = Utils.findRequiredViewAsType(source, R.id.tl_cinfo, "field 'tlCinfo'", TabLayout.class);
    target.vpCinfo = Utils.findRequiredViewAsType(source, R.id.vp_cinfo, "field 'vpCinfo'", ViewPager.class);
    view = Utils.findRequiredView(source, R.id.tv_movielist, "field 'tvMovielist' and method 'onViewClicked'");
    target.tvMovielist = Utils.castView(view, R.id.tv_movielist, "field 'tvMovielist'", TextView.class);
    view7f08028b = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_cinfo_goto, "field 'tvCinfoGoto' and method 'onViewClicked'");
    target.tvCinfoGoto = Utils.castView(view, R.id.tv_cinfo_goto, "field 'tvCinfoGoto'", TextView.class);
    view7f080240 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.rlCinfoLable = Utils.findRequiredViewAsType(source, R.id.rl_cinfo_lable, "field 'rlCinfoLable'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CinemaInfoActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.butBackCinemainfo = null;
    target.tvCinfoName = null;
    target.cb_cinfo_guanzhu = null;
    target.tlCinfo = null;
    target.vpCinfo = null;
    target.tvMovielist = null;
    target.tvCinfoGoto = null;
    target.rlCinfoLable = null;

    view7f08007b.setOnClickListener(null);
    view7f08007b = null;
    view7f0800b3.setOnClickListener(null);
    view7f0800b3 = null;
    view7f08028b.setOnClickListener(null);
    view7f08028b = null;
    view7f080240.setOnClickListener(null);
    view7f080240 = null;
  }
}
