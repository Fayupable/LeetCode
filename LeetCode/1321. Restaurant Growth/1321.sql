WITH daily_totals AS (
    SELECT visited_on, SUM(amount) AS daily_amount
    FROM customer
    GROUP BY visited_on
)

SELECT 
    c1.visited_on,
    SUM(c2.daily_amount) AS amount,
    ROUND(SUM(c2.daily_amount) / 7, 2) AS average_amount
FROM 
    daily_totals c1
JOIN 
    daily_totals c2 ON c2.visited_on BETWEEN DATE_SUB(c1.visited_on, INTERVAL 6 DAY) AND c1.visited_on
WHERE 
    c1.visited_on >= DATE_ADD((SELECT MIN(visited_on) FROM customer), INTERVAL 6 DAY)
GROUP BY 
    c1.visited_on
ORDER BY 
    c1.visited_on;

-- other solution
-- SELECT
--     visited_on,
--     (
--         SELECT SUM(amount)
--         FROM customer
--         WHERE visited_on BETWEEN DATE_SUB(c.visited_on, INTERVAL 6 DAY) AND c.visited_on
--     ) AS amount,
--     ROUND(
--         (
--             SELECT SUM(amount) / 7
--             FROM customer
--             WHERE visited_on BETWEEN DATE_SUB(c.visited_on, INTERVAL 6 DAY) AND c.visited_on
--         ),
--         2
--     ) AS average_amount
-- FROM customer c
-- WHERE visited_on >= (
--         SELECT DATE_ADD(MIN(visited_on), INTERVAL 6 DAY)
--         FROM customer
--     )
-- GROUP BY visited_on;