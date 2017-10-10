
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