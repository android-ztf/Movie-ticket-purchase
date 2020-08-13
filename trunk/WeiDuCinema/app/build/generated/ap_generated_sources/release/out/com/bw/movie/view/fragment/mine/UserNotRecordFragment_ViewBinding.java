// Generated code from Butter Knife. Do not modify!
package com.bw.movie.view.fragment.mine;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bw.movie.R;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class UserNotRecordFragment_ViewBinding implements Unbinder {
  private UserNotRecordFragment target;

  @UiThread
  public UserNotRecordFragment_ViewBinding(UserNotRecordFragment target, View source) {
    this.target = target;

    target.xrlNotRecord = Utils.findRequiredViewAsType(source, R.id.xrl_not_record, "field 'xrlNotRecord'", XRecyclerView.class);
    target.rlNotFollow = Utils.findRequiredViewAsType(source, R.id.rl_not_follow, "field 'rlNotFollow'", RelativeLayout.class);
    target.tvNnotfollow = Utils.findRequiredViewAsType(source, R.id.tv_nnotfollow, "field 'tvNnotfollow'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    UserNotRecordFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.xrlNotRecord = null;
    target.rlNotFollow = null;
    target.tvNnotfollow = null;
  }
}
