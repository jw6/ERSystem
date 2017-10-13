
----------------Create User----------------
CREATE USER ERSystem IDENTIFIED BY p4ssw0rd;
GRANT DBA TO ERSystem;
commit;
------------------Tables------------------
CREATE TABLE role_type(
 rt_id INT,
 rt_type VARCHAR2(4000) UNIQUE,
 PRIMARY KEY(rt_id)
);
/
CREATE TABLE ers_user(
 ers_id INT,
 ers_fn VARCHAR2(4000),
 ers_ln VARCHAR2(4000),
 ers_username VARCHAR2(4000) UNIQUE NOT NULL,
 ers_password VARCHAR2(4000) NOT NULL,
 rt_id INT DEFAULT 1 NOT NULL,
 ers_email VARCHAR2(4000),
 PRIMARY KEY(ers_id),
 FOREIGN KEY(rt_id) REFERENCES role_type(rt_id)
);
/
--Lookup table 
CREATE TABLE reimbursement_type(
 rbt_id INT,
 rbt_type VARCHAR2(4000) UNIQUE,
 PRIMARY KEY(rbt_id)
);
/
--Lookup table 1-Pending, 2-Approved, 3-Denied
CREATE TABLE status_type(
 st_id INT,
 st_name VARCHAR2(4000) UNIQUE,
 PRIMARY KEY(st_id)
);
/
CREATE TABLE reimbursement(
 rb_id INT,
 ers_id INT NOT NULL,
 st_id INT DEFAULT 1 NOT NULL,
 manager_id INT,
 rbt_id INT,
 rb_amount NUMBER(10,2),
 rb_submitted TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
 rb_resolved TIMESTAMP,
 rb_description VARCHAR2(4000),
 rb_receipt BLOB,
 PRIMARY KEY(rb_id),
 FOREIGN KEY(ers_id) REFERENCES ers_user(ers_id),
 FOREIGN KEY(st_id) REFERENCES status_type(st_id),
 FOREIGN KEY(manager_id) REFERENCES ers_user(ers_id),
 FOREIGN KEY(rbt_id) REFERENCES reimbursement_type(rbt_id)
);
/
commit;
/
----------------Sequences and triggers-----------------------
CREATE SEQUENCE role_type_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE ers_user_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE reimbursement_type_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE status_type_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE reimbursement_seq START WITH 1 INCREMENT BY 1;
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
CREATE OR REPLACE TRIGGER ers_user_seq_trg
BEFORE INSERT ON ers_user
FOR EACH ROW
BEGIN
IF :new.ers_id IS NULL THEN
  SELECT ers_user_seq.NEXTVAL INTO :new.ers_id FROM dual;
END IF;
END;
/
CREATE OR REPLACE TRIGGER reimbursement_type_seq_trg
BEFORE INSERT ON reimbursement_type
FOR EACH ROW
BEGIN
IF :new.rbt_id IS NULL THEN
  SELECT reimbursement_type_seq.NEXTVAL INTO :new.rbt_id FROM dual;
END IF;
END;
/
CREATE OR REPLACE TRIGGER status_type_seq_trg
BEFORE INSERT ON status_type
FOR EACH ROW
BEGIN
IF :new.st_id IS NULL THEN
  SELECT status_type_seq.NEXTVAL INTO :new.st_id FROM dual;
END IF;
END;
/
CREATE OR REPLACE TRIGGER reimbursement_seq_trg
BEFORE INSERT ON reimbursement
FOR EACH ROW
BEGIN
IF :new.rb_id IS NULL THEN
  SELECT reimbursement_seq.NEXTVAL INTO :new.rb_id FROM dual;
END IF;
END;
/
commit;

/
INSERT INTO role_type(rt_type) VALUES ('Manager');
INSERT INTO role_type(rt_type) VALUES ('Employee');
/
INSERT INTO status_type (st_name) VALUES ('Pending');
INSERT INTO status_type (st_name) VALUES ('Approved');
INSERT INTO status_type (st_name) VALUES ('Denied');
/
commit;
/
INSERT INTO ers_user (ers_fn, ers_ln, ers_username, ers_password, ers_email) VALUES ('Dinash', 'Chugtai', 'Dinash', 'd123', 'jaywang007@yahoo.com');
INSERT INTO ers_user (ers_fn, ers_ln, ers_username, ers_password, rt_id, ers_email) VALUES ('Jared', 'Dunn', 'Jared', 'j123', 2, 'jaywang007@yahoo.com');
commit;
/ 
SELECT * FROM ers_user WHERE ERS_username = 'Dinash';

