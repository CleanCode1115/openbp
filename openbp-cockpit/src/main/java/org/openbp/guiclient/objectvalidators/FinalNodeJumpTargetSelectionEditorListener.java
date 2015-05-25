/*
 *   Copyright 2007 skynamics AG
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

import java.util.Iterator;
import java.util.TreeMap;

import org.openbp.core.CoreConstants;
import org.openbp.core.model.item.process.FinalNode;
import org.openbp.core.model.item.process.InitialNode;
import org.openbp.core.model.item.process.Node;
import org.openbp.jaspira.propertybrowser.editor.PropertyEditorListenerAdapter;
import org.openbp.jaspira.propertybrowser.editor.standard.SelectionEditor;
import org.openbp.jaspira.propertybrowser.editor.standard.SelectionEditorListener;
import org.openbp.swing.components.popupfield.JSelectionField;
import org.openbp.swing.components.popupfield.PopupEvent;

/**
 * This listener for selection editors is meant to be used for the 'JumpTarget'
 * property of an {@link FinalNode} It fills the popup list with the names of the
 * initial nodes of the current process.
 *
 * @author Heiko Erhardt
 */
public class FinalNodeJumpTargetSelectionEditorListener extends PropertyEditorListenerAdapter
	implements SelectionEditorListener
{
	/**
	 * Default constructor.
	 */
	public FinalNodeJumpTargetSelectionEditorListener()
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
		if (!(o instanceof FinalNode))
			return;

		TreeMap map = new TreeMap();

		Iterator itNodes = ((FinalNode) o).getProcess().getNodes();

		while (itNodes.hasNext())
		{
			Node node = (Node) itNodes.next();

			if (!(node instanceof InitialNode))
				continue;

			String name = node.getName();
			map.put(name, name);
		}

		selectionField.addItem(null);
		selectionField.addItem(CoreConstants.JUMPTARGET_DEFAULT_PROCESS);
		for (Iterator itGroups = map.keySet().iterator(); itGroups.hasNext();)
		{
			String s = (String) itGroups.next();
			selectionField.addItem(s);
		}

		// Restore the text
		selectionField.setText(text);
	}
}
