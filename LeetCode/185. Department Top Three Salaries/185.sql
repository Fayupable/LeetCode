WITH RankedSalaries AS (
    SELECT
        e.id,
        e.name,
        e.salary,
        e.departmentId,
        DENSE_RANK() OVER (PARTITION BY e.departmentId ORDER BY e.salary DESC) AS salary_rank
    FROM Employee e
),
TopSalaries AS (
    SELECT
        rs.id,
        rs.name,
        rs.salary,
        rs.departmentId
    FROM RankedSalaries rs
    WHERE rs.salary_rank <= 3
)
SELECT
    d.name AS Department,
    ts.name AS Employee,
    ts.salary AS Salary
FROM TopSalaries ts
JOIN Department d ON ts.departmentId = d.id
ORDER BY Department, Salary DESC, Employee;



--# Write your MySQL query statement below

select Department,Employee,salary from (
select  d.name as Department , e.name as Employee,  salary,
dense_rank() over(partition by d.name order by salary desc) as rnk
from Employee e
left join
Department d
on e.departmentId = d.id
) as a
where rnk <=3