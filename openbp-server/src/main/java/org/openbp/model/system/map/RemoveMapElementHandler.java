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
package org.openbp.model.system.map;

import java.util.Map;

import org.openbp.server.handler.Handler;
import org.openbp.server.handler.HandlerContext;

// {{*Custom imports*
// }}*Custom imports*

/**
 * Remove element.
 * Implementation of the RemoveMapElement activity handler.
 * Removes an element from a map.
 * Returns the previous value associated with the 
 * specified key or null if there was no such element and the map itself.
 * 
 * Input sockets/parameter:
 *   Socket 'In'
 *     Parameter 'Map': Map
 *     Parameter 'Key': Key
 * 
 * Output sockets/parameter:
 *   Socket 'Out'
 *     Parameter 'Map': Map
 *     Parameter 'Element': Element
 */
public class RemoveMapElementHandler
	// {{*Custom extends*
	// }}*Custom extends*
	// {{*Custom interfaces*
	implements Handler
	// }}*Custom interfaces*
{
	/** Parameter Map */
	private static final String PARAM_MAP = "Map";

	/** Parameter Key */
	private static final String PARAM_KEY = "Key";

	/** Parameter Element */
	private static final String PARAM_ELEMENT = "Element";

	// {{*Custom constants*
	// }}*Custom constants*

	// {{*Custom members*
	// Note: If you define member variables, consider the fact that the same handler instance may be executed
	// by multiple threads in parallel, so you have to make sure that your implementation is thread safe.
	// In general, member variables should be defined for global-like data only.
	// }}*Custom members*

	/**
	 * Executes the handler.
	 *
	 * @param hc Handler context that contains execution parameters
	 * @return true if the handler handled the event, false to apply the default handling to the event
	 * @throws Exception Any exception that may occur during execution of the handler will be
	 * propagated to an exception handler if defined or abort the process execution otherwise.
	 */
	public boolean execute(HandlerContext hc)
		throws Exception
	{
		// {{*Handler implementation*
		Map map = (Map) hc.getParam(PARAM_MAP);
		Object key = hc.getParam(PARAM_KEY);

		Object element = map.remove(key);

		hc.setResult(PARAM_MAP, map);
		hc.setResult(PARAM_ELEMENT, element);

		return true;
		// }}*Handler implementation*
	}

	// {{*Custom methods*
	// }}*Custom methods*
}

