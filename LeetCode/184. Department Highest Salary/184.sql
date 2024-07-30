select  Department,  Employee, salary
from
(select d.name as Department, e.name as Employee, e.salary,
dense_rank()over(partition by d.id order by e.salary desc) as rnk
from Employee as e
left outer join Department as d
on e.departmentid = d.id) as t
where t.rnk = 1