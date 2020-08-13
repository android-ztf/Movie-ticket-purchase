// Generated code from Butter Knife. Do not modify!
package com.bw.movie.view.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.bw.movie.R;
import com.bw.movie.view.customview.SeatView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BuyTicketActivity_ViewBinding implements Unbinder {
  private BuyTicketActivity target;

  private View view7f080089;

  private View view7f08008e;

  @UiThread
  public BuyTicketActivity_ViewBinding(BuyTicketActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public BuyTicketActivity_ViewBinding(final BuyTicketActivity target, View source) {
    this.target = target;

    View view;
    target.seatview = Utils.findRequiredViewAsType(source, R.id.seatview, "field 'seatview'", SeatView.class);
    view = Utils.findRequiredView(source, R.id.but_back_ticket, "field 'butBackTicket' and method 'onViewClicked'");
    target.butBackTicket = Utils.castView(view, R.id.but_back_ticket, "field 'butBackTicket'", Button.class);
    view7f080089 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvNameTicket = Utils.findRequiredViewAsType(source, R.id.tv_name_ticket, "field 'tvNameTicket'", TextView.class);
    target.jcvpsYgpTicket = Utils.findRequiredViewAsType(source, R.id.jcvps_ygp_ticket, "field 'jcvpsYgpTicket'", JCVideoPlayerStandard.class);
    target.tvHalltimeXx = Utils.findRequiredViewAsType(source, R.id.tv_halltime_xx, "field 'tvHalltimeXx'", TextView.class);
    target.rvHallTicket = Utils.findRequiredViewAsType(source, R.id.rv_hall_ticket, "field 'rvHallTicket'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.but_buy_ticket, "field 'butBuyTicket' and method 'onViewClicked'");
    target.butBuyTicket = Utils.castView(view, R.id.but_buy_ticket, "field 'butBuyTicket'", Button.class);
    view7f08008e = view;
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
    BuyTicketActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.seatview = null;
    target.butBackTicket = null;
    target.tvNameTicket = null;
    target.jcvpsYgpTicket = null;
    target.tvHalltimeXx = null;
    target.rvHallTicket = null;
    target.butBuyTicket = null;

    view7f080089.setOnClickListener(null);
    view7f080089 = null;
    view7f08008e.setOnClickListener(null);
    view7f08008e = null;
  }
}
