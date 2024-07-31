
delete p.*
from Person as P,
(
    select Email, min(Id) as minId from Person
    group by Email having count(*) > 1
)
as q
where p.Email = q.Email and Id > q.minId

WITH CTE AS (
    SELECT MIN(id) as min_id
    FROM Person
    GROUP BY email
)
DELETE FROM Person
WHERE id NOT IN (SELECT min_id FROM CTE);