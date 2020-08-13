// Generated code from Butter Knife. Do not modify!
package com.bw.movie.view.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.bw.movie.R;
import com.facebook.drawee.view.SimpleDraweeView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CommentDetailActivity_ViewBinding implements Unbinder {
  private CommentDetailActivity target;

  private View view7f08007c;

  private View view7f080090;

  @UiThread
  public CommentDetailActivity_ViewBinding(CommentDetailActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CommentDetailActivity_ViewBinding(final CommentDetailActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.but_back_commentdetail, "field 'butBackCommentdetail' and method 'onViewClicked'");
    target.butBackCommentdetail = Utils.castView(view, R.id.but_back_commentdetail, "field 'butBackCommentdetail'", Button.class);
    view7f08007c = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.sdvCommentdetailPic = Utils.findRequiredViewAsType(source, R.id.sdv_commentdetail_pic, "field 'sdvCommentdetailPic'", SimpleDraweeView.class);
    target.tvCommentdetailName = Utils.findRequiredViewAsType(source, R.id.tv_commentdetail_name, "field 'tvCommentdetailName'", TextView.class);
    target.rbCommentdetailStar = Utils.findRequiredViewAsType(source, R.id.rb_commentdetail_star, "field 'rbCommentdetailStar'", RatingBar.class);
    target.tvCommentdetailScore = Utils.findRequiredViewAsType(source, R.id.tv_commentdetail_score, "field 'tvCommentdetailScore'", TextView.class);
    target.tvCommentdetailTime = Utils.findRequiredViewAsType(source, R.id.tv_commentdetail_time, "field 'tvCommentdetailTime'", TextView.class);
    target.tvCommentdetailContent = Utils.findRequiredViewAsType(source, R.id.tv_commentdetail_content, "field 'tvCommentdetailContent'", TextView.class);
    target.tvCommentdetailNum = Utils.findRequiredViewAsType(source, R.id.tv_commentdetail_num, "field 'tvCommentdetailNum'", TextView.class);
    target.rvReplyCommentdetail = Utils.findRequiredViewAsType(source, R.id.rv_reply_commentdetail, "field 'rvReplyCommentdetail'", RecyclerView.class);
    target.etCommentdetailReply = Utils.findRequiredViewAsType(source, R.id.et_commentdetail_reply, "field 'etCommentdetailReply'", EditText.class);
    view = Utils.findRequiredView(source, R.id.but_commentdetai_commit, "field 'butCommentdetaiCommit' and method 'onViewClicked'");
    target.butCommentdetaiCommit = Utils.castView(view, R.id.but_commentdetai_commit, "field 'butCommentdetaiCommit'", Button.class);
    view7f080090 = view;
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
    CommentDetailActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.butBackCommentdetail = null;
    target.sdvCommentdetailPic = null;
    target.tvCommentdetailName = null;
    target.rbCommentdetailStar = null;
    target.tvCommentdetailScore = null;
    target.tvCommentdetailTime = null;
    target.tvCommentdetailContent = null;
    target.tvCommentdetailNum = null;
    target.rvReplyCommentdetail = null;
    target.etCommentdetailReply = null;
    target.butCommentdetaiCommit = null;

    view7f08007c.setOnClickListener(null);
    view7f08007c = null;
    view7f080090.setOnClickListener(null);
    view7f080090 = null;
  }
}
