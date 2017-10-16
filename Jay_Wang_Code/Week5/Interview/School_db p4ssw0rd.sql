-------------Create User--------------------
CREATE USER School_db IDENTIFIED BY p4ssw0rd;
GRANT DBA TO School_db;
commit;
-------------Create Tables------------------
CREATE TABLE role_type(
 rt_id INT,
 rt_type VARCHAR2(4000) UNIQUE,
 PRIMARY KEY(rt_id)
);
/
CREATE TABLE users(
 user_id INT,
 user_fn VARCHAR2(4000),
 user_ln VARCHAR2(4000),
 user_username VARCHAR2(4000) UNIQUE NOT NULL,
 user_password VARCHAR2(4000) NOT NULL,
 rt_id INT DEFAULT 1 NOT NULL,
 user_email VARCHAR2(4000),
 PRIMARY KEY(user_id),
 FOREIGN KEY(rt_id) REFERENCES role_type(rt_id)
);

INSERT INTO users(user_fn, user_ln, user_username, user_password, user_email) 
VALUES ('Jay', 'Wang', 'jay', 'abc123', 'jaywang007@yahoo.com');

INSERT INTO users(user_fn, user_ln, user_username, user_password, user_email) 
VALUES ('Tim', 'Ingle', 'Tim', 'abc123', 'jaywang007@yahoo.com');

INSERT INTO users(user_fn, user_ln, user_username, user_password,rt_id, user_email) 
VALUES ('Steve', 'Kelsey', 'steve', 'abc123', 2,'jwang3255@yahoo.com');


select * from users;
/
commit;
/
CREATE SEQUENCE role_type_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE user_seq START WITH 1 INCREMENT BY 1;
/
CREATE OR REPLACE TRIGGER role_type_seq_trg
BEFORE INSERT ON role_type
FOR EACH ROW
BEGIN
IF :new.rt_id IS NULL THEN
  SELECT role_type_seq.NEXTVAL INTO :new.rt_id FROM dual;
END IF;
END;
/
CREATE OR REPLACE TRIGGER user_seq_trg
BEFORE INSERT ON users
FOR EACH ROW
BEGIN
IF :new.user_id IS NULL THEN
  SELECT user_seq.NEXTVAL INTO :new.user_id FROM dual;
END IF;
END;
/
commit;
/
INSERT INTO role_type(rt_type) VALUES ('student');
INSERT INTO role_type(rt_type) VALUES ('teacher');

select * from role_type;