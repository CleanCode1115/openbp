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
package org.openbp.guiclient.model.item.itemfinder;

import java.util.List;

import org.openbp.core.model.ModelObject;
import org.openbp.core.model.item.ItemTypeDescriptor;

/**
 * Interface, that all finder engine must implement
 *
 * @author Baumgartner Michael
 */
public interface FinderEngine
{
	/**
	 * Create a list of {@link ModelObject} that references the
	 * specified item.
	 * @param core The model object to lookup
	 * @param modelList List with all models to search, if the list is null, then all top-level models are searched
	 * @return List with all found references containing
	 * {@link ModelObject} objects. If none where found null is returned
	 */
	public List createReferenceList(ModelObject core, List modelList);

	/**
	 * Register a finder for a special item type.
	 *
	 * @param itemType The item type
	 * @param finder The finder
	 */
	public void registerFinder(String itemType, Finder finder);

	/**
	 * Register a finder for a special item type.
	 *
	 * @param itemType The item type
	 * @param finder The finder
	 */
	public void registerFinder(ItemTypeDescriptor itemType, Finder finder);

	/**
	 * Register a finder for a special model object class e\.g\. an initial node.
	 *
	 * @param modelObjectClass The class to register the finder with
	 * @param finder The finder
	 */
	public void registerFinder(Class modelObjectClass, Finder finder);
}
