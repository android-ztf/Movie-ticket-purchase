// Generated code from Butter Knife. Do not modify!
package com.bw.movie.view.fragment.movie_details;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bw.movie.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PosterFragmnet_ViewBinding implements Unbinder {
  private PosterFragmnet target;

  @UiThread
  public PosterFragmnet_ViewBinding(PosterFragmnet target, View source) {
    this.target = target;

    target.rvMore = Utils.findRequiredViewAsType(source, R.id.rv_more, "field 'rvMore'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PosterFragmnet target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rvMore = null;
  }
}
