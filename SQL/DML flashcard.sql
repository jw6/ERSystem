--DML

--Insert into Flash_card
INSERT INTO flash_card VALUES(1, 'what is your favorite color', 'java');
INSERT INTO flash_card VALUES(2, 'What is life?', '42');
INSERT INTO flash_card VALUES(3, 'Is this a question?', 'sure');

INSERT INTO flash_card VALUES(55, '55?', '55');
--Partial Insert
INSERT INTO flash_card(FC_QUESTION,FC_ANSWER) VALUES('does this trigger work?', 'hopefully');

SELECT * FROM FLASH_CARD;
