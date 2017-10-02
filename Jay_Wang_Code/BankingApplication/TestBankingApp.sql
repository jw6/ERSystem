INSERT INTO bank_tx_type VALUES (1, 'deposit');
INSERT INTO bank_tx_type VALUES (2, 'withdraw');
select * from bank_tx_type;
/
INSERT INTO bank_user(u_fn, u_ln, u_username, u_password) VALUES('Jay', 'Wang', 'jwang','jw123');
INSERT INTO bank_user(u_fn, u_ln, u_username, u_password) VALUES('John', 'Kyle', 'jkyle', 'jk123');
INSERT INTO bank_user(u_fn, u_ln, u_username, u_password) VALUES('Emily', 'Fisher', 'efisher', 'ef123');
INSERT INTO bank_user(u_fn, u_ln, u_username, u_password) VALUES('David', 'Mark', 'dmark', 'dm123');
INSERT INTO bank_user(u_fn, u_ln, u_username, u_password) VALUES('Bill', 'Gates', 'bgates', 'bgms');
/
select * from bank_user;
/
select * from bank_account;
/
select * from bank_tx;
/
select * from bank_tx_type;
/
INSERT INTO bank_account(ba_balance, u_id) VALUES (4);
commit;
/
EXECUTE make_transaction(6, 100, 2);
/
EXECUTE get_balance_from_tx(1);
/
