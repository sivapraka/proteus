/*
 * Copyright 2019 Flipkart Internet Pvt. Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.flipkart.android.proteus.support.v7.widget;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.view.View;

import com.flipkart.android.proteus.ProteusContext;
import com.flipkart.android.proteus.ProteusView;

/**
 * ProteusCardView
 *
 * @author adityasharat
 */

public class ProteusCardView extends CardView implements ProteusView {

  private Manager manager;

  public ProteusCardView(ProteusContext context) {
    super(context);
  }

  @Override
  public Manager getViewManager() {
    return manager;
  }

  @Override
  public void setViewManager(@NonNull Manager manager) {
    this.manager = manager;
  }

  @NonNull
  @Override
  public View getAsView() {
    return this;
  }
}
