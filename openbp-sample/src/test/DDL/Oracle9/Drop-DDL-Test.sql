CREATE TABLE VACATIONDATA (
	VAC_ID INTEGER NOT NULL,
	VAC_SUBMITTER_NAME VARCHAR(40),
	VAC_SUBMITTER_EMAIL VARCHAR(40),
	VAC_STATE INTEGER,
	VAC_REASON VARCHAR(40),
	VAC_FROM_DATE DATE,
	VAC_TO_DATE DATE,
	PRIMARY KEY (VAC_ID)
);
