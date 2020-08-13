// Generated code from Butter Knife. Do not modify!
package com.bw.movie.view.activity;

import android.view.View;
import android.widget.Button;
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

public class CinemaMovieListActivity_ViewBinding implements Unbinder {
  private CinemaMovieListActivity target;

  private View view7f080085;

  @UiThread
  public CinemaMovieListActivity_ViewBinding(CinemaMovieListActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CinemaMovieListActivity_ViewBinding(final CinemaMovieListActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.but_back_movielist, "field 'butBackMovielist' and method 'onViewClicked'");
    target.butBackMovielist = Utils.castView(view, R.id.but_back_movielist, "field 'butBackMovielist'", Button.class);
    view7f080085 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    target.tlMovielist = Utils.findRequiredViewAsType(source, R.id.tl_movielist, "field 'tlMovielist'", TabLayout.class);
    target.vpMovielist = Utils.findRequiredViewAsType(source, R.id.vp_movielist, "field 'vpMovielist'", ViewPager.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CinemaMovieListActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.butBackMovielist = null;
    target.tlMovielist = null;
    target.vpMovielist = null;

    view7f080085.setOnClickListener(null);
    view7f080085 = null;
  }
}
