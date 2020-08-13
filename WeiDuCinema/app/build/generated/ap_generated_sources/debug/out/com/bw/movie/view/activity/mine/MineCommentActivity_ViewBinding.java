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

public class MineCommentActivity_ViewBinding implements Unbinder {
  private MineCommentActivity target;

  private View view7f080080;

  @UiThread
  public MineCommentActivity_ViewBinding(MineCommentActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MineCommentActivity_ViewBinding(final MineCommentActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.but_back_loign, "field 'butBackLoign' and method 'onViewClicked'");
    target.butBackLoign = Utils.castView(view, R.id.but_back_loign, "field 'butBackLoign'", Button.class);
    view7f080080 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    target.tlMineComment = Utils.findRequiredViewAsType(source, R.id.tl_mine_comment, "field 'tlMineComment'", TabLayout.class);
    target.vpMineComment = Utils.findRequiredViewAsType(source, R.id.vp_mine_comment, "field 'vpMineComment'", ViewPager.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MineCommentActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.butBackLoign = null;
    target.tlMineComment = null;
    target.vpMineComment = null;

    view7f080080.setOnClickListener(null);
    view7f080080 = null;
  }
}
