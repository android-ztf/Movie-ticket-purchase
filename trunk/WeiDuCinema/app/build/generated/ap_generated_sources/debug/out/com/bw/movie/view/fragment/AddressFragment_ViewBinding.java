// Generated code from Butter Knife. Do not modify!
package com.bw.movie.view.fragment;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bw.movie.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AddressFragment_ViewBinding implements Unbinder {
  private AddressFragment target;

  @UiThread
  public AddressFragment_ViewBinding(AddressFragment target, View source) {
    this.target = target;

    target.rlRegionAddress = Utils.findRequiredViewAsType(source, R.id.rl_region_address, "field 'rlRegionAddress'", RecyclerView.class);
    target.rlCinemaAddress = Utils.findRequiredViewAsType(source, R.id.rl_cinema_address, "field 'rlCinemaAddress'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AddressFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rlRegionAddress = null;
    target.rlCinemaAddress = null;
  }
}
