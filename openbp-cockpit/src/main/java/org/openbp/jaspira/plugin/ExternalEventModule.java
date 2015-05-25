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
package org.openbp.jaspira.plugin;

/**
 * Event module that maintains a reference to its plugin.
 * For larger plugins, it may be useful to put the module(s) into a separate
 * class rather than as inner class of the large plugin (see {@link AbstractPlugin#getExternalEventModuleClasses}).
 *
 * @author Stephan Moritz
 */
public abstract class ExternalEventModule extends EventModule
{
	/** Reference to the parent plugin. */
	private final Plugin parentPlugin;

	/**
	 * Constructor.
	 *
	 * @param plugin The plugin this module is associated with
	 */
	public ExternalEventModule(Plugin plugin)
	{
		super();

		parentPlugin = plugin;
	}

	/**
	 * Returns the plugin that owns this module.
	 * @nowarn
	 */
	public Plugin getPlugin()
	{
		return parentPlugin;
	}
}
