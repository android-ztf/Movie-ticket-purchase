// Generated code from Butter Knife. Do not modify!
package com.bw.movie.view.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bw.movie.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class WelcomeActivity_ViewBinding implements Unbinder {
  private WelcomeActivity target;

  @UiThread
  public WelcomeActivity_ViewBinding(WelcomeActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public WelcomeActivity_ViewBinding(WelcomeActivity target, View source) {
    this.target = target;

    target.ivYdy = Utils.findRequiredViewAsType(source, R.id.iv_ydy, "field 'ivYdy'", ImageView.class);
    target.tvDjs = Utils.findRequiredViewAsType(source, R.id.tv_djs, "field 'tvDjs'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    WelcomeActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ivYdy = null;
    target.tvDjs = null;
  }
}
