(SELECT u.name AS results
 FROM MovieRating mr
 JOIN Users u ON mr.user_id = u.user_id
 GROUP BY u.name
 ORDER BY COUNT(mr.movie_id) DESC, u.name
 LIMIT 1)

UNION ALL

(SELECT m.title AS results
 FROM MovieRating mr
 JOIN Movies m ON mr.movie_id = m.movie_id
 WHERE mr.created_at BETWEEN '2020-02-01' AND '2020-02-29'
 GROUP BY m.title
 ORDER BY AVG(mr.rating) DESC, m.title
 LIMIT 1);



-- (SELECT name AS results
-- FROM MovieRating JOIN Users USING(user_id)
-- GROUP BY name
-- ORDER BY COUNT(*) DESC, name
-- LIMIT 1)

-- UNION ALL

-- (SELECT title AS results
-- FROM MovieRating JOIN Movies USING(movie_id)
-- WHERE EXTRACT(YEAR_MONTH FROM created_at) = 202002
-- GROUP BY title
-- ORDER BY AVG(rating) DESC, title
-- LIMIT 1);