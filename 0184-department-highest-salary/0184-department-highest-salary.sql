SELECT Department, Employee, Salary FROM(
    SELECT d.name Department ,e.name AS Employee ,e.salary AS Salary, DENSE_RANK() OVER( PARTITION BY d.name ORDER BY e.salary DESC) rnk
    FROM Employee e INNER JOIN Department d ON e.departmentId = d.id
    ) t
WHERE rnk = 1;