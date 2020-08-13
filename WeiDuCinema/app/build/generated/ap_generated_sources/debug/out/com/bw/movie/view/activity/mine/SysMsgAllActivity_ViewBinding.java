// Generated code from Butter Knife. Do not modify!
package com.bw.movie.view.activity.mine;

import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.bw.movie.R;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SysMsgAllActivity_ViewBinding implements Unbinder {
  private SysMsgAllActivity target;

  private View view7f080080;

  @UiThread
  public SysMsgAllActivity_ViewBinding(SysMsgAllActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SysMsgAllActivity_ViewBinding(final SysMsgAllActivity target, View source) {
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
    target.xrlSysMsg = Utils.findRequiredViewAsType(source, R.id.xrl_sys_msg, "field 'xrlSysMsg'", XRecyclerView.class);
    target.rlNotFollow = Utils.findRequiredViewAsType(source, R.id.rl_not_follow, "field 'rlNotFollow'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SysMsgAllActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.butBackLoign = null;
    target.xrlSysMsg = null;
    target.rlNotFollow = null;

    view7f080080.setOnClickListener(null);
    view7f080080 = null;
  }
}
