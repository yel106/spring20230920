-- gruop by:그룹함수 사용시 그룹함수의 범위(그룹) 지정

SELECT COUNT(DISTINCT CategoryID) FROM products;
SELECT MAX(Price) FROM products;
SELECT CategoryID, MAX(Price) FROM products
GROUP BY CategoryID; -- 같은 카테고리별로 MAX를 구하겠다. 집계함수+groupby와 같이쓰면 categoryID는 우리가 원하는 값이 나옴

 SELECT CategoryID, MAX(Price), MIN(Price)
 FROM products
 GROUP BY CategoryID;

SELECT CategoryID, MAX(Price) maxPrice, MIN(Price) minPrice
FROM products
GROUP BY CategoryID
ORDER BY maxPrice DESC ;

SELECT o.OrderDate, SUM(p.Price * od.Quantity) AS 매출액
FROM products p JOIN orderdetails od
    ON p.CategoryID = od.ProductID
JOIN orders o ON od.OrderID = o.OrderID
GROUP BY o.OrderDate
ORDER BY o.OrderDate;


-- 예) 직원별 주문 처리 금액 조회
-- 직원명, 직원별 주문 처리액
SELECT e.LastName, e.FirstName, SUM(p.Price * od.Quantity) AS `주문 처리 금액`
FROM employees e
JOIN orders o
    ON e.EmployeeID = o.EmployeeID
JOIN orderdetails od
    ON o.OrderID = od.OrderID
JOIN products p
    ON p.ProductID = od.ProductID
WHERE o.OrderDate >='1996-08-01' AND o.OrderDate <= '1996-09-01' -- 날짜별로 하고싶은경우
GROUP BY e.EmployeeID
ORDER BY `주문 처리 금액` DESC ;
-- 예) 고객별 총 주문 금액 조회
-- 고객명, 고객별 주문 금액
SELECT c.CustomerName 고객명, SUM(p.Price * od.Quantity) AS `고객별 주문 금액`
FROM orderdetails od
JOIN products p
    ON p.ProductID = od.ProductID
JOIN orders o
    ON o.OrderID = od.OrderID
JOIN customers c
    ON c.CustomerID = o.CustomerID
GROUP BY c.CustomerID
ORDER BY 2 desc ;

-- 선생님이 하신것
SELECT c.CustomerName, SUM(p.Price * od.Quantity) `총 주문금액`
FROM customers c JOIN orders o ON c.CustomerID = o.CustomerID
                 JOIN orderdetails od ON o.OrderID = od.OrderID
                 JOIN products p ON od.ProductID = p.ProductID
GROUP BY c.CustomerID
ORDER BY 2 desc;



-- 10만 달러 이상 소비한 고객 조회
SELECT * FROM
    (SELECT c.CustomerName, SUM(p.Price * od.Quantity) `총 주문금액`
     FROM customers c JOIN orders o ON c.CustomerID = o.CustomerID
                      JOIN orderdetails od ON o.OrderID = od.OrderID
                      JOIN products p ON od.ProductID = p.ProductID
     GROUP BY c.CustomerID) t1
WHERE t1.`총 주문금액` >= 100000;


SELECT * FROM
(SELECT c.CustomerName, SUM(p.Price * od.Quantity) AS '고객별 주문 금액'
FROM orderdetails od
         JOIN products p
              ON p.ProductID = od.ProductID
         JOIN orders o
              ON o.OrderID = od.OrderID
         JOIN customers c
              ON c.CustomerID = o.CustomerID
GROUP BY c.CustomerID) t1
WHERE t1.`고객별 주문 금액` >= 100000;
