/*
 *   Copyright 2010 skynamics AG
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package org.openbp.guiclient.objectvalidators;

import org.openbp.common.generic.description.DisplayObject;
import org.openbp.common.string.NameUtil;
import org.openbp.jaspira.propertybrowser.editor.PropertyEditorListenerAdapter;
import org.openbp.jaspira.propertybrowser.editor.standard.SelectionEditor;
import org.openbp.jaspira.propertybrowser.editor.standard.SelectionEditorListener;
import org.openbp.swing.components.popupfield.JSelectionField;
import org.openbp.swing.components.popupfield.PopupEvent;

/**
 * This SelectionEditorListener is used for displaying a display name that has been generated from the system name of the edited object.
 *
 * @author Heiko Erhardt
 */
public class DisplayNameSelectionEditorListener extends PropertyEditorListenerAdapter
	implements SelectionEditorListener
{
	/**
	 * Default constructor.
	 */
	public DisplayNameSelectionEditorListener()
	{
	}

	/**
	 * Called when the popup menu of the selection editor is being displayed or hidden.
	 *
	 * @param editor Editor
	 * @param cause Cause of the event ({@link PopupEvent#POPUP_OPENING}/{@link PopupEvent#POPUP_OPENED}/
	 * {@link PopupEvent#POPUP_CLOSING}/{@link PopupEvent#POPUP_CLOSED})
	 */
	public void popup(SelectionEditor editor, int cause)
	{
		if (cause != PopupEvent.POPUP_OPENING)
			return;

		JSelectionField selectionField = (JSelectionField) editor.getPropertyComponent();

		// Save the text (will be cleared when removing the items)
		String text = selectionField.getText();

		// Clear the item list
		selectionField.clearItems();

		Object o = editor.getObject();
		if (!(o instanceof DisplayObject))
			return;

		selectionField.addItem(null);
		String displayName = NameUtil.makeDisplayName(((DisplayObject) o).getName());
		if (displayName != null)
		{
			selectionField.addItem(displayName);
		}

		// Restore the text
		selectionField.setText(text);
	}
}
