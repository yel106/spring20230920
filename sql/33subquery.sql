USE w3schools;

SELECT Price FROM products WHERE ProductName = 'ipoh coffee';
SELECT ProductName, Price FROM products
WHERE Price > 46.00;

SELECT ProductName, Price FROM products
WHERE Price > (SELECT Price FROM products WHERE ProductName = 'ipoh coffee'); -- subquery : 쿼리가 다른 쿼리 안에 포함되는 것. 감싸진 쿼리 라고 하기도 함



SELECT BirthDate FROM employees
WHERE LastName = 'leverling';

SELECT LastName, FirstName, BirthDate FROM employees
WHERE BirthDate < '1963-08-30';

SELECT LastName, FirstName, BirthDate FROM employees
WHERE BirthDate < (SELECT BirthDate FROM employees
                   WHERE LastName = 'leverling'); -- 1963-08-30대신 서브쿼리 넣어도 같은 결과가 나옴

-- subquery
-- 행 1개, 열 1개
SELECT BirthDate FROM employees
WHERE LastName = 'leverling';

-- 행 여러개, 열(컬럼) 1개
SELECT ShipperID FROM orders WHERE OrderDate= '1996-07-08';
SELECT CustomerName FROM customers WHERE Country= 'mexico';

-- 행 여러개, 열 여러개
SELECT CustomerID, CustomerName FROM customers WHERE Country= 'mexico';


-- 행 1개 열 1개 예제
-- 'Tofu' 상품을 공급하는 공급자명 조회
SELECT SupplierID FROM products WHERE ProductName = 'tofu';

SELECT SupplierID, SupplierName FROM suppliers
WHERE  SupplierID = (SELECT SupplierID FROM products WHERE ProductName = 'tofu');

SELECT *
FROM suppliers s JOIN products p
        ON s.SupplierID = p.SupplierID
WHERE  p.ProductName= 'tofu'; -- join으로 해도 결과 같게 나옴

-- 여러행 1개열
-- 멕시코 고객이 주문한 일자들 조회
SELECT CustomerID FROM customers WHERE Country = 'mexico';
SELECT * FROM orders WHERE CustomerID IN(2, 3, 13, 58, 80);
SELECT OrderDate FROM orders WHERE CustomerID IN (SELECT CustomerID FROM customers WHERE Country = 'mexico');


-- 예) 1번 카테고리에 있는 상품이 주문된 주문번호 (orderDetails, products)
SELECT * FROM products WHERE CategoryID=1;

SELECT OrderID FROM orderdetails
WHERE ProductID IN (SELECT ProductID FROM products WHERE CategoryID=1);

-- 예) 1번 카테고리에 있는 상품이 주문된 날짜 (orderdetails, products)

SELECT OrderDate FROM  orders
WHERE OrderID IN (SELECT OrderID FROM orderdetails
                  WHERE ProductID IN (SELECT ProductID FROM products WHERE CategoryID=1));

SELECT DISTINCT  o.OrderID, o.OrderDate
FROM orders o JOIN orderdetails od ON o.OrderID = od.OrderID
    JOIN products p
        ON od.ProductID = p.ProductID
WHERE p.CategoryID = 1;

SELECT * FROM orderdetails;



-- 예) 주문한 적 없는 고객들 조회.
SELECT CustomerID FROM orders; -- 여러행 , 1개열

SELECT * FROM customers WHERE CustomerID NOT IN (SELECT CustomerID FROM orders); -- NOT IN() : ()데이터가 없는


-- 행 여러개, 열 여러개
SELECT * FROM customers;

SELECT SupplierName, Address, Country FROM suppliers;

INSERT INTO customers (CustomerName, Address, Country )
(SELECT SupplierName, Address, Country FROM suppliers); -- 위랑 결과가 같음
-- 갯수와 타입만 맞으면 되고, customerName/ supplierName 달라도 상관없음
-- 열의 갯수와 열의 타입만 맞으면 됨

INSERT INTO customers (CustomerName, Address, Country)
(SELECT  ContactName, city, phone FROM suppliers); -- 밑에 4개쓰면 갯수 안맞아서 안됨

SELECT * FROM customers
WHERE (City, Country)
        IN( SELECT City, Country FROM suppliers);

CREATE TABLE table_c
SELECT CustomerName, City, Country FROM customers; -- 원래있는 정보로 table c를 만듦

SELECT * FROM table_c;
DESC table_c;

-- 예) 1번 카테고리에 있는 상품들로 새 테이블을 만드는데
-- 새로운 테이블은 productName, categoryName, price
-- join 써야함

CREATE TABLE table_d
SELECT p.ProductName, c.CategoryName, p.Price FROM products p
    JOIN categories c
ON p.CategoryID = c.CategoryID
WHERE c.CategoryID= 1;

SELECT * FROM table_d;


