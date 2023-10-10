SELECT price FROM products WHERE ProductID = 1;
SELECT price + 1 FROM products WHERE ProductID = 1;
SELECT price - 10.5 FROM products WHERE ProductID = 1;
SELECT price * 3 FROM products WHERE ProductID = 1;
SELECT price / 5 FROM products WHERE ProductID = 1;

SELECT ProductName, Price * 2 FROM products;

SELECT ProductName + 1, Price FROM products; /*문자열 연결연산은 안됨: ProductName은 수로 변환되지 않음*/
SELECT CONCAT(ProductName, 1), Price FROM products; -- 문자열 연결은 concat 사용.
-- mariaDB이기 때문에 사용할수 있는 내장함수임, 오라클과 같은 다른 회사의 데이터베이스를 쓰려면  다른회사의 내장함수명이나 제공되는 연산자를 써야함

-- 1968-12-08
SELECT LastName, BirthDate FROM employees WHERE EmployeeID = 1;
-- 19681209 날짜를 수 형식으로 바꿔서  연산함
SELECT LastName, BirthDate + 1 FROM employees WHERE EmployeeID = 1;

SELECT LastName, ADDDATE(BirthDate, INTERVAL 1 DAY )
FROM employees
WHERE EmployeeID = 1; -- 날짜변경 함수 사용

SELECT * FROM employees;
SELECT EmployeeID, LastName, FirstName FROM employees;
SELECT EmployeeID, CONCAT(FirstName, ' ', LastName) FROM employees;
SELECT EmployeeID,
       CONCAT(FirstName, ' ', LastName),
       ADDDATE(BirthDate, INTERVAL 1 YEAR )
FROM employees;

-- 예) 주문수량(quantity) *2 결과 조회( orderDetails 테이블)
SELECT OrderDetailID, OrderID, ProductID, Quantity, Quantity * 2 FROM orderdetails;

-- 예) "city, country" 고객테이블 조회
SELECT CustomerID,
       CustomerName,
       ContactName,
       CONCAT(City, ' ', Country)
FROM customers;