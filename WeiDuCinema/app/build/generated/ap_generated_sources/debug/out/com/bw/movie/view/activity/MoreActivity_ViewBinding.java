// Generated code from Butter Knife. Do not modify!
package com.bw.movie.view.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.bw.movie.R;
import com.google.android.material.tabs.TabLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MoreActivity_ViewBinding implements Unbinder {
  private MoreActivity target;

  private View view7f080084;

  private View view7f080132;

  @UiThread
  public MoreActivity_ViewBinding(MoreActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MoreActivity_ViewBinding(final MoreActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.but_back_more, "field 'butBackMore' and method 'onViewClicked'");
    target.butBackMore = Utils.castView(view, R.id.but_back_more, "field 'butBackMore'", Button.class);
    view7f080084 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.etSeekMore = Utils.findRequiredViewAsType(source, R.id.et_seek_more, "field 'etSeekMore'", EditText.class);
    view = Utils.findRequiredView(source, R.id.iv_seek_more, "field 'ivSeekMore' and method 'onViewClicked'");
    target.ivSeekMore = Utils.castView(view, R.id.iv_seek_more, "field 'ivSeekMore'", ImageView.class);
    view7f080132 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tlMore = Utils.findRequiredViewAsType(source, R.id.tl_more, "field 'tlMore'", TabLayout.class);
    target.vpMore = Utils.findRequiredViewAsType(source, R.id.vp_more, "field 'vpMore'", ViewPager.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MoreActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.butBackMore = null;
    target.etSeekMore = null;
    target.ivSeekMore = null;
    target.tlMore = null;
    target.vpMore = null;

    view7f080084.setOnClickListener(null);
    view7f080084 = null;
    view7f080132.setOnClickListener(null);
    view7f080132 = null;
  }
}
