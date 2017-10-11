INSERT INTO bank_tx_type VALUES (1, 'deposit');
INSERT INTO bank_tx_type VALUES (2, 'withdraw');
select * from bank_tx_type;
/
INSERT INTO bank_user(u_fn, u_ln, u_username, u_password) VALUES('Jay', 'Wang', 'jwang','jw123');
INSERT INTO bank_user(u_fn, u_ln, u_username, u_password) VALUES('John', 'Kyle', 'jkyle', 'jk123');
INSERT INTO bank_user(u_fn, u_ln, u_username, u_password) VALUES('Emily', 'Fisher', 'efisher', 'ef123');
INSERT INTO bank_user(u_fn, u_ln, u_username, u_password) VALUES('David', 'Mark', 'dmark', 'dm123');
INSERT INTO bank_user(u_fn, u_ln, u_username, u_password) VALUES('Bill', 'Gates', 'bgates', 'bgms');
INSERT INTO bank_user(u_fn, u_ln, u_username, u_password) VALUES('Paul', 'Scholes','pscholes','ps123');
/
delete from bank_user
where u_ln = 'wu';
/
select * from bank_user;
/
select * from bank_account;
/
select * from bank_tx; 
/
select * from bank_tx_type;
/
INSERT INTO bank_account(u_id) VALUES (5);
commit;
/
EXECUTE make_transaction(8, 10.1, 1);
/
EXECUTE get_balance_from_tx(1);
/
SELECT u_id, u_fn, u_ln FROM bank_user WHERE u_username='jwang' AND u_password='jw123';
/
SELECT ba_balance from BANK_ACCOUNT WHERE u_id = 3;