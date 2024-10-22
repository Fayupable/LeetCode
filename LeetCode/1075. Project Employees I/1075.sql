select p.project_id, round(avg(e.experience_years),2) as average_years
from Project p
left join Employee e
on p.employee_id = e.employee_id
group by p.project_id

SELECT p.project_id, 
ROUND(SUM(e.experience_years)/COUNT(p.project_id),2) AS average_years
FROM Project p
LEFT JOIN Employee e ON p.employee_id=e.employee_id
GROUP BY p.project_id;