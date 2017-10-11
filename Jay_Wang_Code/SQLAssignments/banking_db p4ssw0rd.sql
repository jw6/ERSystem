--DDL script for banking_db

create table bank_user (
u_id            INT,
u_fn            VARCHAR2(4000),
u_ln            VARCHAR2(4000),
u_username      VARCHAR2(4000)  UNIQUE NOT NULL,
u_password      VARCHAR2(4000)  NOT NULL,
PRIMARY KEY     (u_id)
);

create table bank_account (
ba_id           INT,
ba_balance      NUMBER(36,2)        DEFAULT(0)  NOT NULL,
u_id            INT                 NOT NULL,
PRIMARY KEY     (ba_id),
FOREIGN KEY     (u_id)              REFERENCES bank_user(u_id)
);

--Lookup table 1-deposit 2-withdraw
create table bank_tx_type (
btt_id          INT,
btt_type        VARCHAR2(4000)      UNIQUE,
PRIMARY KEY     (btt_id)
);

create table bank_tx (
tx_id           INT,
ba_id           INT                 NOT NULL,
btt_id          INT,
tx_amount       NUMBER(36,2),
tx_date         TIMESTAMP,
PRIMARY KEY     (tx_id),
FOREIGN KEY     (ba_id)             REFERENCES bank_account(ba_id),
FOREIGN KEY     (btt_id)            REFERENCES bank_tx_type(btt_id)
);
/
commit;

