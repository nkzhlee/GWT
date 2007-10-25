/*
 * Copyright 2007 Fred Sauer
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.allen_sauer.gwt.dragdrop.demo.client.example.bin;

import com.google.gwt.user.client.ui.Widget;

import com.allen_sauer.gwt.dragdrop.client.DragController;
import com.allen_sauer.gwt.dragdrop.client.DragEndEvent;
import com.allen_sauer.gwt.dragdrop.client.drop.SimpleDropController;
import com.allen_sauer.gwt.dragdrop.client.drop.VetoDropException;

/**
 * Sample SimpleDropController which discards draggable widgets which are
 * dropped on it.
 */
final class BinDropController extends SimpleDropController {

  private static final String CSS_DEMO_BIN_DRAGGABLE_ENGAGE = "demo-bin-draggable-engage";

  private Bin bin;

  public BinDropController(Bin bin) {
    super(bin);
    this.bin = bin;
  }

  public DragEndEvent onDrop(Widget reference, Widget draggable, DragController dragController) {
    DragEndEvent event = super.onDrop(reference, draggable, dragController);
    draggable.removeStyleName(CSS_DEMO_BIN_DRAGGABLE_ENGAGE);
    bin.setEngaged(false);
    bin.eatWidget(draggable);
    return event;
  }

  public void onEnter(Widget reference, Widget draggable, DragController dragController) {
    super.onEnter(reference, draggable, dragController);
    draggable.addStyleName(CSS_DEMO_BIN_DRAGGABLE_ENGAGE);
    bin.setEngaged(true);
  }

  public void onLeave(Widget draggable, DragController dragController) {
    super.onLeave(draggable, dragController);
    draggable.removeStyleName(CSS_DEMO_BIN_DRAGGABLE_ENGAGE);
    bin.setEngaged(false);
  }

  public void onPreviewDrop(Widget reference, Widget draggable, DragController dragController) throws VetoDropException {
    super.onPreviewDrop(reference, draggable, dragController);
    if (!bin.isWidgetEater()) {
      throw new VetoDropException();
    }
  }
}