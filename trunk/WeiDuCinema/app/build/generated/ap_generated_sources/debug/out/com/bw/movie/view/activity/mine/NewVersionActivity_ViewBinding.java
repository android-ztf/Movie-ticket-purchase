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
import java.lang.IllegalStateException;
import java.lang.Override;

public class NewVersionActivity_ViewBinding implements Unbinder {
  private NewVersionActivity target;

  private View view7f080080;

  private View view7f08009f;

  @UiThread
  public NewVersionActivity_ViewBinding(NewVersionActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public NewVersionActivity_ViewBinding(final NewVersionActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.but_back_loign, "field 'butBackLoign' and method 'onViewClicked'");
    target.butBackLoign = Utils.castView(view, R.id.but_back_loign, "field 'butBackLoign'", Button.class);
    view7f080080 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.but_nwe_version, "field 'butNweVersion' and method 'onViewClicked'");
    target.butNweVersion = Utils.castView(view, R.id.but_nwe_version, "field 'butNweVersion'", Button.class);
    view7f08009f = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvNewName = Utils.findRequiredViewAsType(source, R.id.tv_new_name, "field 'tvNewName'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    NewVersionActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.butBackLoign = null;
    target.butNweVersion = null;
    target.tvNewName = null;

    view7f080080.setOnClickListener(null);
    view7f080080 = null;
    view7f08009f.setOnClickListener(null);
    view7f08009f = null;
  }
}
