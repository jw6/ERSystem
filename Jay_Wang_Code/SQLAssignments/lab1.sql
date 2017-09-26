--2.1 SELECT
--Select all records from the Employee table
SELECT * FROM EMPLOYEE;
--Select all records from the Employee table where last name is King
SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King';
--Select all records from the Employee table where first name is Andrew and REPORTSTO is null
SELECT * FROM EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO = null;

--2.2 ORDER BY
--Select all albums in Albums table and sort result set in descending order by title
SELECT * FROM ALBUM ORDER BY TITLE DESC;
--Select first name from Customer and sort result set in ascending order by city

--2.3 INSERT INTO
--Insert two new records into Genre table
INSERT INTO GENRE(GENREID, NAME) VALUE(471, 'Tab genre');
INSERT INTO GENRE(GENREID, NAME) VALUE(472, 'Space genre');

--Insert two new records into Employee table
--Insert two new records into Customer table