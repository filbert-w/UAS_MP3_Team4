// Generated by view binder compiler. Do not edit!
package com.example.uas_mp3_team4.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.uas_mp3_team4.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class TelevisionItemBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView tvOverview;

  @NonNull
  public final ImageView tvPoster;

  @NonNull
  public final TextView tvTitle;

  private TelevisionItemBinding(@NonNull ConstraintLayout rootView, @NonNull TextView tvOverview,
      @NonNull ImageView tvPoster, @NonNull TextView tvTitle) {
    this.rootView = rootView;
    this.tvOverview = tvOverview;
    this.tvPoster = tvPoster;
    this.tvTitle = tvTitle;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static TelevisionItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static TelevisionItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.television_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static TelevisionItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.tv_overview;
      TextView tvOverview = ViewBindings.findChildViewById(rootView, id);
      if (tvOverview == null) {
        break missingId;
      }

      id = R.id.tv_poster;
      ImageView tvPoster = ViewBindings.findChildViewById(rootView, id);
      if (tvPoster == null) {
        break missingId;
      }

      id = R.id.tv_title;
      TextView tvTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvTitle == null) {
        break missingId;
      }

      return new TelevisionItemBinding((ConstraintLayout) rootView, tvOverview, tvPoster, tvTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}