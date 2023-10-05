SELECT * FROM customers;
SELECT CustomerName, Country FROM customers WHERE Country = 'Germany';
SELECT CustomerName, Country FROM customers WHERE NOT Country = 'Germany';

-- 1번 카테고리에 속하지 않는 상품들 조회
SELECT ProductName FROM products WHERE NOT CategoryID= 1;
-- Japan에 있지 않는 공급자들 조회
SELECT SupplierName FROM suppliers WHERE NOT Country= 'Japan';

