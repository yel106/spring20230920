SELECT * FROM employees;
SELECT EmployeeID, LastName FROM employees;

-- AS: 컬럼명(테이블명) 변경. 별칭사용
SELECT EmployeeID AS id,
       LastName AS name
FROM employees;

SELECT EmployeeID,
       CONCAT(FirstName, ' ', LastName) AS fullName
FROM employees;


-- AS 생략가능
SELECT EmployeeID,
       CONCAT(FirstName, ' ', LastName) fullName
FROM employees;

-- AS생략할때 띄어쓰기 하고싶은경우 backtick ``으로 키워드나 특수문자(띄어쓰기 등) 사용 가능
SELECT EmployeeID,
       CONCAT(FirstName, ' ', LastName) 'full Name'
FROM employees;

-- 예) 공급자의 이름(supplierName), 주소(address, city, country)
--     전화번호(phone -> phone number) 조회
-- supplierName, address, 'phone number'
SELECT SupplierName,
       CONCAT( Address, ' ', City, ' ', Country) AS address,
       Phone AS 'phone number'
FROM suppliers;

-- JOIN으로 결합
SELECT  * FROM products;
SELECT * FROM categories;

SELECT * FROM products JOIN categories
    ON products.CategoryID = categories.CategoryID;

SELECT products.ProductName,
       categories.CategoryName
FROM products JOIN categories
    ON products.CategoryID = categories.CategoryID;


-- table명도 별칭을 줘서 간결하게 쓸 수 있음
SELECT p.ProductName,
       c.CategoryName
FROM products AS p JOIN categories AS c  -- AS 생략가능
    ON p.CategoryID = c.CategoryID;

