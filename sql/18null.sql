SELECT * FROM customers ORDER BY 1 DESC ;
INSERT INTO customers (CustomerName)
VALUE ('흥민');

INSERT INTO customers (CustomerName, ContactName)
VALUE ('강인', '');

INSERT INTO customers(CustomerName, ContactName)
VALUE ('민재', null);

SELECT ProductID, ProductName, price FROM products ORDER BY 1 DESC ;
INSERT INTO products(ProductName, Price)
VALUE ('햄버거', null);

-- NULL: 값이 없음. null인 상태가 조회 안됨
SELECT * FROM products
WHERE Price = 0.00
ORDER BY 1 DESC ;

SELECT * FROM products
WHERE Price !=0.00
ORDER BY 1 DESC ; -- 0이 아닌 값에서도 null값인 햄버거는 나오지 않음

-- 비교연산 시 피연산자가 NULL이면 결과는 항상 false
SELECT * FROM products
WHERE Price IS NULL; -- IS NULL 컬럼의 값이 null인지 확인

SELECT * FROM products
WHERE Price IS NOT NULL;

SELECT * FROM products
WHERE NOT Price IS NULL;

SELECT ProductName, Price * 100
FROM products; -- 산술연산시 null 피연산자이면 결과 null

SELECT ProductName, Price
FROM products
ORDER BY ProductID DESC ;

SELECT ProductName, IFNULL(Price, 0.00) -- 만약 price가 null이면 0.00으로 대체
FROM products
ORDER BY ProductID DESC ;

SELECT * FROM customers ORDER BY 1 DESC ;

-- 예) contactName이 null인 고객들 조회
SELECT * FROM customers
WHERE ContactName IS NULL ;

-- 예) address가 null인 고객들 조회
SELECT * FROM customers
WHERE Address IS NULL;

-- 예) 고객들 조회(customerName, county 컬럼만), 단 country가 null이면 '없음' 표시
SELECT CustomerName, IFNULL(country, '없음') AS country
FROM customers;



