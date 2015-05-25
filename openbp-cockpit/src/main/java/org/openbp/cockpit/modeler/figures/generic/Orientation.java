/*
 *   Copyright 2010 skynamics AG
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
package org.openbp.cockpit.modeler.figures.generic;

/**
 * Constants for orthogonal orientation.
 */
public enum Orientation
	implements IntEnum<Orientation>
{
	/** Undetermined orientation */
	UNDETERMINED(-1),

	/** Center (used for gradients, same as {@link #UNDETERMINED}) */
	CENTER(-1),

	/** Orientation To the right */
	RIGHT (0),

	/** Orientation To the bottom */
	BOTTOM (1),

	/** Orientation: To the Left */
	LEFT (2),

	/** Orientation: To the top */
	TOP (3);

	int value;

	private Orientation(int value)
	{
		this.value = value;
	}

	public int toInt()
	{
		return value;
	}

	public static Orientation fromInt(int i)
	{
		for (Orientation v : Orientation.values())
		{
			if (v.toInt() == i)
				return v;
		}
		throw new IllegalArgumentException ("Invalid value '" + i + "' for enumeration of type '" + Orientation.class.getName() + "'.");
	}

	public String toString()
	{
		return "" + value;
	}
}