WITH base AS (
    SELECT requester_id AS id FROM RequestAccepted
    UNION ALL
    SELECT accepter_id AS id FROM RequestAccepted
),
friend_counts AS (
    SELECT id, COUNT(*) AS num_friends 
    FROM base 
    GROUP BY id
),
max_friends AS (
    SELECT MAX(num_friends) AS max_num_friends 
    FROM friend_counts
)
SELECT fc.id, fc.num_friends AS num
FROM friend_counts fc
JOIN max_friends mf ON fc.num_friends = mf.max_num_friends
ORDER BY fc.id;


-- another solution
-- with base as(select requester_id id from RequestAccepted
-- union all
-- select accepter_id id from RequestAccepted)
-- select id, count(*) num  from base group by 1 order by 2 desc limit 1
