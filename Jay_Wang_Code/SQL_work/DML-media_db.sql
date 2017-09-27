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
