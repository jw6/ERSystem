--2.1 SELECT
--Select all records from the Employee table
/
SELECT * FROM EMPLOYEE;
/
--Select all records from the Employee table where last name is King
/
SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King';
/
--Select all records from the Employee table where first name is Andrew and REPORTSTO is null
/
SELECT * FROM EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;
/
--2.2 ORDER BY
--Select all albums in Albums table and sort result set in descending order by title
/
SELECT * FROM ALBUM ORDER BY TITLE DESC;
/
--Select first name from Customer and sort result set in ascending order by city
/
SELECT * FROM CUSTOMER ORDER BY CITY ASC;
/
--2.3 INSERT INTO
--Insert two new records into Genre table
/
INSERT INTO GENRE(GENREID, NAME) VALUES(471, 'Tab genre');
INSERT INTO GENRE(GENREID, NAME) VALUES(472, 'Space genre');
/
--Insert two new records into Employee table
/
INSERT INTO EMPLOYEE(EMPLOYEEID, LASTNAME, FIRSTNAME,TITLE) 
VALUES(121222, 'Bachman', 'Erlich', 'General Manager');
INSERT INTO EMPLOYEE(EMPLOYEEID, LASTNAME, FIRSTNAME) 
VALUES(329121,'Hendrick', 'Richard');
/
--Insert two new records into Customer table
/
INSERT INTO CUSTOMER(CUSTOMERID, LASTNAME, FIRSTNAME, EMAIL)
VALUES(12321,'Grey', 'Ryan', 'ryan@his.com');
INSERT INTO CUSTOMER(CUSTOMERID, LASTNAME, FIRSTNAME, EMAIL)
VALUES(123234,'Rooney', 'Mike', 'mike@rooney.com');
/
--2.4 UPDATE
--Update Aaron Mitchell in Customer table to Robert Walter
/
UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';
/
--Update name of artist in the Artist table "Creedence Clearwater Revival"  to "CCR"
/
UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';
/
--2.5 Like
--Select all invoices with a billing address like "T%"
/
SELECT * FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';
/
--2.6 Between
--Select all invoices that have a total between 15 and 50
/
SELECT * FROM INVOICE
WHERE (TOTAL BETWEEN 15 AND 50);
/
--Select all employees hired between 1st of June 2003 and 1st of March 2004 
/
SELECT * FROM EMPLOYEE
WHERE (HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04');
/
--2.7 Delete
--Delete a record in Customer table where the name is Robert Walter(There may
--be constraints that rely on this, find out how to resolve them).
/
SELECT * FROM CUSTOMER
WHERE CUSTOMERID = (SELECT CUSTOMERID FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter');
/
SELECT * FROM INVOICE
WHERE CUSTOMERID = 32;
/
-- Performing cascade deletion
DELETE FROM INVOICELINE
WHERE INVOICEID = (SELECT INVOICEID FROM INVOICE WHERE
CUSTOMERID = (SELECT CUSTOMERID FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter'));
/
DELETE FROM INVOICE
WHERE CUSTOMERID = (SELECT CUSTOMERID FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter');
/
DELETE FROM CUSTOMER
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';
/
--3.0 SQL Function
--3.1 System Defined Function
--Create a function that returns the current time
/
CREATE OR REPLACE FUNCTION get_current_time
return date is
    l_sysdate date;
    
begin
    SELECT sysdate
    INTO l_sysdate
    FROM dual;
    
    RETURN l_sysdate;
end;
/
SELECT get_current_time() FROM dual;
/
--Create a function taht returns the length of a mediatype from the mediatype table
/
CREATE OR REPLACE FUNCTION get_length
return 
--3.2 System Defined Aggregate Functions
--Create a function that returns the avearge total of all invoices
--Create a function that returns the most expensive tracks

--3.3 User define scalar function
--Create a function that returns the average price of invoiceline items in the invoiceline table

--3.4 User defined table valued functions
--Create a function that returns all employees who are born after 1968

--4.0 Stored Procedure
--4.1 Basic stored procedure
--Create stored procedure that selects the first and last names of all the employees
--4.2 Store procedure input paramets 
--Create a stored procedure that updates the personal information of an employee
--Create a stored procedure that returns the managers of an employee
--4.3 Store procedure output parameters

--5.0 Transactions
--Create a transaction that givena invoiced will delete that invoice(There may be constraints
--that rely on this, find out how to resolve them

--6.0 Triggers
--6.1 
--Create an after insert trigger on the employee table fired after a new record is inserted
--into the table
--Create an after update trigger on the album table that fires after a row is inserted in the table
--Create an after delete trigger on the customer table that fires after a row is deleted from the table

--7.0 Joins
--7.1 Inner
--Create an inner join that joins customers and orders and specifies the name of the customer
--and the invoiceid
/
SELECT c.firstname || ' '|| c.lastname AS "Customer", i.invoiceid AS "Invoice ID"
FROM CUSTOMER c
INNER JOIN INVOICE i ON c.customerid = i.customerid;
/
--7.2 Outer
--Create an outer join that joins the customer and invoice table, specifying the CustomerId,
--firstname, lastname, invoiceId, and total
/
SELECT c.customerid AS "Customer ID", c.firstname || ' '|| c.lastname AS "Name", i.invoiceid AS "Invoice",
i.total AS "Total"
FROM CUSTOMER c
FULL OUTER JOIN INVOICE i ON c.customerid = i.customerid;
/
--7.3 Right
--Create a right join that joins album and artist specifying artist name and titles

--7.4 Cross
--Create a cross join that joins album and artist and sorts by artist name in the ascending order
--7.5 Self
--Perform a self-join on the employee table, joining on the reportsto column

--9.0
--make it .bak file