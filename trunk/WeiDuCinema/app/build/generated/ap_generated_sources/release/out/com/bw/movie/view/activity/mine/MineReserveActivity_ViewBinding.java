// Generated code from Butter Knife. Do not modify!
package com.bw.movie.view.activity.mine;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.bw.movie.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MineReserveActivity_ViewBinding implements Unbinder {
  private MineReserveActivity target;

  private View view7f080087;

  @UiThread
  public MineReserveActivity_ViewBinding(MineReserveActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MineReserveActivity_ViewBinding(final MineReserveActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.but_back_reserve, "field 'butBackReserve' and method 'onViewClicked'");
    target.butBackReserve = Utils.castView(view, R.id.but_back_reserve, "field 'butBackReserve'", Button.class);
    view7f080087 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    target.rlReserve = Utils.findRequiredViewAsType(source, R.id.rl_reserve, "field 'rlReserve'", RecyclerView.class);
    target.ivNotfollow = Utils.findRequiredViewAsType(source, R.id.iv_notfollow, "field 'ivNotfollow'", ImageView.class);
    target.tvNnotfollow = Utils.findRequiredViewAsType(source, R.id.tv_nnotfollow, "field 'tvNnotfollow'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MineReserveActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.butBackReserve = null;
    target.rlReserve = null;
    target.ivNotfollow = null;
    target.tvNnotfollow = null;

    view7f080087.setOnClickListener(null);
    view7f080087 = null;
  }
}
