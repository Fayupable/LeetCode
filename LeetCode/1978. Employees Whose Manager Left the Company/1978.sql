SELECT 
    e.employee_id
FROM employees e
LEFT JOIN employees m ON e.manager_id IS NOT NULL and e.manager_id = m.employee_id
WHERE e.salary < 30000
  AND e.manager_id  IS NOT NULL
  AND m.employee_id IS NULL
ORDER BY e.employee_id ASC;