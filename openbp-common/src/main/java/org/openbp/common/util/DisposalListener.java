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
package org.openbp.common.util;

/**
 * This interface can be implemented in order to get notified when containers
 * restricted in size or time containers dispose their elements.
 *
 * @author Falk Hartmann
 */
public interface DisposalListener
{
	/**
	 * This method is called by the container for each element that is being disposed.
	 *
	 * @param obj For maps, the key is passed; for simple containers, the object itself
	 */
	public void onDispose(Object obj);
}
