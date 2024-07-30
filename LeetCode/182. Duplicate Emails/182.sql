--# Write your MySQL query statement below
SELECT Email FROM PERSON GROUP BY EMAIL HAVING COUNT(*)>1;

SELECT email AS Email
FROM Person
GROUP BY email
HAVING COUNT(email) > 1;



/* Write your PL/SQL query statement below */
select distinct email from (select email, dense_rank() over(partition by email order by id) dr from person) r where r.dr >1