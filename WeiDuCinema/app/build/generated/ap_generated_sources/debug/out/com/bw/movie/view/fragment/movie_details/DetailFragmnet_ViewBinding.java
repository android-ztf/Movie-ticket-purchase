// Generated code from Butter Knife. Do not modify!
package com.bw.movie.view.fragment.movie_details;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bw.movie.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DetailFragmnet_ViewBinding implements Unbinder {
  private DetailFragmnet target;

  @UiThread
  public DetailFragmnet_ViewBinding(DetailFragmnet target, View source) {
    this.target = target;

    target.jianjie = Utils.findRequiredViewAsType(source, R.id.jianjie, "field 'jianjie'", TextView.class);
    target.movieSynopsis = Utils.findRequiredViewAsType(source, R.id.movie_synopsis, "field 'movieSynopsis'", TextView.class);
    target.yanzhi = Utils.findRequiredViewAsType(source, R.id.yanzhi, "field 'yanzhi'", TextView.class);
    target.movieDaoyanNum = Utils.findRequiredViewAsType(source, R.id.movie_daoyan_num, "field 'movieDaoyanNum'", TextView.class);
    target.movieDapyanRecyclerView = Utils.findRequiredViewAsType(source, R.id.movie_dapyan_RecyclerView, "field 'movieDapyanRecyclerView'", RecyclerView.class);
    target.movieYanyuanNum = Utils.findRequiredViewAsType(source, R.id.movie_yanyuan_num, "field 'movieYanyuanNum'", TextView.class);
    target.movieYanyuanRecycler = Utils.findRequiredViewAsType(source, R.id.movie_yanyuan_Recycler, "field 'movieYanyuanRecycler'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DetailFragmnet target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.jianjie = null;
    target.movieSynopsis = null;
    target.yanzhi = null;
    target.movieDaoyanNum = null;
    target.movieDapyanRecyclerView = null;
    target.movieYanyuanNum = null;
    target.movieYanyuanRecycler = null;
  }
}
