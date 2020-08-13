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

public class UserSetActivity_ViewBinding implements Unbinder {
  private UserSetActivity target;

  private View view7f080082;

  private View view7f08008f;

  private View view7f08009e;

  private View view7f0800a2;

  private View view7f0800a5;

  @UiThread
  public UserSetActivity_ViewBinding(UserSetActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public UserSetActivity_ViewBinding(final UserSetActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.but_back_mineset, "field 'butBackMineset' and method 'onViewClicked'");
    target.butBackMineset = Utils.castView(view, R.id.but_back_mineset, "field 'butBackMineset'", Button.class);
    view7f080082 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.but_clear_mineset, "field 'butClearMineset' and method 'onViewClicked'");
    target.butClearMineset = Utils.castView(view, R.id.but_clear_mineset, "field 'butClearMineset'", Button.class);
    view7f08008f = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.but_newversion_mineset, "field 'butNewversionMineset' and method 'onViewClicked'");
    target.butNewversionMineset = Utils.castView(view, R.id.but_newversion_mineset, "field 'butNewversionMineset'", Button.class);
    view7f08009e = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.but_pwd_mineset, "field 'butPwdMineset' and method 'onViewClicked'");
    target.butPwdMineset = Utils.castView(view, R.id.but_pwd_mineset, "field 'butPwdMineset'", Button.class);
    view7f0800a2 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.but_relogin_mineset, "field 'butReloginMineset' and method 'onViewClicked'");
    target.butReloginMineset = Utils.castView(view, R.id.but_relogin_mineset, "field 'butReloginMineset'", Button.class);
    view7f0800a5 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvClearsizeMineset = Utils.findRequiredViewAsType(source, R.id.tv_clearsize_mineset, "field 'tvClearsizeMineset'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    UserSetActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.butBackMineset = null;
    target.butClearMineset = null;
    target.butNewversionMineset = null;
    target.butPwdMineset = null;
    target.butReloginMineset = null;
    target.tvClearsizeMineset = null;

    view7f080082.setOnClickListener(null);
    view7f080082 = null;
    view7f08008f.setOnClickListener(null);
    view7f08008f = null;
    view7f08009e.setOnClickListener(null);
    view7f08009e = null;
    view7f0800a2.setOnClickListener(null);
    view7f0800a2 = null;
    view7f0800a5.setOnClickListener(null);
    view7f0800a5 = null;
  }
}
