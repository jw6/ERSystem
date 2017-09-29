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
CREATE OR REPLACE FUNCTION get_mediatype_length 
(
  mediatype_id IN NUMBER 
) 
RETURN NUMBER AS 
media_name_length NUMBER :=0;
BEGIN
  SELECT LENGTH(name) INTO media_name_length 
  FROM mediatype 
  WHERE mediatypeid = mediatype_id;
  RETURN media_name_length;
END get_mediatype_length;
/
SELECT get_mediatype_length(2) FROM dual;
/
--3.2 System Defined Aggregate Functions
--Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION average_of_total_invoice
RETURN NUMBER AS average NUMBER(8, 2);
BEGIN
    SELECT AVG(total) INTO average FROM INVOICE;
    RETURN average;
END average_of_total_invoice;
/
SELECT average_of_total_invoice FROM dual;
/
--Create a function that returns the most expensive tracks
CREATE OR REPLACE FUNCTION most_expensive_track
RETURN NUMBER AS high_price NUMBER(8,2);
BEGIN
    SELECT MAX(unitprice) INTO high_price FROM TRACK;
    RETURN high_price;
END most_expensive_track;
/
SELECT most_expensive_track FROM dual;
/
--3.3 User define scalar function
--Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION average_price_invoiceline(invoice_number IN NUMBER)
RETURN NUMBER AS average NUMBER(8,2);
BEGIN
    SELECT AVG(unitprice * quantity) INTO average
    FROM INVOICELINE
    WHERE invoiceid = invoice_number;
    RETURN average;
END average_price_invoiceline;
/
SELECT average_price_invoiceline(1) FROM dual;    
/
--3.4 User defined table valued functions
--Create a function that returns all employees who are born after 1968
create or replace function age_finder
(
    minimum_age IN NUMBER, 
    employee_list OUT SYS_REFCURSOR
) AS
BEGIN 
    OPEN employ_list FOR
        SELECT firstname, lastname
        FROM EMPLOYEE
        WHERE EXTRACT (YEAR FROM birthdate) > minimum_age;
END age_finder;

--4.0 Stored Procedure
--4.1 Basic stored procedure
--Create stored procedure that selects the first and last names of all the employees
create or replace PROCEDURE get_first_last_name AS CURSOR emp_cur IS
    SELECT firstname, lastname FROM EMPLOYEE;
    emp_rec emp_cur%rowtype;
BEGIN
FOR emp_rec IN emp_cur
    LOOP
        DBMS_OUTPUT.PUT_LINE(emp_rec.firstname || ' '||emp_rec.lastname);
    END LOOP;
END get_first_last_name;
/

exec get_first_last_name();
--4.2 Store procedure input paramets 
--Create a stored procedure that updates the personal information of an employee
/
create or replace PROCEDURE update_info
    (
      p_employeeid IN NUMBER ,
      p_lastname   IN VARCHAR2 ,
      p_firstname  IN VARCHAR2 ,
      p_title      IN VARCHAR2 DEFAULT NULL ,
      p_reportsto  IN NUMBER DEFAULT NULL ,
      p_birthdate  IN DATE DEFAULT NULL ,
      p_hiredate   IN DATE DEFAULT NULL ,
      p_address    IN VARCHAR2 DEFAULT NULL ,
      p_city       IN VARCHAR2 DEFAULT NULL ,
      p_state      IN VARCHAR2 DEFAULT NULL ,
      p_country    IN VARCHAR2 DEFAULT NULL ,
      p_postalcode IN VARCHAR2 DEFAULT NULL ,
      p_phone      IN VARCHAR2 DEFAULT NULL ,
      p_fax        IN VARCHAR2 DEFAULT NULL ,
      p_email      IN VARCHAR2 DEFAULT NULL 
    )
  IS
  BEGIN
    UPDATE EMPLOYEE
    SET 
      FIRSTNAME      = p_firstname ,
      LASTNAME       = p_lastname ,
      TITLE          = p_title ,
      REPORTSTO      = p_reportsto ,
      BIRTHDATE      = p_birthdate ,
      HIREDATE       = p_hiredate ,
      ADDRESS        = p_address ,
      CITY           = p_city ,
      STATE          = p_state ,
      COUNTRY        = p_country ,
	  POSTALCODE     = p_postalcode ,
      PHONE          = p_phone ,
      FAX            = p_fax ,
      EMAIL          = p_email
    WHERE EMPLOYEEID = p_employeeid;
  END;
/
--Create a stored procedure that returns the managers of an employee
create or replace PROCEDURE get_manager_info
(
    employee_id IN NUMBER
)
AS manager_name VARCHAR(50);
BEGIN
    SELECT firstname || ' '|| lastname INTO manager_name
    FROM EMPLOYEE WHERE employee_id = employeeid;   
    DBMS_OUTPUT.PUT_LINE(manager_name);
END get_manager_info;
/
    
--4.3 Store procedure output parameters
-- returns the name and company of a customer
create or replace PROCEDURE get_customer_name_company 
(
  customer_id       IN NUMBER, 
  customer_name     OUT VARCHAR2,
  customer_company  OUT VARCHAR2 
) AS 
BEGIN
  SELECT firstname || ' ' || lastname, company INTO customer_name, customer_company
  FROM customer 
  WHERE customerid = customer_id;
END get_customer_name_company;
/
DECLARE
	l_name VARCHAR2(50);
	l_company VARCHAR2(50);
BEGIN
	get_customer_name_company(1, l_name, l_company);
	dbms_output.put_line(l_name || ' ' || l_company);
END;
/

--5.0 Transactions
--Create a transaction that given a invoiceid will delete that invoice(There may be constraints
--that rely on this, find out how to resolve them
create or replace PROCEDURE delete_invoice 
(
  invoice_id IN NUMBER 
) AS 
BEGIN
  DELETE FROM invoiceline 
  WHERE invoiceid = invoice_id;
  
  DELETE FROM invoice       
  WHERE invoiceid = invoice_id;
END DELETE_invoice;
/

execute delete_invoice(1);
/
--create a transaction nested within a stored procedure that inserts a new record  in the
--customer  table
create or replace PROCEDURE insert_customer
(
      customer_id    IN NUMBER,
      first_name     IN VARCHAR2,
      last_name      IN VARCHAR2,
      p_company      IN VARCHAR2 DEFAULT NULL,
      p_address      IN VARCHAR2 DEFAULT NULL,
      p_city         IN VARCHAR2 DEFAULT NULL,
      p_state        IN VARCHAR2 DEFAULT NULL,
      p_country      IN VARCHAR2 DEFAULT NULL,
      postal_code    IN VARCHAR2 DEFAULT NULL,
      p_phone        IN VARCHAR2 DEFAULT NULL,
      p_fax          IN VARCHAR2 DEFAULT NULL,
      p_email        IN VARCHAR2,
      support_rep_id IN NUMBER DEFAULT NULL
)
  IS
  BEGIN
    INSERT
    INTO customer
      (
        customerid,
        firstname,
        lastname,
        company,
        address,
        city,
        state,
        country,
        postalcode,
        phone,
        fax,
        email,
        supportrepid
      )
      VALUES
      (
        customer_id,
        first_name,
        last_name,
        p_company,
        p_address,
        p_city,
        p_state,
        p_country,
        postal_code,
        p_phone,
        p_fax,
        p_email,
        support_rep_id
      );
  END;
/

--6.0 Triggers
--6.1 
--Create an after insert trigger on the employee table fired after a new record is inserted
--into the table
create or replace TRIGGER employee_insert_trigger
AFTER INSERT ON employee 
FOR EACH ROW
BEGIN
  IF :new.hiredate IS NULL THEN
      dbms_output.put_line('No hiredate entered for ' || :new.firstname || ' ' || :new.lastname);
  END IF;
END;
/
INSERT INTO employee VALUES (10, 'NoInfo', 'paul', NULL, NULL, NULL,
      NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
commit;

--Create an after update trigger on the album table that fires after a row is inserted in the table
create or replace TRIGGER album_update_trigger
AFTER UPDATE ON album 
FOR EACH ROW
BEGIN
  IF :new.title <> :old.title THEN
      dbms_output.put_line('old title: ' || :old.title || ' new title: ' || :new.title);
  END IF;
END;
/
UPDATE album SET title='Beatles old albums' WHERE albumid=1;
commit;
/

--Create an after delete trigger on the customer table that fires after a row is deleted from the table
create or replace TRIGGER customer_delete_trigger
AFTER DELETE ON customer 
FOR EACH ROW
BEGIN
  dbms_output.put_line('Dropped customer ' || :old.firstname || ' ' || :old.lastname);
END;
/
DELETE FROM customer WHERE customerid=62;
commit;

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
/
SELECT ar.name AS "Artist", al.title AS "Title"
FROM ALBUM al
RIGHT JOIN ARTIST ar ON al.artistid = ar.artistid;
/
--7.4 Cross
--Create a cross join that joins album and artist and sorts by artist name in the ascending order
/
SELECT *
FROM ARTIST ar
CROSS JOIN ALBUM al
ORDER BY ar.name ASC;
/
--7.5 Self
--Perform a self-join on the employee table, joining on the reportsto column
SELECT *
FROM EMPLOYEE e1
LEFT JOIN EMPLOYEE e2 ON e1.reportsto = e2.reportsto;
/
--9.0
--make it .bak file