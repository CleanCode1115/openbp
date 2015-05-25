CREATE TABLE OPENBPTOKENCONTEXT (
	TC_ID VARCHAR2(40 CHAR) CONSTRAINT TC_ID_NN NOT NULL,
	TC_VERSION NUMBER(10,0) CONSTRAINT TC_VERSION_NN NOT NULL,
	TC_LIFECYCLE_STATE NUMBER(10,0),
	TC_LIFECYCLE_REQUEST NUMBER(10,0),
	TC_EXECUTING_MODEL VARCHAR2(250 CHAR),
	TC_CURRENT_SOCKET VARCHAR2(250 CHAR),
	TC_QUEUE_TYPE VARCHAR2(50 CHAR),
	TC_USER_ID VARCHAR2(40 CHAR),
	TC_DEBUGGER_ID VARCHAR2(20 CHAR),
	TC_NODE_ID VARCHAR2(100 CHAR),
	TC_PRIORITY NUMBER(10,0),
	TC_PROGRESS_COUNT NUMBER(10,0),
	TC_PROGRESS_TOTAL NUMBER(10,0),
	TC_PROGRESS_TEXT VARCHAR2(250 CHAR),
	TC_DATA BLOB,
	TC_PARENT_ID VARCHAR2(40),
	CONSTRAINT TC_PK PRIMARY KEY(TC_ID) USING INDEX PCTFREE 10
) PCTFREE 10;

CREATE TABLE OPENBPWORKFLOWTASK (
	TASK_ID VARCHAR2(40 CHAR) CONSTRAINT TASK_ID_NN NOT NULL,
	TASK_VERSION NUMBER(10,0) CONSTRAINT TASK_VERSION_NN NOT NULL,
	TASK_NAME VARCHAR2(40 CHAR),
	TASK_DISPLAY_NAME VARCHAR2(200 CHAR),
	TASK_DESCRIPTION VARCHAR2(255 CHAR),
	TASK_STEP_NAME VARCHAR2(40 CHAR),
	TASK_STEP_DISPLAYNAME VARCHAR2(200 CHAR),
	TASK_STEP_DESCRIPTION VARCHAR2(255 CHAR),
	TASK_ROLE_ID VARCHAR2(40 CHAR),
	TASK_USER_ID VARCHAR2(40 CHAR),
	TASK_PERMISSIONS VARCHAR2(255 CHAR),
	TASK_TIME_CREATED TIMESTAMP,
	TASK_TIME_ACCEPTED TIMESTAMP,
	TASK_TIME_COMPLETED TIMESTAMP,
	TASK_CREATING_USER_ID VARCHAR2(40 CHAR),
	TASK_ACCEPTING_USER_ID VARCHAR2(40 CHAR),
	TASK_PRIORITY NUMBER(10,0),
	TASK_DUE_TIME TIMESTAMP,
	TASK_STATUS NUMBER(10,0),
	TASK_DELETE_AFTER_COMPLETION NUMBER(1,0),
	TASK_CONTEXT_ID VARCHAR2(40 CHAR) CONSTRAINT TASK_CONTEXT_NN NOT NULL,
	CONSTRAINT TASK_PK PRIMARY KEY(TASK_ID) USING INDEX PCTFREE 10
) PCTFREE 10;


CREATE INDEX TC_PARENT_FK
	ON OPENBPTOKENCONTEXT(TC_PARENT_ID);

CREATE INDEX TC_PRIORITY_IND
	ON OPENBPTOKENCONTEXT(TC_PRIORITY);

ALTER TABLE OPENBPTOKENCONTEXT 
	ADD CONSTRAINT TC_PARENT_FK 
	FOREIGN KEY(TC_PARENT_ID) 
	REFERENCES OPENBPTOKENCONTEXT(TC_ID);

ALTER TABLE OPENBPWORKFLOWTASK 
	ADD CONSTRAINT TASK_TC_FK 
	FOREIGN KEY(TASK_CONTEXT_ID) 
	REFERENCES OPENBPTOKENCONTEXT(TC_ID);
