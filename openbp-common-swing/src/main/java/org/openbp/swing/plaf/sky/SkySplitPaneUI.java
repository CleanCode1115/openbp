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
package org.openbp.swing.plaf.sky;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.metal.MetalSplitPaneUI;

public class SkySplitPaneUI extends MetalSplitPaneUI
{
	/*
	 * Creates a new MetalSplitPaneUI instance
	 */
	public static ComponentUI createUI(JComponent x)
	{
		return new SkySplitPaneUI();
	}

	/*
	 * Creates the default divider.
	 */
	public BasicSplitPaneDivider createDefaultDivider()
	{
		return new SkySplitPaneDivider(this);
	}
}
