SELECT 
    x, 
    y, 
    z,
    CASE 
        WHEN x + y > z AND x + z > y AND y + z > x THEN 'Yes'
        ELSE 'No'
    END AS triangle
FROM Triangle;


select *, if(x+y>z and y+z>x and z+x>y,'Yes','No') as triangle from triangle;
