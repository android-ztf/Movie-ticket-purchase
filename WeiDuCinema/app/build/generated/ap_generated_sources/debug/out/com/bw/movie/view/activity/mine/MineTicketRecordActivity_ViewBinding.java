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

public class MineTicketRecordActivity_ViewBinding implements Unbinder {
  private MineTicketRecordActivity target;

  private View view7f080086;

  @UiThread
  public MineTicketRecordActivity_ViewBinding(MineTicketRecordActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MineTicketRecordActivity_ViewBinding(final MineTicketRecordActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.but_back_record, "field 'butBackRecord' and method 'onViewClicked'");
    target.butBackRecord = Utils.castView(view, R.id.but_back_record, "field 'butBackRecord'", Button.class);
    view7f080086 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    target.tlRecordMine = Utils.findRequiredViewAsType(source, R.id.tl_record_mine, "field 'tlRecordMine'", TabLayout.class);
    target.vpRecordMine = Utils.findRequiredViewAsType(source, R.id.vp_record_mine, "field 'vpRecordMine'", ViewPager.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MineTicketRecordActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.butBackRecord = null;
    target.tlRecordMine = null;
    target.vpRecordMine = null;

    view7f080086.setOnClickListener(null);
    view7f080086 = null;
  }
}
