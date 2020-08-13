// Generated code from Butter Knife. Do not modify!
package com.bw.movie.view.fragment.mine;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bw.movie.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class UserFollowMovieFragment_ViewBinding implements Unbinder {
  private UserFollowMovieFragment target;

  @UiThread
  public UserFollowMovieFragment_ViewBinding(UserFollowMovieFragment target, View source) {
    this.target = target;

    target.rvMore = Utils.findRequiredViewAsType(source, R.id.rv_user_followmovie, "field 'rvMore'", RecyclerView.class);
    target.ivNotfollow = Utils.findRequiredViewAsType(source, R.id.iv_notfollow, "field 'ivNotfollow'", ImageView.class);
    target.tvNnotfollow = Utils.findRequiredViewAsType(source, R.id.tv_nnotfollow, "field 'tvNnotfollow'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    UserFollowMovieFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rvMore = null;
    target.ivNotfollow = null;
    target.tvNnotfollow = null;
  }
}
