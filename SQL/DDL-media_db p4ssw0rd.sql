--DDL Script
--Data Definition Language
--Define our object e.g. Tables, triggers, sequences etc

/*
    Oracle Datatypes
        VARCHAR2 - no string
        NUMBER  - only number, shorthand like int, double but converts to NUMBER(38,0)
*/

--make a table, not case-sensitive, separate by _, not camel casing
CREATE TABLE actor (
  act_name VARCHAR2(4000),
  act_film VARCHAR2(4000),
  act_years_in_media INT
);


--First I have to have access to DBA to create users
--Creating users will create a new database

--Create user and make new database
CREATE USER media_db IDENTIFIED BY p4ssw0rd;

--Must Grant new user permissions
GRANT CONNECT, RESOURCE TO media_db;

--Run script vs Run Statement
--Green Plus to connect to that new database/user
--switch to media_db

--DDL
-----------------------------CREATE TABLE
CREATE TABLE actor (
act_name VARCHAR2(50),
act_film VARCHAR2(50),
act_birth_date DATE,
act_address VARCHAR2(100),
act_years_in_media NUMBER(8,2)
);

-----------------------------ALTER TABLE

--Add columns
ALTER TABLE actor
ADD ( act_first_name VARCHAR2(50),
        act_last_name VARCHAR2(50) );

--Remove columns
ALTER TABLE actor
DROP COLUMN act_name;

--Change column name
ALTER TABLE actor
RENAME COLUMN act_address TO act_street;

--Change column datatype
--Note it won't be allowed while data is currently being stored
ALTER TABLE actor
 MODIFY (ACT_YEARS_IN_MEDIA NUMBER(9,2));
 -- Number(digits,spaces from right place decimal
 -- Add ( ) after modify to remove syntax error but would compile without it

-----------------------------DROP TABLE
DROP TABLE actor;







/*
AFTER BASICS!
*/
-----------------------------CREATE TABLE
CREATE TABLE actor (
act_id INTEGER,
act_name VARCHAR2(50),
act_film VARCHAR2(50),
act_birth_date DATE,
act_address VARCHAR2(100),
act_years_in_media NUMBER(8,2),
act_time_signed_contract TIMESTAMP,
PRIMARY KEY (act_id)
);

-----------------------------DROP TABLE

DROP TABLE actor_role;
DROP TABLE role_type;
DROP TABLE actor;

--Movie Role
CREATE TABLE role_type(
role_id INTEGER,
role_type VARCHAR2(40) UNIQUE NOT NULL,
PRIMARY KEY(role_id)
);

CREATE TABLE actor_role(
  act_id INTEGER,
  role_id INTEGER,
  PRIMARY KEY(act_id, role_id),
  FOREIGN KEY (act_id) REFERENCES actor(act_id),
  FOREIGN KEY (role_id)  REFERENCES role_type(role_id) --Primary key must be specified on the other table
  
);

-----------------------------Add Cascade
CREATE TABLE actor_role(
  act_id INTEGER,
  role_id INTEGER,
  PRIMARY KEY(act_id, role_id),
  FOREIGN KEY (act_id) REFERENCES actor(act_id)  ON DELETE CASCADE,
  FOREIGN KEY (role_id)  REFERENCES role_type(role_id) ON DELETE CASCADE --Primary key must be specified on the other table
  
);