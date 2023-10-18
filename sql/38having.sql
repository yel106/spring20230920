-- HAVING: 그룹함수 연산결과를 조건으로 줄 수 있는 키워드
USE w3schools;
-- HAVING
SELECT c.CustomerName, SUM(p.Price * od.Quantity) `총 주문금액`
FROM customers c JOIN orders o ON c.CustomerID = o.CustomerID
                JOIN orderdetails od ON o.OrderID = od.OrderID
                JOIN products p ON od.ProductID = p.ProductID
GROUP BY c.CustomerID
HAVING `총 주문금액` >= 100000
ORDER BY `총 주문금액` DESC;

-- 예) 총 처리 금액 10만 달러 미만인 직원 조회
-- orders, orderDetails, products, employees
SELECT e.LastName `직원 이름`, SUM(p.Price * od.Quantity) `총 처리 금액`
FROM orders o JOIN orderdetails od ON o.OrderID = od.OrderID
            JOIN employees e ON o.EmployeeID = e.EmployeeID
            JOIN products p ON p.ProductID = od.ProductID
GROUP BY e.EmployeeID
HAVING `총 처리 금액` < 100000
ORDER BY `총 처리 금액` DESC ;



