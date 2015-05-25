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
package org.openbp.core.model.item.process;

import org.openbp.core.model.Model;
import org.openbp.core.model.ModelObjectImpl;

/**
 * A process object denotes a sub object of a {@link ProcessItem}
 * Each process object is also a model object, i. e. has a name, a display name and a description
 * and a reference to its owning model, model manager and message container.
 *
 * @author Heiko Erhardt
 */
public abstract class ProcessObjectImpl extends ModelObjectImpl
	implements ProcessObject
{
	//////////////////////////////////////////////////
	// @@ Data members
	//////////////////////////////////////////////////

	/**
	 * An arbitary object.
	 * Can be used by an editor to create a pointer to a graphical representation.
	 */
	private transient Object representation;

	//////////////////////////////////////////////////
	// @@ ProcessObject implementation
	//////////////////////////////////////////////////

	/**
	 * Gets the model the item belongs to.
	 * @nowarn
	 */
	public Model getOwningModel()
	{
		return getProcess().getOwningModel();
	}

	/**
	 * @copy ModelObject.maintainReferences
	 */
	public void maintainReferences(int flag)
	{
		super.maintainReferences(flag);

		if ((flag & UNLINK_FROM_REPRESENTATION) != 0)
		{
			setRepresentation(null);
		}
	}

	/**
	 * Returns the current representation of this process object.
	 *
	 * @return The actual representation or null if not set
	 */
	public Object getRepresentation()
	{
		return representation;
	}

	/**
	 * Sets the representation object of this process object.
	 * This can be used to store a pointer to a graphical representation in an editor or such.
	 *
	 * @param representation The new representation or null to clear
	 */
	public void setRepresentation(Object representation)
	{
		this.representation = representation;
	}
}
