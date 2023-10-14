-- union 합집합
USE w3schools;
SELECT Country FROM customers;
SELECT Country FROM suppliers;

SELECT Country FROM customers
UNION
SELECT Country FROM suppliers;

SELECT Country FROM customers
UNION ALL
SELECT Country FROM suppliers;

SELECT CustomerName, Country, City, CustomerID FROM customers -- 열의 갯수만 맞으면 됨
UNION
SELECT SupplierName, Country, City, Address FROM suppliers;

-- 예) 직원의 lastName과 firstName을 name이라는 하나의 컬럼으로 조회

SELECT lastName Name FROM employees
UNION ALL
SELECT FirstName FROM employees;

-- FULL OUTER JOIN
USE mydb1;
SELECT *
FROM my_table44_a a LEFT JOIN my_table45_b b
ON a.col1 = b.col1
UNION
SELECT *
FROM my_table44_a a RIGHT JOIN my_table45_b b
ON a.col1 = b.col1;



-- LEFT OUTER JOIN
SELECT *
FROM my_table44_a a LEFT JOIN my_table45_b b
ON a.col1 = b.col1;

-- RIGHT OUTER JOIN
SELECT *
FROM my_table44_a a RIGHT JOIN my_table45_b b
ON a.col1 = b.col1;




