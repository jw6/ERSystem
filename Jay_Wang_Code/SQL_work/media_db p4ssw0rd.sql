--DDL Script
--Data Definition Language
--Define our object e.g. Tables, triggers, sequences etc

/*
    Oracle Datatype
        VARCHAR2 - no string
        NUMBER - only number, shorthand like int, double but converts to NUMBER(38,0)
*/

--make a table, not case-sensitive, seprate by _, not camel casing
CREATE TABLE actor (
  act_name VARCHAR2(4000),
  act_film VARCHAR2(4000),
  act_year_in_media INT
);