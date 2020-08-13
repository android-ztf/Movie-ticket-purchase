// Generated code from Butter Knife. Do not modify!
package com.bw.movie.view.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.bw.movie.R;
import com.google.android.material.tabs.TabLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CinemaFragment_ViewBinding implements Unbinder {
  private CinemaFragment target;

  private View view7f080131;

  @UiThread
  public CinemaFragment_ViewBinding(final CinemaFragment target, View source) {
    this.target = target;

    View view;
    target.tvLocationCinema = Utils.findRequiredViewAsType(source, R.id.tv_location_cinema, "field 'tvLocationCinema'", TextView.class);
    view = Utils.findRequiredView(source, R.id.iv_seek_cinema, "field 'ivSeekCinema' and method 'onViewClicked'");
    target.ivSeekCinema = Utils.castView(view, R.id.iv_seek_cinema, "field 'ivSeekCinema'", ImageView.class);
    view7f080131 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    target.tlCinema = Utils.findRequiredViewAsType(source, R.id.tl_cinema, "field 'tlCinema'", TabLayout.class);
    target.vpCinema = Utils.findRequiredViewAsType(source, R.id.vp_cinema, "field 'vpCinema'", ViewPager.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CinemaFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvLocationCinema = null;
    target.ivSeekCinema = null;
    target.tlCinema = null;
    target.vpCinema = null;

    view7f080131.setOnClickListener(null);
    view7f080131 = null;
  }
}
