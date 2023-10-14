-- 비상관 쿼리 : 외부 쿼리의 컬럼이 내부 쿼리에 사용되지 않을 때

-- 상관 쿼리: 외부쿼리의 컬럼이 내부쿼리에 사용될 때
-- 각 공급자가 있는 나라의 고객 수는?
USE w3schools;
SELECT * FROM suppliers;

SELECT COUNT(*) FROM customers
WHERE Country = (SELECT country FROM suppliers WHERE SupplierID = 1); -- 이건 비상관 커리
SELECT COUNT(*) FROM customers
WHERE Country = (SELECT country FROM suppliers WHERE SupplierID = 2);
SELECT COUNT(*) FROM customers
WHERE Country = (SELECT country FROM suppliers WHERE SupplierID = 3);

-- 상관커리로 바꾸면 속도가 느려질 우려가 있음(성능 저하 가능성)
SELECT COUNT(*) FROM suppliers;
SELECT
    s.supplierID,
    (SELECT COUNT(*)
    FROM customers
    WHERE customers.Country = s.Country) AS 'Number Of customers'
FROM suppliers s; -- suppliers 의 컬럼을 각각 사용해야함. 외부쿼리 supplier의 레코드가 내부 쿼리 s.COuntry에 들어감

-- 예) 각 직원보다 나이가 많은 직원의 수(lastName, Number Of emp)
-- 별칭을 써서 구분하기

SELECT * FROM employees;
SELECT LastName,
       (SELECT COUNT(*) FROM employees e2
        WHERE e1.BirthDate > e2.BirthDate) AS 'Number Of emp'
FROM employees e1;





