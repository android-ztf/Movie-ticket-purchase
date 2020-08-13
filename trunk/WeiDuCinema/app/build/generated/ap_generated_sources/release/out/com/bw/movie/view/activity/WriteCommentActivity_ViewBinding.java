// Generated code from Butter Knife. Do not modify!
package com.bw.movie.view.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.bw.movie.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class WriteCommentActivity_ViewBinding implements Unbinder {
  private WriteCommentActivity target;

  private View view7f08008a;

  private View view7f080091;

  @UiThread
  public WriteCommentActivity_ViewBinding(WriteCommentActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public WriteCommentActivity_ViewBinding(final WriteCommentActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.but_back_write, "field 'butBackWrite' and method 'onViewClicked'");
    target.butBackWrite = Utils.castView(view, R.id.but_back_write, "field 'butBackWrite'", Button.class);
    view7f08008a = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvNameWrite = Utils.findRequiredViewAsType(source, R.id.tv_name_write, "field 'tvNameWrite'", TextView.class);
    target.tvScoreWrite = Utils.findRequiredViewAsType(source, R.id.tv_score_write, "field 'tvScoreWrite'", TextView.class);
    target.rbScorestarWrite = Utils.findRequiredViewAsType(source, R.id.rb_scorestar_write, "field 'rbScorestarWrite'", RatingBar.class);
    target.etCommentWrite = Utils.findRequiredViewAsType(source, R.id.et_comment_write, "field 'etCommentWrite'", EditText.class);
    view = Utils.findRequiredView(source, R.id.but_commit_write, "field 'butCommitWrite' and method 'onViewClicked'");
    target.butCommitWrite = Utils.castView(view, R.id.but_commit_write, "field 'butCommitWrite'", Button.class);
    view7f080091 = view;
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
    WriteCommentActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.butBackWrite = null;
    target.tvNameWrite = null;
    target.tvScoreWrite = null;
    target.rbScorestarWrite = null;
    target.etCommentWrite = null;
    target.butCommitWrite = null;

    view7f08008a.setOnClickListener(null);
    view7f08008a = null;
    view7f080091.setOnClickListener(null);
    view7f080091 = null;
  }
}
