CREATE TABLE Customer (
customerid          integer primary key,
customer_first_name varchar2(50),
customer_last_name  varchar2(50)
);
/
create sequence c_seq
start with 1
increment by 1;
/
create or replace trigger c_seq_trigger
before insert on customer
for each row
begin
if :new.customerid is null then
select c_seq.nextval into :new.customerid from dual;
end if;
end;