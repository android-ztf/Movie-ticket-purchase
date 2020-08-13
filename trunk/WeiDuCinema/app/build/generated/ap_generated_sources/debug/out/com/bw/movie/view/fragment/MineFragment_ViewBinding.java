// Generated code from Butter Knife. Do not modify!
package com.bw.movie.view.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.bw.movie.R;
import com.facebook.drawee.view.SimpleDraweeView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MineFragment_ViewBinding implements Unbinder {
  private MineFragment target;

  private View view7f0801d4;

  private View view7f0800ae;

  private View view7f080278;

  private View view7f080261;

  private View view7f080092;

  private View view7f080096;

  private View view7f080098;

  private View view7f08009a;

  private View view7f08009c;

  private View view7f080099;

  private View view7f080095;

  private View view7f08009b;

  private View view7f0802c4;

  @UiThread
  public MineFragment_ViewBinding(final MineFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.sdv_mine_pic, "field 'sdvMinePic' and method 'onViewClicked'");
    target.sdvMinePic = Utils.castView(view, R.id.sdv_mine_pic, "field 'sdvMinePic'", SimpleDraweeView.class);
    view7f0801d4 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.but_xinxi, "field 'butXinxi' and method 'onViewClicked'");
    target.butXinxi = Utils.castView(view, R.id.but_xinxi, "field 'butXinxi'", Button.class);
    view7f0800ae = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_mine_name, "field 'tvMineName' and method 'onViewClicked'");
    target.tvMineName = Utils.castView(view, R.id.tv_mine_name, "field 'tvMineName'", TextView.class);
    view7f080278 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.butMineMore = Utils.findRequiredViewAsType(source, R.id.but_mine_more, "field 'butMineMore'", Button.class);
    view = Utils.findRequiredView(source, R.id.tv_dyp, "field 'tvDyp' and method 'onViewClicked'");
    target.tvDyp = Utils.castView(view, R.id.tv_dyp, "field 'tvDyp'", TextView.class);
    view7f080261 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.but_dyp, "field 'butDyp' and method 'onViewClicked'");
    target.butDyp = Utils.castView(view, R.id.but_dyp, "field 'butDyp'", Button.class);
    view7f080092 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.but_mine_gz, "field 'butMineGz' and method 'onViewClicked'");
    target.butMineGz = Utils.castView(view, R.id.but_mine_gz, "field 'butMineGz'", Button.class);
    view7f080096 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.but_mine_oldmovie, "field 'butMineOldmovie' and method 'onViewClicked'");
    target.butMineOldmovie = Utils.castView(view, R.id.but_mine_oldmovie, "field 'butMineOldmovie'", Button.class);
    view7f080098 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.but_mine_sz, "field 'butMineSz' and method 'onViewClicked'");
    target.butMineSz = Utils.castView(view, R.id.but_mine_sz, "field 'butMineSz'", Button.class);
    view7f08009a = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.but_mine_yuyu, "field 'butMineYuyu' and method 'onViewClicked'");
    target.butMineYuyu = Utils.castView(view, R.id.but_mine_yuyu, "field 'butMineYuyu'", Button.class);
    view7f08009c = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.but_mine_pl, "field 'butMinePl' and method 'onViewClicked'");
    target.butMinePl = Utils.castView(view, R.id.but_mine_pl, "field 'butMinePl'", Button.class);
    view7f080099 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.but_mine_gopiao, "field 'butMineGopiao' and method 'onViewClicked'");
    target.butMineGopiao = Utils.castView(view, R.id.but_mine_gopiao, "field 'butMineGopiao'", Button.class);
    view7f080095 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.but_mine_yjian, "field 'butMineYjian' and method 'onViewClicked'");
    target.butMineYjian = Utils.castView(view, R.id.but_mine_yjian, "field 'butMineYjian'", Button.class);
    view7f08009b = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvUnreadNum = Utils.findRequiredViewAsType(source, R.id.tv_unread_num, "field 'tvUnreadNum'", TextView.class);
    target.srlMine = Utils.findRequiredViewAsType(source, R.id.srl_mine, "field 'srlMine'", SwipeRefreshLayout.class);
    target.svMine = Utils.findRequiredViewAsType(source, R.id.sv_mine, "field 'svMine'", ScrollView.class);
    view = Utils.findRequiredView(source, R.id.wd_rl, "method 'onViewClicked'");
    view7f0802c4 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    MineFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.sdvMinePic = null;
    target.butXinxi = null;
    target.tvMineName = null;
    target.butMineMore = null;
    target.tvDyp = null;
    target.butDyp = null;
    target.butMineGz = null;
    target.butMineOldmovie = null;
    target.butMineSz = null;
    target.butMineYuyu = null;
    target.butMinePl = null;
    target.butMineGopiao = null;
    target.butMineYjian = null;
    target.tvUnreadNum = null;
    target.srlMine = null;
    target.svMine = null;

    view7f0801d4.setOnClickListener(null);
    view7f0801d4 = null;
    view7f0800ae.setOnClickListener(null);
    view7f0800ae = null;
    view7f080278.setOnClickListener(null);
    view7f080278 = null;
    view7f080261.setOnClickListener(null);
    view7f080261 = null;
    view7f080092.setOnClickListener(null);
    view7f080092 = null;
    view7f080096.setOnClickListener(null);
    view7f080096 = null;
    view7f080098.setOnClickListener(null);
    view7f080098 = null;
    view7f08009a.setOnClickListener(null);
    view7f08009a = null;
    view7f08009c.setOnClickListener(null);
    view7f08009c = null;
    view7f080099.setOnClickListener(null);
    view7f080099 = null;
    view7f080095.setOnClickListener(null);
    view7f080095 = null;
    view7f08009b.setOnClickListener(null);
    view7f08009b = null;
    view7f0802c4.setOnClickListener(null);
    view7f0802c4 = null;
  }
}
