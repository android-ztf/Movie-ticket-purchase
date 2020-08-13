// Generated code from Butter Knife. Do not modify!
package com.bw.movie.view.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.bw.movie.R;
import com.facebook.drawee.view.SimpleDraweeView;
import com.stx.xhb.xbanner.XBanner;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MovieFragment_ViewBinding implements Unbinder {
  private MovieFragment target;

  private View view7f08026b;

  private View view7f080130;

  private View view7f08029a;

  private View view7f080244;

  private View view7f08026a;

  private View view7f08008b;

  private View view7f0801a0;

  @UiThread
  public MovieFragment_ViewBinding(final MovieFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.tv_location, "field 'tvLocation' and method 'onViewClicked'");
    target.tvLocation = Utils.castView(view, R.id.tv_location, "field 'tvLocation'", TextView.class);
    view7f08026b = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.iv_seek, "field 'ivSeek' and method 'onViewClicked'");
    target.ivSeek = Utils.castView(view, R.id.iv_seek, "field 'ivSeek'", ImageView.class);
    view7f080130 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.xbId = Utils.findRequiredViewAsType(source, R.id.xb_id, "field 'xbId'", XBanner.class);
    target.tvLocationPicNum = Utils.findRequiredViewAsType(source, R.id.tv_location_pic_num, "field 'tvLocationPicNum'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_release_more, "field 'tvReleaseMore' and method 'onViewClicked'");
    target.tvReleaseMore = Utils.castView(view, R.id.tv_release_more, "field 'tvReleaseMore'", TextView.class);
    view7f08029a = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.rvRelease = Utils.findRequiredViewAsType(source, R.id.rv_release, "field 'rvRelease'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.tv_coming_more, "field 'tvComingMore' and method 'onViewClicked'");
    target.tvComingMore = Utils.castView(view, R.id.tv_coming_more, "field 'tvComingMore'", TextView.class);
    view7f080244 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.rvComing = Utils.findRequiredViewAsType(source, R.id.rv_coming, "field 'rvComing'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.tv_hot_more, "field 'tvHotMore' and method 'onViewClicked'");
    target.tvHotMore = Utils.castView(view, R.id.tv_hot_more, "field 'tvHotMore'", TextView.class);
    view7f08026a = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.rvHot = Utils.findRequiredViewAsType(source, R.id.rv_hot, "field 'rvHot'", RecyclerView.class);
    target.sdvBig = Utils.findRequiredViewAsType(source, R.id.sdv_big, "field 'sdvBig'", SimpleDraweeView.class);
    target.tvMovie3Score = Utils.findRequiredViewAsType(source, R.id.tv_movie3_score, "field 'tvMovie3Score'", TextView.class);
    target.tvMovie3Name = Utils.findRequiredViewAsType(source, R.id.tv_movie3_name, "field 'tvMovie3Name'", TextView.class);
    view = Utils.findRequiredView(source, R.id.but_big, "field 'butBig' and method 'onViewClicked'");
    target.butBig = Utils.castView(view, R.id.but_big, "field 'butBig'", Button.class);
    view7f08008b = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.sumnumTv = Utils.findRequiredViewAsType(source, R.id.sumnum_tv, "field 'sumnumTv'", TextView.class);
    view = Utils.findRequiredView(source, R.id.rl_big, "field 'rlBig' and method 'onViewClicked'");
    target.rlBig = Utils.castView(view, R.id.rl_big, "field 'rlBig'", RelativeLayout.class);
    view7f0801a0 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.srlMovie = Utils.findRequiredViewAsType(source, R.id.srl_movie, "field 'srlMovie'", SwipeRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MovieFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvLocation = null;
    target.ivSeek = null;
    target.xbId = null;
    target.tvLocationPicNum = null;
    target.tvReleaseMore = null;
    target.rvRelease = null;
    target.tvComingMore = null;
    target.rvComing = null;
    target.tvHotMore = null;
    target.rvHot = null;
    target.sdvBig = null;
    target.tvMovie3Score = null;
    target.tvMovie3Name = null;
    target.butBig = null;
    target.sumnumTv = null;
    target.rlBig = null;
    target.srlMovie = null;

    view7f08026b.setOnClickListener(null);
    view7f08026b = null;
    view7f080130.setOnClickListener(null);
    view7f080130 = null;
    view7f08029a.setOnClickListener(null);
    view7f08029a = null;
    view7f080244.setOnClickListener(null);
    view7f080244 = null;
    view7f08026a.setOnClickListener(null);
    view7f08026a = null;
    view7f08008b.setOnClickListener(null);
    view7f08008b = null;
    view7f0801a0.setOnClickListener(null);
    view7f0801a0 = null;
  }
}
