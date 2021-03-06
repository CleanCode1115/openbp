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
package org.openbp.server.remote;

import java.util.Set;

import org.openbp.core.OpenBPException;
import org.openbp.core.remote.ClientLoginInfo;
import org.openbp.core.remote.ClientSession;
import org.openbp.core.remote.ClientSessionService;
import org.openbp.core.remote.InvalidSessionException;

/**
 * This class implements the client session service interface, thus it implements
 * the functionality to create a session ({@link ClientSession}) based on login
 * information ({@link ClientLoginInfo}).
 *
 * @author Falk Hartmann
 */
public class ClientSessionServiceImpl
	implements ClientSessionService
{
	//////////////////////////////////////////////////
	// @@ Construction
	//////////////////////////////////////////////////

	/**
	 * Default constructor.
	 *
	 * @throws OpenBPException never
	 */
	public ClientSessionServiceImpl()
	{
	}

	//////////////////////////////////////////////////
	// @@ Service implementation
	//////////////////////////////////////////////////

	/**
	 * @copy ClientSessionService.createSession
	 */
	public ClientSession createSession(ClientLoginInfo loginInfo)
	{
		return ClientSessionMgr.getInstance().createSession(loginInfo);
	}

	/**
	 * @copy ClientSessionService.getSessionEvents
	 */
	public Set getSessionEvents(ClientSession session)
		throws InvalidSessionException
	{
		// Make sure the session if valid.
		ClientSessionMgr.getInstance().checkSession(session);

		// Return the event set (whereby delegating to the ClientSessionMgr).
		return ClientSessionMgr.getInstance().popSessionEvents(session);
	}
}
