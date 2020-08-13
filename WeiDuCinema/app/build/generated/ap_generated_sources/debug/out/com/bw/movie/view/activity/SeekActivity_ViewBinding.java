// Generated code from Butter Knife. Do not modify!
package com.bw.movie.view.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
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

public class SeekActivity_ViewBinding implements Unbinder {
  private SeekActivity target;

  private View view7f080088;

  private View view7f0802a3;

  @UiThread
  public SeekActivity_ViewBinding(SeekActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SeekActivity_ViewBinding(final SeekActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.but_back_seek, "field 'butBackSeek' and method 'onViewClicked'");
    target.butBackSeek = Utils.castView(view, R.id.but_back_seek, "field 'butBackSeek'", Button.class);
    view7f080088 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.seekRl = Utils.findRequiredViewAsType(source, R.id.seek_rl, "field 'seekRl'", RelativeLayout.class);
    target.ivNotseek = Utils.findRequiredViewAsType(source, R.id.iv_notseek, "field 'ivNotseek'", ImageView.class);
    target.tvNotseek = Utils.findRequiredViewAsType(source, R.id.tv_notseek, "field 'tvNotseek'", TextView.class);
    target.rlSeek = Utils.findRequiredViewAsType(source, R.id.rl_seek, "field 'rlSeek'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.tv_seeksum, "field 'tvSeeksum' and method 'onViewClicked'");
    target.tvSeeksum = Utils.castView(view, R.id.tv_seeksum, "field 'tvSeeksum'", TextView.class);
    view7f0802a3 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.etSeek = Utils.findRequiredViewAsType(source, R.id.et_seek, "field 'etSeek'", EditText.class);
    target.scrollviewSeek = Utils.findRequiredViewAsType(source, R.id.scrollview_seek, "field 'scrollviewSeek'", ScrollView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SeekActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.butBackSeek = null;
    target.seekRl = null;
    target.ivNotseek = null;
    target.tvNotseek = null;
    target.rlSeek = null;
    target.tvSeeksum = null;
    target.etSeek = null;
    target.scrollviewSeek = null;

    view7f080088.setOnClickListener(null);
    view7f080088 = null;
    view7f0802a3.setOnClickListener(null);
    view7f0802a3 = null;
  }
}
