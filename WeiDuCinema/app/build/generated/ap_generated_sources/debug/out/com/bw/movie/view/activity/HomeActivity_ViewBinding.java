// Generated code from Butter Knife. Do not modify!
package com.bw.movie.view.activity;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bw.movie.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeActivity_ViewBinding implements Unbinder {
  private HomeActivity target;

  @UiThread
  public HomeActivity_ViewBinding(HomeActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public HomeActivity_ViewBinding(HomeActivity target, View source) {
    this.target = target;

    target.vpId = Utils.findRequiredViewAsType(source, R.id.vp_id, "field 'vpId'", ViewPager.class);
    target.rbMovie = Utils.findRequiredViewAsType(source, R.id.rb_movie, "field 'rbMovie'", RadioButton.class);
    target.rbCinema = Utils.findRequiredViewAsType(source, R.id.rb_cinema, "field 'rbCinema'", RadioButton.class);
    target.rbMine = Utils.findRequiredViewAsType(source, R.id.rb_mine, "field 'rbMine'", RadioButton.class);
    target.rgId = Utils.findRequiredViewAsType(source, R.id.rg_id, "field 'rgId'", RadioGroup.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HomeActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.vpId = null;
    target.rbMovie = null;
    target.rbCinema = null;
    target.rbMine = null;
    target.rgId = null;
  }
}
