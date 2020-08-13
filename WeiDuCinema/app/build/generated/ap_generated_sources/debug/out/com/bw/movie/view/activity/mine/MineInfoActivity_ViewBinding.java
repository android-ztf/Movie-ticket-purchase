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

public class MineInfoActivity_ViewBinding implements Unbinder {
  private MineInfoActivity target;

  private View view7f080080;

  private View view7f0801d9;

  private View view7f08023a;

  private View view7f0802a8;

  @UiThread
  public MineInfoActivity_ViewBinding(MineInfoActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MineInfoActivity_ViewBinding(final MineInfoActivity target, View source) {
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
    view = Utils.findRequiredView(source, R.id.sdv_pic_my, "field 'sdvPicMy' and method 'onViewClicked'");
    target.sdvPicMy = Utils.castView(view, R.id.sdv_pic_my, "field 'sdvPicMy'", SimpleDraweeView.class);
    view7f0801d9 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvNameMy = Utils.findRequiredViewAsType(source, R.id.tv_name_my, "field 'tvNameMy'", TextView.class);
    target.tvSexMy = Utils.findRequiredViewAsType(source, R.id.tv_sex_my, "field 'tvSexMy'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_birth_my, "field 'tvBirthMy' and method 'onViewClicked'");
    target.tvBirthMy = Utils.castView(view, R.id.tv_birth_my, "field 'tvBirthMy'", TextView.class);
    view7f08023a = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_tel_my, "field 'tvTelMy' and method 'onViewClicked'");
    target.tvTelMy = Utils.castView(view, R.id.tv_tel_my, "field 'tvTelMy'", TextView.class);
    view7f0802a8 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvEmailMy = Utils.findRequiredViewAsType(source, R.id.tv_email_my, "field 'tvEmailMy'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MineInfoActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.butBackLoign = null;
    target.sdvPicMy = null;
    target.tvNameMy = null;
    target.tvSexMy = null;
    target.tvBirthMy = null;
    target.tvTelMy = null;
    target.tvEmailMy = null;

    view7f080080.setOnClickListener(null);
    view7f080080 = null;
    view7f0801d9.setOnClickListener(null);
    view7f0801d9 = null;
    view7f08023a.setOnClickListener(null);
    view7f08023a = null;
    view7f0802a8.setOnClickListener(null);
    view7f0802a8 = null;
  }
}
