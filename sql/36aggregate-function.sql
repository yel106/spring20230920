USE w3schools;
-- aggregate function : 집계함수(= 집합함수, 그룹함수)
-- MAX, MIN, COUNT, SUM, AVG

SELECT * FROM products;

-- MAX 최대값
SELECT MAX(Price) FROM products;

SELECT * FROM products ORDER BY Price DESC ;
SELECT ProductName, MAX(Price) FROM products; -- 가격 최댓값을 가진 상품이름은 Côte de Blaye인데 다른게 나옴
-- 집계 함수에 넣었던 컬럼명 말고 productName처럼 다른것을 SELECT하면 값이 임의로 선택되어 나옴.

-- 서브쿼리 쓰면 원하는 결과 낼 수 있음
SELECT * FROM products
WHERE Price= (SELECT MAX(Price) FROM products);

-- MIN(최솟값)
SELECT MIN(Price) FROM products;
SELECT * FROM products
WHERE Price = (SELECT MIN(Price) FROM products);

-- 예제) 가장 어린 직원명  조회하기
SELECT LastName, FirstName FROM employees
WHERE BirthDate = (SELECT MAX(BirthDate) FROM employees);

-- 예) 가장 나이 많은 직원명 조회
SELECT LastName, FirstName FROM employees
WHERE BirthDate = (SELECT MIN(BirthDate) FROM employees);

SELECT LastName, FirstName FROM employees
ORDER BY BirthDate DESC ;

-- COUNT : 갯수
SELECT * FROM employees;
SELECT COUNT(EmployeeID) FROM employees;
SELECT COUNT(LastName) FROM employees;
SELECT COUNT(FirstName) FROM employees; -- 흥민 추가하니까 이것만 9개 나옴

-- NULL은 집계함수에서 포함하지 않음
INSERT INTO employees (Lastname)
VALUE ('흥민');
SELECT * FROM employees ORDER BY 1 DESC ;

SELECT MIN(BirthDate) FROM employees;
SELECT MAX(BirthDate) FROM employees;

INSERT INTO products (ProductName)
VALUE ('커피');

SELECT * FROM products ORDER BY 1 DESC ;
-- 저렴한 상품
SELECT MIN(Price) FROM products; -- null은 집계함수에 포함되지 않으니까 값을 추가해도 여전히 2.5가 최솟값으로 나옴
-- null이 들어간걸 0으로 하고싶다면? IFNULL이용 null이면 price를 0으로 해라
SELECT MIN(IFNULL(Price,0)) FROM products;

-- 뒤에 IFNULL이면 앞에도 IFNULL로 해야함
SELECT *FROM products
WHERE IFNULL(Price,0)= (SELECT MIN(IFNULL(Price,0)) FROM products);

-- SUM: 합
SELECT * FROM products;
SELECT SUM(Price) FROM products; -- 여기도 null은 포함 X


SELECT * FROM orderdetails;


SELECT SUM(od.Quantity)
FROM orders o JOIN orderdetails od
 ON o.OrderID = od.ProductID
WHERE o.OrderDate = '1996-07-04';

-- 예) 96년 7월 4일 매출액 구하기 (가격은 product table)
SELECT SUM(p.Price * od.Quantity)
FROM products p JOIN orderdetails od
ON p.ProductID = od.ProductID
JOIN orders o
ON o.OrderID = od.OrderID
WHERE o.OrderDate = '1996-07-04';

-- AVG : 평균
SELECT AVG(Price) FROM products; -- 원래는 222.71/77을 해야됨. 그런데 null값은 계산 안되기 떄문에 222.71/78을 하면  28.866364가 나옴
SELECT SUM(Price) FROM products; -- 상품의 총합: 222.71
SELECT COUNT(ProductID) FROM products; -- 전체 레코드의 갯수 78. 조회할때 pk인 COUNT(productID)로 조회해도 되고, COUNT(*)로 조회해도 됨
SELECT COUNT(Price) FROM products; -- 77개






