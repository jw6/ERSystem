--2.1 SELECT
--Select all records from the Employee table
SELECT * FROM EMPLOYEE;
--Select all records from the Employee table where last name is King
SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King';
--Select all records from the Employee table where first name is Andrew and REPORTSTO is null
SELECT * FROM EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;

--2.2 ORDER BY
--Select all albums in Albums table and sort result set in descending order by title
SELECT * FROM ALBUM ORDER BY TITLE DESC;
--Select first name from Customer and sort result set in ascending order by city
SELECT * FROM CUSTOMER ORDER BY CITY ASC;

--2.3 INSERT INTO
--Insert two new records into Genre table
INSERT INTO GENRE(GENREID, NAME) VALUES(471, 'Tab genre');
INSERT INTO GENRE(GENREID, NAME) VALUES(472, 'Space genre');
--Insert two new records into Employee table
INSERT INTO EMPLOYEE(EMPLOYEEID, LASTNAME, FIRSTNAME,TITLE) 
VALUES(121222, 'Bachman', 'Erlich', 'General Manager');

INSERT INTO EMPLOYEE(EMPLOYEEID, LASTNAME, FIRSTNAME) 
VALUES(329121,'Hendrick', 'Richard');
--Insert two new records into Customer table
INSERT INTO CUSTOMER(CUSTOMERID, LASTNAME, FIRSTNAME, EMAIL)
VALUES(12321,'Grey', 'Ryan', 'ryan@his.com');

INSERT INTO CUSTOMER(CUSTOMERID, LASTNAME, FIRSTNAME, EMAIL)
VALUES(123234,'Rooney', 'Mike', 'mike@rooney.com');

--2.4 UPDATE
--Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';
--Update name of artist in the Artist table "Creedence Clearwater Revival"  to "CCR"
UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';

--2.5 Like
--Select all invoices with a billing address like "T%"
SELECT * FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';

--2.6 Between
--Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE
WHERE (TOTAL BETWEEN 15 AND 50);
--Select all employees hired between 1st of June 2003 and 1st of March 2004 