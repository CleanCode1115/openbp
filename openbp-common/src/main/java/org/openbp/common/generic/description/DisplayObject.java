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
package org.openbp.common.generic.description;

/**
 * An object that has a name, a display name and a description.
 *
 * @author Heiko Erhardt
 */
public interface DisplayObject
	extends DescriptionObject
{
	//////////////////////////////////////////////////
	// @@ Member access
	//////////////////////////////////////////////////

	/**
	 * Gets the default display name of this object.
	 * The display name is the human-readable name of the object (i. e. a name that is
	 * displayed in the user interface).
	 * @nowarn
	 */
	public String getDisplayName();

	/**
	 * Sets the default display name of this object.
	 * The display name is the human-readable name of the object (i. e. a name that is
	 * displayed in the user interface).
	 * @nowarn
	 */
	public void setDisplayName(String displayName);
}
