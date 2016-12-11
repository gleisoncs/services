CREATE TABLE CUSTOMER (
	UUID VARCHAR(60),
	FIRST_NAME varchar(100) NOT NULL,
	LAST_NAME varchar(100) NOT NULL,
	USERNAME varchar(100) NOT NULL,
	LAST_MODIFIED_DATE DATE,
	VERSION INT
);
INSERT INTO CUSTOMER(UUID, FIRST_NAME, LAST_NAME, USERNAME, LAST_MODIFIED_DATE, VERSION) values ('1', 'Fernanda', 'Vieira', 'veirinha', NULL, 1);