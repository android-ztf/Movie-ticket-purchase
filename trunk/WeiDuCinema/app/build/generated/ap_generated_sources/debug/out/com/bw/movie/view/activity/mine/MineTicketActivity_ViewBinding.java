// Generated code from Butter Knife. Do not modify!
package com.bw.movie.view.activity.mine;

import android.view.View;
import android.widget.Button;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.bw.movie.R;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MineTicketActivity_ViewBinding implements Unbinder {
  private MineTicketActivity target;

  private View view7f080083;

  @UiThread
  public MineTicketActivity_ViewBinding(MineTicketActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MineTicketActivity_ViewBinding(final MineTicketActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.but_back_mineticket, "field 'butBackMineticket' and method 'onViewClicked'");
    target.butBackMineticket = Utils.castView(view, R.id.but_back_mineticket, "field 'butBackMineticket'", Button.class);
    view7f080083 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    target.xrlMineticket = Utils.findRequiredViewAsType(source, R.id.xrl_mineticket, "field 'xrlMineticket'", XRecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MineTicketActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.butBackMineticket = null;
    target.xrlMineticket = null;

    view7f080083.setOnClickListener(null);
    view7f080083 = null;
  }
}
