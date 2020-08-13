// Generated code from Butter Knife. Do not modify!
package com.bw.movie.view.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.bw.movie.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RegisterActivity_ViewBinding implements Unbinder {
  private RegisterActivity target;

  private View view7f0800aa;

  private View view7f08026f;

  private View view7f0800a4;

  private View view7f080077;

  @UiThread
  public RegisterActivity_ViewBinding(RegisterActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public RegisterActivity_ViewBinding(final RegisterActivity target, View source) {
    this.target = target;

    View view;
    target.etNickNameRg = Utils.findRequiredViewAsType(source, R.id.et_nickName_rg, "field 'etNickNameRg'", EditText.class);
    target.etEmailRg = Utils.findRequiredViewAsType(source, R.id.et_email_rg, "field 'etEmailRg'", EditText.class);
    target.etPwdRg = Utils.findRequiredViewAsType(source, R.id.et_pwd_rg, "field 'etPwdRg'", EditText.class);
    target.etAuthCodeRg = Utils.findRequiredViewAsType(source, R.id.et_authCode_rg, "field 'etAuthCodeRg'", EditText.class);
    view = Utils.findRequiredView(source, R.id.but_setPwd_rg, "field 'butSetPwdRg' and method 'onViewClicked'");
    target.butSetPwdRg = Utils.castView(view, R.id.but_setPwd_rg, "field 'butSetPwdRg'", Button.class);
    view7f0800aa = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_login_rg, "field 'tvLoginRg' and method 'onViewClicked'");
    target.tvLoginRg = Utils.castView(view, R.id.tv_login_rg, "field 'tvLoginRg'", TextView.class);
    view7f08026f = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.but_register_rg, "field 'butRegisterRg' and method 'onViewClicked'");
    target.butRegisterRg = Utils.castView(view, R.id.but_register_rg, "field 'butRegisterRg'", Button.class);
    view7f0800a4 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.but_back, "field 'butBack' and method 'onViewClicked'");
    target.butBack = Utils.castView(view, R.id.but_back, "field 'butBack'", Button.class);
    view7f080077 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.llIdRg = Utils.findRequiredViewAsType(source, R.id.ll_id_rg, "field 'llIdRg'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RegisterActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.etNickNameRg = null;
    target.etEmailRg = null;
    target.etPwdRg = null;
    target.etAuthCodeRg = null;
    target.butSetPwdRg = null;
    target.tvLoginRg = null;
    target.butRegisterRg = null;
    target.butBack = null;
    target.llIdRg = null;

    view7f0800aa.setOnClickListener(null);
    view7f0800aa = null;
    view7f08026f.setOnClickListener(null);
    view7f08026f = null;
    view7f0800a4.setOnClickListener(null);
    view7f0800a4 = null;
    view7f080077.setOnClickListener(null);
    view7f080077 = null;
  }
}
