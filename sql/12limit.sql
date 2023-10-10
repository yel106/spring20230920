-- LIMIT 조회 레코드( 행, row) 제한 . oracle엔 LIMIT가 없음
SELECT * FROM customers;
SELECT * FROM customers
LIMIT 3;

SELECT * FROM employees
LIMIT 2;

-- 나이가 제일 많은 두 사람을 조회하기
SELECT * FROM employees
ORDER BY BirthDate
LIMIT 2;

-- 가격이 비싼 상품 10가지 조회
SELECT * FROM products
ORDER BY Price DESC
LIMIT 10;

-- 예) 가장 어린 3명의 직원 조회
SELECT * FROM employees
ORDER BY BirthDate DESC
LIMIT 3;
-- 에) 2번 카테고리에서 가장 저렴한 상품 조회
SELECT * FROM products
WHERE CategoryID = 2
ORDER BY Price ASC
LIMIT 1;

-- LIMIT n:    n개
-- LINIT n, m:    n번 부터 m개 ( n은 0번부터)
SELECT ProductName, Price
FROM products
ORDER BY Price
LIMIT 3;

SELECT ProductName, Price
FROM products
ORDER BY Price
LIMIT 0, 3;

SELECT ProductName, Price
FROM products
ORDER BY Price
LIMIT 1, 3;

SELECT ProductName, Price
FROM products
ORDER BY Price
LIMIT 3, 3; -- 3번부터 3개

-- 페이지 나누기
SELECT CustomerID, CustomerName FROM customers
ORDER BY CustomerID; -- 총 91개 row

SELECT CustomerID, CustomerName FROM customers
ORDER BY CustomerID
LIMIT 0, 10; -- 1페이지에 10개 나오도록

SELECT CustomerID, CustomerName FROM customers
ORDER BY CustomerID
LIMIT 10, 10; -- 2페이지에 10개 나오도록. 10번부터 10개나옴

SELECT CustomerID, CustomerName FROM customers
ORDER BY CustomerID
LIMIT 20, 10; -- 3페이지에 10개 나오도록

SELECT CustomerID, CustomerName FROM customers
ORDER BY CustomerID
LIMIT 90, 10; --  마지막 페이지에 10개 나오도록

-- 예) 공급자(suppliers)를 한 페이지에 5개씩 공급자번호 순으로 보여줄 때
-- 3번째 페이지 조회 코드 작성
SELECT * FROM suppliers
ORDER BY SupplierID
LIMIT 10, 5;

-- 한 페이지가 n개의 레코드(row)를 보여주면
-- m번째 페이지 조회
-- LIMIT (m-1)*n, n