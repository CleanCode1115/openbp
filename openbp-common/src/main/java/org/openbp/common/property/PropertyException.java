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
package org.openbp.common.property;

/**
 * Exception indicating a property access error.
 * This exception may wrap another exception that describes the failure in detail.
 *
 * @author Heiko Erhardt
 */
public class PropertyException extends RuntimeException
{
	/**
	 * Constructor.
	 * @param msg Exception message
	 */
	public PropertyException(String msg)
	{
		super(msg);
	}

	/**
	 * Constructor.
	 * @param exception Nested exception
	 */
	public PropertyException(Exception exception)
	{
		super(exception);
	}

	/**
	 * Constructor.
	 * @param msg Exception message
	 * @param exception Nested exception
	 */
	public PropertyException(String msg, Exception exception)
	{
		super(msg, exception);
	}
}
