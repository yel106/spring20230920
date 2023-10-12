SELECT * FROM products;
SELECT * FROM products WHERE ProductID =1;

UPDATE products
SET ProductName = '차이즈',
    Unit = '10박스',
    Price = 36.00
WHERE ProductID = 1;

UPDATE products
SET ProductName = '두부김치'; -- WHERE절 꼭 쓸 것! WHERE절 안쓰면 바뀌지 않도록 안전하게 뜸

-- 예) 1번 고객의 이름 수정하기
SELECT * FROM customers;
UPDATE customers
SET CustomerName = '주예린'
WHERE CustomerID = 4;

-- 예) 5번 직원의 notes 변경하기
SELECT * FROM employees;
UPDATE employees
SET Notes = '드라마 보는 것을 좋아함'
WHERE EmployeeID = 5;

-- 1번 공급자의 전화번호, 주소 변경하기
SELECT * FROM suppliers;
UPDATE suppliers
SET Phone= '010-1234-5678', Address= '서울특별시 마포구'
WHERE SupplierID = 1;


--
SELECT * FROM products
        WHERE CategoryID = 1;

UPDATE products
SET Price = Price * 2
WHERE CategoryID = 1;

SELECT * FROM shippers;
SELECT * FROM employees;