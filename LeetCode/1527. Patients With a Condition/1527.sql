-- Another person's solution
SELECT *
FROM Patients
WHERE LOCATE('DIAB1', conditions) = 1
   OR LOCATE(' DIAB1', conditions) != 0;