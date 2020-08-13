// Generated code from Butter Knife. Do not modify!
package com.bw.movie.view.activity.mine;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.bw.movie.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FeedBackActivity_ViewBinding implements Unbinder {
  private FeedBackActivity target;

  private View view7f08007e;

  private View view7f08007d;

  @UiThread
  public FeedBackActivity_ViewBinding(FeedBackActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public FeedBackActivity_ViewBinding(final FeedBackActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.but_back_feedback, "field 'butBackFeedback' and method 'onViewClicked'");
    target.butBackFeedback = Utils.castView(view, R.id.but_back_feedback, "field 'butBackFeedback'", Button.class);
    view7f08007e = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.etSeenback = Utils.findRequiredViewAsType(source, R.id.et_seenback, "field 'etSeenback'", EditText.class);
    view = Utils.findRequiredView(source, R.id.but_back_commit, "field 'butBackCommit' and method 'onViewClicked'");
    target.butBackCommit = Utils.castView(view, R.id.but_back_commit, "field 'butBackCommit'", Button.class);
    view7f08007d = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.rlSeenback = Utils.findRequiredViewAsType(source, R.id.rl_seenback, "field 'rlSeenback'", RelativeLayout.class);
    target.rlFkui = Utils.findRequiredViewAsType(source, R.id.rl_fkui, "field 'rlFkui'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FeedBackActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.butBackFeedback = null;
    target.etSeenback = null;
    target.butBackCommit = null;
    target.rlSeenback = null;
    target.rlFkui = null;

    view7f08007e.setOnClickListener(null);
    view7f08007e = null;
    view7f08007d.setOnClickListener(null);
    view7f08007d = null;
  }
}
