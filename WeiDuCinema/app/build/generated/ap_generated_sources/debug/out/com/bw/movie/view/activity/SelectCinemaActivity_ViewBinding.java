// Generated code from Butter Knife. Do not modify!
package com.bw.movie.view.activity;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.bw.movie.R;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SelectCinemaActivity_ViewBinding implements Unbinder {
  private SelectCinemaActivity target;

  private View view7f08007a;

  private View view7f080138;

  @UiThread
  public SelectCinemaActivity_ViewBinding(SelectCinemaActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SelectCinemaActivity_ViewBinding(final SelectCinemaActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.but_back_buy, "field 'butBackBuy' and method 'onViewClicked'");
    target.butBackBuy = Utils.castView(view, R.id.but_back_buy, "field 'butBackBuy'", Button.class);
    view7f08007a = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.jcvps_ygp_buy, "field 'jcvpsYgpBuy' and method 'onViewClicked'");
    target.jcvpsYgpBuy = Utils.castView(view, R.id.jcvps_ygp_buy, "field 'jcvpsYgpBuy'", JCVideoPlayerStandard.class);
    view7f080138 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvNameBuy = Utils.findRequiredViewAsType(source, R.id.tv_name_buy, "field 'tvNameBuy'", TextView.class);
    target.tvTimeBuy = Utils.findRequiredViewAsType(source, R.id.tv_time_buy, "field 'tvTimeBuy'", TextView.class);
    target.tvScoreBuy = Utils.findRequiredViewAsType(source, R.id.tv_score_buy, "field 'tvScoreBuy'", TextView.class);
    target.tvDaoBuy = Utils.findRequiredViewAsType(source, R.id.tv_dao_buy, "field 'tvDaoBuy'", TextView.class);
    target.xxLl = Utils.findRequiredViewAsType(source, R.id.xx_ll, "field 'xxLl'", LinearLayout.class);
    target.rvCinemaBuy = Utils.findRequiredViewAsType(source, R.id.rv_cinema_buy, "field 'rvCinemaBuy'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SelectCinemaActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.butBackBuy = null;
    target.jcvpsYgpBuy = null;
    target.tvNameBuy = null;
    target.tvTimeBuy = null;
    target.tvScoreBuy = null;
    target.tvDaoBuy = null;
    target.xxLl = null;
    target.rvCinemaBuy = null;

    view7f08007a.setOnClickListener(null);
    view7f08007a = null;
    view7f080138.setOnClickListener(null);
    view7f080138 = null;
  }
}
