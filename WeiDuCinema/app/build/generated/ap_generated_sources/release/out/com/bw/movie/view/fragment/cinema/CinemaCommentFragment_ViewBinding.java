// Generated code from Butter Knife. Do not modify!
package com.bw.movie.view.fragment.cinema;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bw.movie.R;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CinemaCommentFragment_ViewBinding implements Unbinder {
  private CinemaCommentFragment target;

  @UiThread
  public CinemaCommentFragment_ViewBinding(CinemaCommentFragment target, View source) {
    this.target = target;

    target.ptrlvCinemacomment = Utils.findRequiredViewAsType(source, R.id.ptrlv_cinemacomment, "field 'ptrlvCinemacomment'", PullToRefreshListView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CinemaCommentFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ptrlvCinemacomment = null;
  }
}
