/* Write your PL/SQL query statement below */
select e.name ,b.bonus from employee e left join bonus b
on e.empid = b.empid
where b.bonus not in (select b.bonus from bonus b where b.bonus >= '1000') or bonus is null;