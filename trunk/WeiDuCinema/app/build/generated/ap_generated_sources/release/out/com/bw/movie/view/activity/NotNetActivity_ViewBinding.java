// Generated code from Butter Knife. Do not modify!
package com.bw.movie.view.activity;

import android.view.View;
import android.widget.Button;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.bw.movie.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NotNetActivity_ViewBinding implements Unbinder {
  private NotNetActivity target;

  private View view7f080078;

  @UiThread
  public NotNetActivity_ViewBinding(NotNetActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public NotNetActivity_ViewBinding(final NotNetActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.but_back_, "field 'butBack' and method 'onViewClicked'");
    target.butBack = Utils.castView(view, R.id.but_back_, "field 'butBack'", Button.class);
    view7f080078 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    NotNetActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.butBack = null;

    view7f080078.setOnClickListener(null);
    view7f080078 = null;
  }
}
