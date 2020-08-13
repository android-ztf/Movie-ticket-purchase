// Generated code from Butter Knife. Do not modify!
package com.bw.movie.view.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.bw.movie.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginActivity_ViewBinding implements Unbinder {
  private LoginActivity target;

  private View view7f0800a9;

  private View view7f080299;

  private View view7f080093;

  private View view7f080080;

  private View view7f0800ad;

  @UiThread
  public LoginActivity_ViewBinding(LoginActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LoginActivity_ViewBinding(final LoginActivity target, View source) {
    this.target = target;

    View view;
    target.etEmail = Utils.findRequiredViewAsType(source, R.id.et_email, "field 'etEmail'", EditText.class);
    target.etPwd = Utils.findRequiredViewAsType(source, R.id.et_pwd, "field 'etPwd'", EditText.class);
    view = Utils.findRequiredView(source, R.id.but_setPwd, "field 'butSetPwd' and method 'onViewClicked'");
    target.butSetPwd = Utils.castView(view, R.id.but_setPwd, "field 'butSetPwd'", Button.class);
    view7f0800a9 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_register, "field 'tvRegister' and method 'onViewClicked'");
    target.tvRegister = Utils.castView(view, R.id.tv_register, "field 'tvRegister'", TextView.class);
    view7f080299 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.but_login, "field 'butLogin' and method 'onViewClicked'");
    target.butLogin = Utils.castView(view, R.id.but_login, "field 'butLogin'", Button.class);
    view7f080093 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.but_back_loign, "field 'butBackLoign' and method 'onViewClicked'");
    target.butBackLoign = Utils.castView(view, R.id.but_back_loign, "field 'butBackLoign'", Button.class);
    view7f080080 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.but_wx, "field 'butWx' and method 'onViewClicked'");
    target.butWx = Utils.castView(view, R.id.but_wx, "field 'butWx'", ImageButton.class);
    view7f0800ad = view;
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
    LoginActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.etEmail = null;
    target.etPwd = null;
    target.butSetPwd = null;
    target.tvRegister = null;
    target.butLogin = null;
    target.butBackLoign = null;
    target.butWx = null;

    view7f0800a9.setOnClickListener(null);
    view7f0800a9 = null;
    view7f080299.setOnClickListener(null);
    view7f080299 = null;
    view7f080093.setOnClickListener(null);
    view7f080093 = null;
    view7f080080.setOnClickListener(null);
    view7f080080 = null;
    view7f0800ad.setOnClickListener(null);
    view7f0800ad = null;
  }
}
