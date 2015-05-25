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
package org.openbp.jaspira.option.widget;

import java.awt.BorderLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.openbp.jaspira.option.Option;
import org.openbp.jaspira.option.OptionWidget;
import org.openbp.swing.plaf.sky.SkyTheme;

/**
 * A InputWidget which only excepts Numbers.
 *
 * @author Jens Ferchland
 */
public class IntegerWidget extends OptionWidget
	implements ChangeListener
{
	//////////////////////////////////////////////////
	// @@ Members
	//////////////////////////////////////////////////

	/** Component that will be returned */
	private JPanel panel;

	/** Input field */
	private JSpinner spinner;

	//////////////////////////////////////////////////
	// @@ Constructors
	//////////////////////////////////////////////////

	/**
	 * Constructor.
	 *
	 * @param option Option the widget refers to
	 * @param min Minimum value
	 * @param max Maximum value
	 */
	public IntegerWidget(Option option, int min, int max)
	{
		super(option);

		spinner = new JSpinner(new SpinnerNumberModel(min, min, max, 1));
		spinner.addChangeListener(this);
		((JSpinner.DefaultEditor) spinner.getEditor()).getTextField().setBackground(SkyTheme.COLOR_BACKGROUND_LIGHT_LIGHT);

		panel = new JPanel(new BorderLayout());
		JComponent heading = createHeading();
		if (heading != null)
		{
			panel.add(heading, BorderLayout.WEST);
		}
		panel.add(spinner);
	}

	/**
	 * @see javax.swing.event.ChangeListener#stateChanged(ChangeEvent)
	 */
	public void stateChanged(ChangeEvent e)
	{
		notifyOptionMgrOfOptionChange();
	}

	//////////////////////////////////////////////////
	// @@ OptionWidget implementation
	//////////////////////////////////////////////////

	public Object getValue()
	{
		return spinner.getValue();
	}

	public void setValue(Object o)
	{
		spinner.setValue(o);
	}

	public JComponent getWidgetComponent()
	{
		return panel;
	}
}
