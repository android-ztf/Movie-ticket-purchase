// Generated code from Butter Knife. Do not modify!
package com.bw.movie.view.fragment.cinema;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.bw.movie.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CinemaDetailFragment_ViewBinding implements Unbinder {
  private CinemaDetailFragment target;

  private View view7f0802a7;

  @UiThread
  public CinemaDetailFragment_ViewBinding(final CinemaDetailFragment target, View source) {
    this.target = target;

    View view;
    target.tvLocationCinemadtail = Utils.findRequiredViewAsType(source, R.id.tv_location_cinemadtail, "field 'tvLocationCinemadtail'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_tel_cinemadtail, "field 'tvTelCinemadtail' and method 'onViewClicked'");
    target.tvTelCinemadtail = Utils.castView(view, R.id.tv_tel_cinemadtail, "field 'tvTelCinemadtail'", TextView.class);
    view7f0802a7 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    target.tvVehiclerouteCinemadatil = Utils.findRequiredViewAsType(source, R.id.tv_vehicleroute_cinemadatil, "field 'tvVehiclerouteCinemadatil'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CinemaDetailFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvLocationCinemadtail = null;
    target.tvTelCinemadtail = null;
    target.tvVehiclerouteCinemadatil = null;

    view7f0802a7.setOnClickListener(null);
    view7f0802a7 = null;
  }
}
