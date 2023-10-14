USE w3schools;

-- customers와 order에서 LEFT JOIN을 하면 주문 안한 고객만 뽑을 수 있음
SELECT DISTINCT CustomerID FROM orders
ORDER BY 1;

SELECT CustomerName
FROM customers
WHERE CustomerID NOT IN (SELECT DISTINCT CustomerID FROM orders ORDER BY 1 ); -- NOT IN() : ()에 없는 데이터

SELECT *
    FROM customers c JOIN orders o
    ON c.CustomerID = o.CustomerID; -- 주문한 적 있는 고객들


SELECT c.CustomerName
FROM customers c LEFT JOIN orders o
    ON c.CustomerID = o.CustomerID;


SELECT c.CustomerName
FROM customers c LEFT JOIN orders o
    ON c.CustomerID = o.CustomerID
WHERE o.CustomerID IS NULL; -- 주문한 적 없는 고객들. 오른쪽은 null값이 나옴

SELECT e.LastName, e.FirstName
FROM employees e LEFT JOIN orders o
    ON e.EmployeeID = o.EmployeeID
WHERE o.EmployeeID IS NULL; -- oreders에 있는 컬럼이 null인것 찾기

SELECT DISTINCT EmployeeID
FROM orders ORDER BY 1;
SELECT COUNT(*) FROM employees;

INSERT INTO employees(LastName, FirstName, BirthDate, Photo, Notes)
VALUE ('손', '흥민', '2000-01-01', '사진1', '축구선수');