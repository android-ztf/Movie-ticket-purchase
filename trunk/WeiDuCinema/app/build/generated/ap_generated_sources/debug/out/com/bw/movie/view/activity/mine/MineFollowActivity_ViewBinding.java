// Generated code from Butter Knife. Do not modify!
package com.bw.movie.view.activity.mine;

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

public class MineFollowActivity_ViewBinding implements Unbinder {
  private MineFollowActivity target;

  private View view7f080081;

  @UiThread
  public MineFollowActivity_ViewBinding(MineFollowActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MineFollowActivity_ViewBinding(final MineFollowActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.but_back_minefollow, "field 'butBackMinefollow' and method 'onViewClicked'");
    target.butBackMinefollow = Utils.castView(view, R.id.but_back_minefollow, "field 'butBackMinefollow'", Button.class);
    view7f080081 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    target.tlMinefollow = Utils.findRequiredViewAsType(source, R.id.tl_minefollow, "field 'tlMinefollow'", TabLayout.class);
    target.vpMinefollow = Utils.findRequiredViewAsType(source, R.id.vp_minefollow, "field 'vpMinefollow'", ViewPager.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MineFollowActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.butBackMinefollow = null;
    target.tlMinefollow = null;
    target.vpMinefollow = null;

    view7f080081.setOnClickListener(null);
    view7f080081 = null;
  }
}
