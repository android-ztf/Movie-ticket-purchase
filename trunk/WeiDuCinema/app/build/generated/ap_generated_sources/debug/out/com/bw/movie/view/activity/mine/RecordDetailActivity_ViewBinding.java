// Generated code from Butter Knife. Do not modify!
package com.bw.movie.view.activity.mine;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.bw.movie.R;
import com.facebook.drawee.view.SimpleDraweeView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RecordDetailActivity_ViewBinding implements Unbinder {
  private RecordDetailActivity target;

  private View view7f080080;

  @UiThread
  public RecordDetailActivity_ViewBinding(RecordDetailActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public RecordDetailActivity_ViewBinding(final RecordDetailActivity target, View source) {
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
    target.sdvDetailPicRecord = Utils.findRequiredViewAsType(source, R.id.sdv_detail_pic_record, "field 'sdvDetailPicRecord'", SimpleDraweeView.class);
    target.tvNameRecord = Utils.findRequiredViewAsType(source, R.id.tv_name_record, "field 'tvNameRecord'", TextView.class);
    target.tvDetailCinemaNameRecord = Utils.findRequiredViewAsType(source, R.id.tv_detail_cinema_name_record, "field 'tvDetailCinemaNameRecord'", TextView.class);
    target.tvDetailHallRecord = Utils.findRequiredViewAsType(source, R.id.tv_detail_hall_record, "field 'tvDetailHallRecord'", TextView.class);
    target.tvTicketNumRecord = Utils.findRequiredViewAsType(source, R.id.tv_ticket_num_record, "field 'tvTicketNumRecord'", TextView.class);
    target.tvSeatRecord = Utils.findRequiredViewAsType(source, R.id.tv_seat_record, "field 'tvSeatRecord'", TextView.class);
    target.tvDetailTimeRecord = Utils.findRequiredViewAsType(source, R.id.tv_detail_time_record, "field 'tvDetailTimeRecord'", TextView.class);
    target.tvOrderRecord = Utils.findRequiredViewAsType(source, R.id.tv_order_record, "field 'tvOrderRecord'", TextView.class);
    target.tvDateRecord = Utils.findRequiredViewAsType(source, R.id.tv_date_record, "field 'tvDateRecord'", TextView.class);
    target.tvMoneyRecord = Utils.findRequiredViewAsType(source, R.id.tv_money_record, "field 'tvMoneyRecord'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RecordDetailActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.butBackLoign = null;
    target.sdvDetailPicRecord = null;
    target.tvNameRecord = null;
    target.tvDetailCinemaNameRecord = null;
    target.tvDetailHallRecord = null;
    target.tvTicketNumRecord = null;
    target.tvSeatRecord = null;
    target.tvDetailTimeRecord = null;
    target.tvOrderRecord = null;
    target.tvDateRecord = null;
    target.tvMoneyRecord = null;

    view7f080080.setOnClickListener(null);
    view7f080080 = null;
  }
}
