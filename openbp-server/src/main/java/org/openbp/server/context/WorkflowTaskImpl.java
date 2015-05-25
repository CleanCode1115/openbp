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
package org.openbp.server.context;

import java.sql.Timestamp;

import org.openbp.common.CommonUtil;
import org.openbp.common.util.ToStringHelper;
import org.openbp.common.util.UUIDGenerator;
import org.openbp.server.persistence.PersistentObjectBase;

// }}*Custom imports*

/**
 * Standard implemenation of the WorkflowTask interface.
 *
 * NOTE: If you make changes to this class, be sure to perform the also in CayenneWorkflowTaskImpl, which is an exact copy of this class thanks to Java's inability to support multiple inheritance.
 */
public class WorkflowTaskImpl extends PersistentObjectBase
	implements WorkflowTask
{
	//////////////////////////////////////////////////
	// @@ Data members
	//////////////////////////////////////////////////

	/**
	 * Name of the workflow task.
	 * The name is actually the unique id of the task. WorkflowTaskDescriptor implements DisplayObject, so we chose to use the Name attribute instead of the Id attribute for this.
	 */
	protected String name;

	/**
	 * Display name.
	 * Title of the workflow task.
	 * The display name appears as task title in the worklist.
	 * The display name should provide a short but functional information what this workflow task is about.
	 * It will be listed in the workflow task user interface in order to aid the user in selecting a workflow task to process.
	 */
	protected String displayName;

	/**
	 * Description.
	 * A detailed description of this workflow task.
	 */
	protected String description;

	/**
	 * Creation time.
	 * Time of creation of this workflow task.
	 */
	protected Timestamp timeCreated;

	/**
	 * Accepting time.
	 * Time of selection of this workflow task for processing.
	 */
	protected Timestamp timeAccepted;

	/**
	 * Completion time.
	 * Time of completion of the workflow task.
	 */
	protected Timestamp timeCompleted;

	/**
	 * Creating user.
	 * Id of the user who created this task.
	 */
	protected String creatingUserId;

	/**
	 * Accepting user.
	 * Id of the user who accepted this task.
	 */
	protected String acceptingUserId;

	/**
	 * Due time.
	 * Due time of this workflow task or null.
	 */
	protected Timestamp dueTime;

	/**
	 * Status.
	 * Processing status of the workflow task.
	 * (see the constants of this class).
	 */
	protected int status;

	/** Token context of this workflow task */
	private TokenContext tokenContext;

	// The following properties are copied from WorkflowTaskDescriptor, since Java does not support multiple inheritance

	/** Step system name */
	private String stepName;

	/** Step display name */
	private String stepDisplayName;

	/** Step description */
	private String stepDescription;

	/** Role */
	private String roleId;

	/** User */
	private String userId;

	/** Permissions */
	private String permissions;

	/** Priority */
	private int priority;

	/** Delete after completion */
	private boolean deleteAfterCompletion;

	/** Constant value serial version UID */
	private static final long serialVersionUID = 1L;

	//////////////////////////////////////////////////
	// @@ Construction
	//////////////////////////////////////////////////

	/**
	 * Default constructor.
	 */
	public WorkflowTaskImpl()
	{
	}

	/**
	 * This method is just defined for compatibility to DisplayObject.
	 * Do not call!
	 * @return The base method return value
	 */
	public Object clone()
		throws CloneNotSupportedException
	{
		return super.clone();
	}

	/**
	 * @seem WorkflowTask.createName()
	 */
	public void createName()
	{
		setName(UUIDGenerator.getInstance().createUUID());
	}

	/**
	 * Returns a string representation of this object.
	 *
	 * @return The string in the form "Workflow task (id 1234)"
	 */
	public String toString()
	{
		return ToStringHelper.toString(this, new String [] { "id", "name", "displayName", "stepName", "statusStr" });
	}

	//////////////////////////////////////////////////
	// @@ Comparable implementation
	//////////////////////////////////////////////////

	/**
	 * Compares this object to another Object.
	 * If the object is a WorkflowTask, it will compar the {@link #setName} values of the two objects.
	 * Otherwise, it throws a ClassCastException (as WorkflowTasks are comparable only to other WorkflowTasks).
	 *
	 * @param o Object to be compared
	 * @return  The value 0 if the argument is a string lexicographically equal to this object;<br>
	 * a value less than 0 if the argument is a string lexicographically greater than this object;<br>
	 * and a value greater than 0 if the argument is a string lexicographically less than this object.
	 * @throws ClassCastException if the argument is not a WorkflowTask.
	 */
	public int compareTo(Object o)
	{
		WorkflowTask w1 = this;
		WorkflowTask w2 = (WorkflowTask) o;
		int ret;

		Integer p1 = Integer.valueOf(w1.getPriority());
		Integer p2 = Integer.valueOf(w2.getPriority());
		ret = CommonUtil.compareNull(p1, p2);
		if (ret != 0)
			return ret;

		Timestamp d1 = w1.getDueTime();
		Timestamp d2 = w2.getDueTime();
		ret = CommonUtil.compareNull(d1, d2);
		if (ret != 0)
			return ret;

		Timestamp c1 = w1.getTimeCreated();
		Timestamp c2 = w2.getTimeCreated();
		ret = CommonUtil.compareNull(c1, c2);
		if (ret != 0)
			return ret;

		String x1 = w1.getDisplayName();
		String x2 = w2.getDisplayName();
		ret = CommonUtil.compareNull(x1, x2);
		if (ret != 0)
			return ret;

		String y1 = w1.getName();
		String y2 = w2.getName();
		return CommonUtil.compareNull(y1, y2);
	}

	//////////////////////////////////////////////////
	// @@ DescriptionObject implemenation
	//////////////////////////////////////////////////

	/**
	 * @seem DescriptionObject.getDescriptionText()
	 */
	public String getDescriptionText()
	{
		return getDescription();
	}

	/**
	 * @seem DescriptionObject.getDisplayText()
	 */
	public String getDisplayText()
	{
		String n = getDisplayName();
		return n != null ? n : getName();
	}

	/**
	 * @seem DescriptionObject.getName()
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @seem DescriptionObject.setName(String name)
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @seem DisplayObject.getDisplayName()
	 */
	public String getDisplayName()
	{
		return displayName;
	}

	/**
	 * @seem DisplayObject.setDisplayName(String displayName)
	 */
	public void setDisplayName(String displayName)
	{
		this.displayName = displayName;
	}

	/**
	 * @seem DescriptionObject.getDescription()
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * @seem DescriptionObject.setDescription(String description)
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}

	//////////////////////////////////////////////////
	// @@ Property access
	//////////////////////////////////////////////////

	/**
	 * @seem WorkflowTask.getTimeCreated()
	 */
	public Timestamp getTimeCreated()
	{
		return timeCreated;
	}

	/**
	 * @seem WorkflowTask.setTimeCreated(Timestamp timeCreated)
	 */
	public void setTimeCreated(Timestamp timeCreated)
	{
		this.timeCreated = timeCreated;
	}

	/**
	 * @seem WorkflowTask.getTimeAccepted()
	 */
	public Timestamp getTimeAccepted()
	{
		return timeAccepted;
	}

	/**
	 * @seem WorkflowTask.setTimeAccepted(Timestamp timeAccepted)
	 */
	public void setTimeAccepted(Timestamp timeAccepted)
	{
		this.timeAccepted = timeAccepted;
	}

	/**
	 * @seem WorkflowTask.getTimeCompleted()
	 */
	public Timestamp getTimeCompleted()
	{
		return timeCompleted;
	}

	/**
	 * @seem WorkflowTask.setTimeCompleted(Timestamp timeCompleted)
	 */
	public void setTimeCompleted(Timestamp timeCompleted)
	{
		this.timeCompleted = timeCompleted;
	}

	/**
	 * @seem WorkflowTask.getCreatingUserId()
	 */
	public String getCreatingUserId()
	{
		return creatingUserId;
	}

	/**
	 * @seem WorkflowTask.setCreatingUserId(String creatingUserId)
	 */
	public void setCreatingUserId(String creatingUserId)
	{
		this.creatingUserId = creatingUserId;
	}

	/**
	 * @seem WorkflowTask.getAcceptingUserId()
	 */
	public String getAcceptingUserId()
	{
		return acceptingUserId;
	}

	/**
	 * @seem WorkflowTask.setAcceptingUserId(String acceptingUserId)
	 */
	public void setAcceptingUserId(String acceptingUserId)
	{
		this.acceptingUserId = acceptingUserId;
	}

	/**
	 * @seem WorkflowTask.getDueTime()
	 */
	public Timestamp getDueTime()
	{
		return dueTime;
	}

	/**
	 * @seem WorkflowTask.setDueTime(Timestamp dueTime)
	 */
	public void setDueTime(Timestamp dueTime)
	{
		this.dueTime = dueTime;
	}

	/**
	 * @seem WorkflowTask.getStatus()
	 */
	public int getStatus()
	{
		return status;
	}

	/**
	 * @seem WorkflowTask.setStatus(int status)
	 */
	public void setStatus(int status)
	{
		this.status = status;
	}

	/**
	 * @seem WorkflowTask.getTokenContext()
	 */
	public TokenContext getTokenContext()
	{
		return tokenContext;
	}

	/**
	 * @seem WorkflowTask.setTokenContext(TokenContext tokenContext)
	 */
	public void setTokenContext(TokenContext tokenContext)
	{
		this.tokenContext = tokenContext;
	}

	/**
	 * Sets the workflow tast status.
	 * This is a string parameter version of the {@link #setStatus} method.
	 * @param statusStr The status to be set or null for {@link WorkflowTask#STATUS_UNKNOWN}
	 */
	public void setStatusStr(String statusStr)
	{
		int status = STATUS_UNKNOWN;

		if (STATUS_STR_ENABLED.equals(statusStr))
			status = STATUS_ENABLED;
		else if (STATUS_STR_DISABLED.equals(statusStr))
			status = STATUS_DISABLED;
		else if (STATUS_STR_RESUMED.equals(statusStr))
			status = STATUS_RESUMED;
		else if (STATUS_STR_COMPLETED.equals(statusStr))
			status = STATUS_COMPLETED;
		else if (STATUS_STR_ERROR.equals(statusStr))
			status = STATUS_ERROR;

		setStatus(status);
	}

	/**
	 * Gets the workflow tast status.
	 * This is a string parameter version of the {@link #getStatus} method.
	 * @return The status or null for {@link WorkflowTask#STATUS_UNKNOWN}
	 */
	public String getStatusStr()
	{
		String statusStr = null;

		if (status == STATUS_ENABLED)
			statusStr = STATUS_STR_ENABLED;
		else if (status == STATUS_DISABLED)
			statusStr = STATUS_STR_DISABLED;
		else if (status == STATUS_RESUMED)
			statusStr = STATUS_STR_RESUMED;
		else if (status == STATUS_COMPLETED)
			statusStr = STATUS_STR_COMPLETED;
		else if (status == STATUS_ERROR)
			statusStr = STATUS_STR_ERROR;

		return statusStr;
	}

	//////////////////////////////////////////////////
	// @@ Copied from WorkflowTaskDescriptor
	//////////////////////////////////////////////////

	// The following methods are copied from WorkflowTaskDescriptor, since Java does not support multiple inheritance

	/**
	 * @seem WorkflowTask.getStepName()
	 */
	public String getStepName()
	{
		return stepName;
	}

	/**
	 * @seem WorkflowTask.setStepName(String stepName)
	 */
	public void setStepName(String stepName)
	{
		this.stepName = stepName;
	}

	/**
	 * @seem WorkflowTask.getStepDisplayName()
	 */
	public String getStepDisplayName()
	{
		return stepDisplayName;
	}

	/**
	 * @seem WorkflowTask.setStepDisplayName(String stepDisplayName)
	 */
	public void setStepDisplayName(String stepDisplayName)
	{
		this.stepDisplayName = stepDisplayName;
	}

	/**
	 * @seem WorkflowTask.getStepDescription()
	 */
	public String getStepDescription()
	{
		return stepDescription;
	}

	/**
	 * @seem WorkflowTask.setStepDescription(String stepDescription)
	 */
	public void setStepDescription(String stepDescription)
	{
		this.stepDescription = stepDescription;
	}

	/**
	 * @seem WorkflowTask.getRoleId()
	 */
	public String getRoleId()
	{
		return roleId;
	}

	/**
	 * @seem WorkflowTask.setRoleId(String roleId)
	 */
	public void setRoleId(String roleId)
	{
		this.roleId = roleId;
	}

	/**
	 * @seem WorkflowTask.getUserId()
	 */
	public String getUserId()
	{
		return userId;
	}

	/**
	 * @seem WorkflowTask.setUserId(String userId)
	 */
	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	/**
	 * @seem WorkflowTask.getPermissions()
	 */
	public String getPermissions()
	{
		return permissions;
	}

	/**
	 * @seem WorkflowTask.setPermissions(String permissions)
	 */
	public void setPermissions(String permissions)
	{
		this.permissions = permissions;
	}

	/**
	 * @seem WorkflowTask.getPriority()
	 */
	public int getPriority()
	{
		return priority;
	}

	/**
	 * @seem WorkflowTask.setPriority(int priority)
	 */
	public void setPriority(int priority)
	{
		this.priority = priority;
	}

	/**
	 * @seem WorkflowTask.isDeleteAfterCompletion()
	 */
	public boolean isDeleteAfterCompletion()
	{
		return deleteAfterCompletion;
	}

	/**
	 * @seem WorkflowTask.setDeleteAfterCompletion(boolean deleteAfterCompletion)
	 */
	public void setDeleteAfterCompletion(boolean deleteAfterCompletion)
	{
		this.deleteAfterCompletion = deleteAfterCompletion;
	}
}
