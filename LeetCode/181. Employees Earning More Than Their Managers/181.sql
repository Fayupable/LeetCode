--# Write your MySQL query statement below
Select e.name As Employee
From Employee e
Join Employee m On e.managerId=m.id
Where e.salary > m.salary;

-- /* Write your PL/SQL query statement below */
SELECT e.name AS Employee
FROM Employee e
JOIN Employee m ON e.managerId = m.id
WHERE e.salary > m.salary;

--/* Write your T-SQL query statement below */
SELECT e.name AS Employee
FROM Employee e
JOIN Employee m ON e.managerId = m.id
WHERE e.salary > m.salary;