SELECT
a.machine_id,
ROUND(
    (SELECT  AVG (a1.timestamp) FROM  activity a1 WHERE  a1.activity_type = 'end' AND a1.machine_id=a.machine_id)-
   (SELECT AVG(a1.timestamp)  FROM activity a1 WHERE  a1 .activity_type = 'start' AND a1.machine_id = a.machine_id),3 ) AS processing_time
FROM activity a
GROUP BY a.machine_id;