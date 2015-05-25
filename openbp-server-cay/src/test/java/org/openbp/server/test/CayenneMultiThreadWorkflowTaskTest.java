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
package org.openbp.server.test;

import org.openbp.server.persistence.PersistenceContext;


/**
 * Cayenne version of a workflow test that suspends and resumes a workflow that contains a complex parameter that is managed by Hibernate.
 *
 * @author Heiko Erhardt
 */
public class CayenneMultiThreadWorkflowTaskTest extends MultiThreadWorkflowTaskTest
{
	public CayenneMultiThreadWorkflowTaskTest()
	{
		setSpringConfigFileName("OpenBP-Server-Cayenne.spring.xml");
	}

	public PersistedComplexParam createPersistedComplexParam()
	{
		PersistenceContext pc = getProcessServer().getEngine().getPersistenceContextProvider().obtainPersistenceContext();

		PersistedComplexParam ret = (PersistedComplexParam) pc.createObject(CayennePersistedComplexParam.class);

		ret.setTitle("Workflow task test 1");

		pc.saveObject(ret);
		pc.commitTransaction();

		return ret;
	}
}
