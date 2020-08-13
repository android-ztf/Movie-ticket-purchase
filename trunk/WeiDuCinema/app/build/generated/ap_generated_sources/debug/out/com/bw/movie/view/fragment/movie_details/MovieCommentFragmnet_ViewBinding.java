// Generated code from Butter Knife. Do not modify!
package com.bw.movie.view.fragment.movie_details;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bw.movie.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MovieCommentFragmnet_ViewBinding implements Unbinder {
  private MovieCommentFragmnet target;

  @UiThread
  public MovieCommentFragmnet_ViewBinding(MovieCommentFragmnet target, View source) {
    this.target = target;

    target.rvMore = Utils.findRequiredViewAsType(source, R.id.rv_more, "field 'rvMore'", RecyclerView.class);
    target.srlMore = Utils.findRequiredViewAsType(source, R.id.srl_more, "field 'srlMore'", SwipeRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MovieCommentFragmnet target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rvMore = null;
    target.srlMore = null;
  }
}
