--JOIN
--I want to see the actor and the role_id
SELECT a.actor_name, a.act_film, ar.role_id
FROM actor a
INNER JOIN actor_role ar
ON ar.ACT_ID = a.ACT_ID;
--but I want to see what the role_id represents
SELECT a.actor_name, a.act_film, ar.role_id
FROM actor a
INNER JOIN actor_role ar ON ar.ACT_ID = a.ACT_ID;
INNER JOIN role_type rt  ON ar.ROLE_ID = rt.ROLE_ID;
--now I want to see all the actors, regardless if they have roles
SELECT a.actor_name, a.act_film, ar.role_id
FROM actor a
LEFT JOIN actor_role ar ON ar.ACT_ID = a.ACT_ID;
LEFT JOIN role_type rt  ON ar.ROLE_ID = rt.ROLE_ID;

--instead of all actors, I want all role types
SELECT a.act_name, a.act_film, ar.role_id, rt.role_type
FROM actor a
RIGHT JOIN actor_role ar ON ar.ACT_ID = a.ACT_ID;
RIGHT JOIN role_type rt  ON ar.ROLE_ID = rt.ROLE_ID;

--Show where actors have the same years in media
SELECT act_name as "Actor Name", act_years_in_media as "Years"
FROM actor;


--Functions
--2 types of system defined functions;
    -- Scalar
    -- Aggregate
--ave
--max
--min
--sum count 
    
SELECT * FROM actor;

--Jerry is repeated several, sum all Jerrys years in media
SELECT act_name SUM(ACT_YEARS_IN_MEDIA)
FROM ACTOR
GROUP BY act_name; --GROUP BY with aggregate functions
HAVING SUM(ACT_YEARS_IN_MEDIA) > 20;
--Now, all jerry and years_in_media > 20
--HAVING vs WHERE clause;
--because the WHERE keyword could not be used with aggregate funtions

--SQL scalar functions return a gingle value, based on the input value.
SELECT UPPER(act_name) FROM ACTOR;
SELECT UPPER(act_name), ROUND(ACT_YEARS_IN_MEDIA) FROM ACTOR;
SELECT UPPER(act_name_, LENGTH(act_name_), ROUND(ACT_YEARS_IN_MEDIA) FROM ACTOR;