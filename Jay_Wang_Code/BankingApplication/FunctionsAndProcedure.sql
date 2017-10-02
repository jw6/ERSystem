-------Functions-----------
create or replace FUNCTION get_balance_from_tx(ba_id_in IN INT)
RETURN NUMBER
IS
  deposit NUMBER;
  withdraw NUMBER;
BEGIN
  SELECT SUM(tx_amount) INTO deposit FROM bank_tx WHERE ba_id = ba_id_in AND btt_id = 1;
  IF deposit IS NULL THEN 
    deposit := 0;
  END IF;
  
  SELECT SUM(tx_amount) INTO withdraw FROM bank_tx WHERE ba_id = ba_id_in AND btt_id = 2;
  if withdraw IS NULL THEN
    withdraw := 0;
  END IF;
  RETURN deposit - withdraw;
END;
/

create or replace FUNCTION get_u_id_from_ba_tx（baID IN INT)
RETURN
    NUMBER
AS  
    userID NUMBER;
BEGIN
    SELECT u_id INTO userID FROM bank_account WHERE ba_id = baID;
    RETURN userID;
END;
/

CREATE OR REPLACE PROCEDURE make_transaction(ba_id_in IN INT, tx_amount_in IN NUMBER, btt_id_in IN INT) 
IS
BEGIN
  INSERT INTO bank_tx (ba_id, btt_id, tx_amount, tx_date) VALUES (ba_id_in, btt_id_in, tx_amount_in, CURRENT_TIMESTAMP);
  UPDATE bank_account SET ba_balance = get_balance_from_tx(ba_id_in) WHERE ba_id = ba_id_in;
END;
/