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
package com.allen_sauer.gwt.dragdrop.client;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Widget;

import com.allen_sauer.gwt.dragdrop.client.drop.DropController;

import java.util.ArrayList;
import java.util.List;

public class DragContext {
  /**
   * TODO replace context.dragController.getBoundaryPanel() with context.boundaryPanel
   */
  public final AbsolutePanel boundaryPanel;

  /**
   * The DragController for which this context exists.
   */
  public final DragController dragController;

  /**
   * The primary widget currently being dragged.
   */
  public Widget draggable;

  /**
   * TODO document that at end null means drop not allowed
   */
  public DropController dropController;

  /**
   * Current mouse x coordinate while dragging.
   */
  public int mouseX;

  /**
   * Current mouse y coordinate while dragging.
   */
  public int mouseY;

  /**
   * The widget or panel which moves around with the mouse.
   */
  public Widget movableWidget;

  /**
   * List of currently selected widgets.
   */
  public List selectedWidgets = new ArrayList();

  DragContext(DragController dragController) {
    this.dragController = dragController;
    boundaryPanel = dragController.getBoundaryPanel();
  }
}
