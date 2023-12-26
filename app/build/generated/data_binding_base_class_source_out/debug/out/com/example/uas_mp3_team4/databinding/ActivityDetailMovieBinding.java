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

public final class ActivityDetailMovieBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView imgItemPhoto;

  @NonNull
  public final TextView tvItemDescription;

  @NonNull
  public final TextView tvItemName;

  private ActivityDetailMovieBinding(@NonNull ConstraintLayout rootView,
      @NonNull ImageView imgItemPhoto, @NonNull TextView tvItemDescription,
      @NonNull TextView tvItemName) {
    this.rootView = rootView;
    this.imgItemPhoto = imgItemPhoto;
    this.tvItemDescription = tvItemDescription;
    this.tvItemName = tvItemName;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityDetailMovieBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityDetailMovieBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_detail_movie, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityDetailMovieBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.img_item_photo;
      ImageView imgItemPhoto = ViewBindings.findChildViewById(rootView, id);
      if (imgItemPhoto == null) {
        break missingId;
      }

      id = R.id.tv_item_description;
      TextView tvItemDescription = ViewBindings.findChildViewById(rootView, id);
      if (tvItemDescription == null) {
        break missingId;
      }

      id = R.id.tv_item_name;
      TextView tvItemName = ViewBindings.findChildViewById(rootView, id);
      if (tvItemName == null) {
        break missingId;
      }

      return new ActivityDetailMovieBinding((ConstraintLayout) rootView, imgItemPhoto,
          tvItemDescription, tvItemName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}