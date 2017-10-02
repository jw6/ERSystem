-------Sequences---------
create SEQUENCE ba_id_inc_seq start with 1 increment by 1;
/
create SEQUENCE tx_id_inc_seq start with 1 increment by 1;
/
create SEQUENCE u_id_inc_seq start with 1 increment by 1;
/

-------Triggers-----------
create or replace TRIGGER ba_id_inc_trig
before insert on bank_account
for each row
    begin
    if :new.ba_id IS NULL THEN
        SELECT ba_id_inc_seq.nextval INTO :new.ba_id FROM dual;
    END if;
END;
/
create or replace TRIGGER tx_id_inc_trig
before insert on bank_tx
for each row
    begin
    if :new.tx_id IS NULL THEN
        SELECT tx_id_inc_seq.nextval INTO :new.tx_id FROM dual;
    END if;
END;
/
create or replace TRIGGER u_id_inc_trig
before insert on bank_user
for each row
    begin
    if :new.u_id IS NULL THEN
        SELECT u_id_inc_seq.nextval INTO :new.u_id FROM dual;
    END if;
END;