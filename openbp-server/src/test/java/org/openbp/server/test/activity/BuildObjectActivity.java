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
package org.openbp.server.test.activity;

import org.openbp.server.handler.Handler;
import org.openbp.server.handler.HandlerContext;
import org.openbp.server.test.PersistedComplexParam;

/**
 * Buid object.
 */
public class BuildObjectActivity
	implements Handler
{
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
		PersistedComplexParam param = (PersistedComplexParam) hc.getParam("ObjParam");
		Integer value = (Integer) hc.getParam("NumParam");

		int newValue = value.intValue() + 1;
		param.setResult(newValue);

		if (newValue >= 100)
		{
			hc.setNextSocket("LargeNumber");
		}

		return true;
	}
}
