SELECT c.name AS Customers 
from Customers c LEFT JOIN Orders o ON c.id = o.customerId 
where o.customerId IS NULL;