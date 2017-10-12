--DDL for flashcard_db
/*
    Oracle DB objects:
        Table
        Function
        Stored Procedures aka Stored Proc
        View
        Triggers
        Sequences
*/
DROP TABLE flash_card;

CREATE TABLE flash_card(
fc_id INT,
fc_question VARCHAR2(4000) UNIQUE,
fc_answer VARCHAR2(4000),
PRIMARY KEY(fc_id)
);

--PL/SQL: Procedural Language SQL
  --Has flow control,and many objects
  
--SEQUENCES: used heavly for auto increments
CREATE SEQUENCE fc_seq
  START WITH 1
  INCREMENT BY 1;

SELECT * FROM DUAL;


/*---------------------------------------------------Triggers
CREATE [OR REPLACE] TRIGGER trig_name
BEFORE | AFTER  - INSERT | UPDATE | DELETE 
ON table_name
FOR EACH ROW 
DECLARE
BEGIN
EXCEPTION
END;
*/

--Triggers: Once a condition is met, fires off a stored procedure
CREATE OR REPLACE TRIGGER fc_seq_trigger 
BEFORE INSERT ON flash_card
FOR EACH ROW
BEGIN
  --Allowed to write flow control using PL/SQL
  SELECT fc_seq.nextval INTO :new.fc_id FROM DUAL;
END;
/
--Adjust the trigger to allow the user to input an ID manually
CREATE OR REPLACE TRIGGER fc_seq_trigger 
BEFORE INSERT ON flash_card
FOR EACH ROW
BEGIN
  --Allowed to write flow control using PL/SQL
  --add the IF statement
  IF :new.fc_id IS NULL THEN 
    SELECT fc_seq.nextval INTO :new.fc_id FROM DUAL;
  END IF;
END;
/

----------------------------------------------Stored Procedures
--CREATE [OR REPLACE] PROCEDURE proc_name [list of parameters]
--IS | AS 
--       *Declaration section*
--BEGIN
--       *Execution section*
--EXCEPTION
--       *Exception section*
--END;

CREATE OR REPLACE PROCEDURE hello_world_proc
IS
BEGIN
  DBMS_OUTPUT.PUT_LINE('Hello_world!');
END;
/

--Execute/Test my Stored Procedure
EXECUTE hello_world_proc;
EXEC hello_world_proc;

--Anon Function 
BEGIN
  HELLO_WORLD_PROC();
END;

--Stored Proc with Arguments: IN & OUT parameter types, not return value
CREATE OR REPLACE PROCEDURE insert_fc_proc(some_q IN VARCHAR2, 
                                          some_a IN flash_card.fc_answer%TYPE,
                                          fc_error_msg OUT VARCHAR2)
IS
BEGIN 
  INSERT INTO flash_card(FC_QUESTION,FC_ANSWER) VALUES(some_q,some_a);
  COMMIT;
EXCEPTION
  WHEN OTHERS THEN
    fc_error_msg := SQLERRM;
END;
/
--ANON FN to test insert_fc_proc
DECLARE
fc_msg VARCHAR2(4000);
BEGIN
  insert_fc_proc('Whats up doc?', 'I cant remember', fc_msg);
END;
/
--get a Fc's Answer Proc
CREATE OR REPLACE PROCEDURE get_answer_proc(some_q IN VARCHAR2,
                                            some_a OUT VARCHAR2)
IS
BEGIN
  SELECT fc_answer INTO some_a FROM flash_card WHERE fc_question = some_q;
END;
/

DECLARE
answer VARCHAR(4000);
BEGIN
  get_answer_proc('Is this a question?',answer);
   DBMS_OUTPUT.PUT_LINE('The answer to your question: ' || answer);
END;
/


---------------------------FUNCTIONS
CREATE OR REPLACE FUNCTION get_max_id
RETURN NUMBER
IS
 max_id NUMBER;
BEGIN
    --Use the system defined Aggregate MAX() fn
 SELECT MAX(fc_id) INTO max_id FROM flash_card;
 RETURN max_id;
END;
/
--Test the get_max_id()
DECLARE
  max_id NUMBER;
BEGIN
  max_id := get_max_id();
  DBMS_OUTPUT.PUT_LINE('The max id is: ' || max_id);
END;
/

--Finish this Function
CREATE OR REPLACE FUNCTION findMax(x IN NUMBER, y IN NUMBER)