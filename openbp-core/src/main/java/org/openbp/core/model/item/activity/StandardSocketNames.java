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
package org.openbp.core.model.item.activity;

import java.util.HashMap;
import java.util.Map;

import org.openbp.core.CoreConstants;

/**
 * Standard socket names.
 *
 * @author Heiko Erhardt
 */
public final class StandardSocketNames
{
	/**
	 * Private constructor prevents instantiation.
	 */
	private StandardSocketNames()
	{
	}

	/** Standard socket names */
	private static Map names;

	/**
	 * Gets the standard socket name identifier for the specified socket.
	 *
	 * @param socketName Socket name
	 * @return The Java constant identifier (i. e. "SOCKET_IN")
	 * or null if the specified socket is not a standard socket.
	 */
	public static String getStandardSocketNameIdentifier(String socketName)
	{
		if (names == null)
		{
			names = new HashMap();
			names.put(CoreConstants.SOCKET_IN, "SOCKET_IN");
			names.put(CoreConstants.SOCKET_OUT, "SOCKET_OUT");
			names.put(CoreConstants.SOCKET_ERROR, "SOCKET_ERROR");
			names.put(CoreConstants.SOCKET_YES, "SOCKET_YES");
			names.put(CoreConstants.SOCKET_NO, "SOCKET_NO");
		}
		return (String) names.get(socketName);
	}
}
