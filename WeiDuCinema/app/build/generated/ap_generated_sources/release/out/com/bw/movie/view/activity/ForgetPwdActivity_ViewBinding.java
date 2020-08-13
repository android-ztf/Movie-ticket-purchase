// Generated code from Butter Knife. Do not modify!
package com.bw.movie.view.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.bw.movie.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ForgetPwdActivity_ViewBinding implements Unbinder {
  private ForgetPwdActivity target;

  private View view7f08007f;

  private View view7f0800f1;

  private View view7f0800f2;

  private View view7f080094;

  @UiThread
  public ForgetPwdActivity_ViewBinding(ForgetPwdActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ForgetPwdActivity_ViewBinding(final ForgetPwdActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.but_back_forget, "field 'butBackForget' and method 'onViewClicked'");
    target.butBackForget = Utils.castView(view, R.id.but_back_forget, "field 'butBackForget'", Button.class);
    view7f08007f = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.etEmailFg = Utils.findRequiredViewAsType(source, R.id.et_email_fg, "field 'etEmailFg'", EditText.class);
    target.etOldpwdFg = Utils.findRequiredViewAsType(source, R.id.et_oldpwd_fg, "field 'etOldpwdFg'", EditText.class);
    target.sbProgress = Utils.findRequiredViewAsType(source, R.id.sb_progress, "field 'sbProgress'", SeekBar.class);
    view = Utils.findRequiredView(source, R.id.et_newpwd1_fg, "field 'etNewpwd1Fg' and method 'onViewClicked'");
    target.etNewpwd1Fg = Utils.castView(view, R.id.et_newpwd1_fg, "field 'etNewpwd1Fg'", EditText.class);
    view7f0800f1 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.et_newpwd2_fg, "field 'etNewpwd2Fg' and method 'onViewClicked'");
    target.etNewpwd2Fg = Utils.castView(view, R.id.et_newpwd2_fg, "field 'etNewpwd2Fg'", EditText.class);
    view7f0800f2 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.but_login_fg, "field 'butLoginFg' and method 'onViewClicked'");
    target.butLoginFg = Utils.castView(view, R.id.but_login_fg, "field 'butLoginFg'", Button.class);
    view7f080094 = view;
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
    ForgetPwdActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.butBackForget = null;
    target.etEmailFg = null;
    target.etOldpwdFg = null;
    target.sbProgress = null;
    target.etNewpwd1Fg = null;
    target.etNewpwd2Fg = null;
    target.butLoginFg = null;

    view7f08007f.setOnClickListener(null);
    view7f08007f = null;
    view7f0800f1.setOnClickListener(null);
    view7f0800f1 = null;
    view7f0800f2.setOnClickListener(null);
    view7f0800f2 = null;
    view7f080094.setOnClickListener(null);
    view7f080094 = null;
  }
}
