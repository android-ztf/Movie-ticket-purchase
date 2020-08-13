// Generated code from Butter Knife. Do not modify!
package com.bw.movie.view.activity.mine;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.bw.movie.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class UserSeenActivity_ViewBinding implements Unbinder {
  private UserSeenActivity target;

  private View view7f080080;

  @UiThread
  public UserSeenActivity_ViewBinding(UserSeenActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public UserSeenActivity_ViewBinding(final UserSeenActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.but_back_loign, "field 'butBackLoign' and method 'onViewClicked'");
    target.butBackLoign = Utils.castView(view, R.id.but_back_loign, "field 'butBackLoign'", Button.class);
    view7f080080 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    target.rvUserSeen = Utils.findRequiredViewAsType(source, R.id.rv_user_seen, "field 'rvUserSeen'", RecyclerView.class);
    target.tvNnotfollow = Utils.findRequiredViewAsType(source, R.id.tv_nnotfollow, "field 'tvNnotfollow'", TextView.class);
    target.ivNotfollow = Utils.findRequiredViewAsType(source, R.id.iv_notfollow, "field 'ivNotfollow'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    UserSeenActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.butBackLoign = null;
    target.rvUserSeen = null;
    target.tvNnotfollow = null;
    target.ivNotfollow = null;

    view7f080080.setOnClickListener(null);
    view7f080080 = null;
  }
}
