USE w3schools;
SELECT * FROM products;
SELECT * FROM categories;

-- chais 상품의 카테고리명은?
SELECT CategoryID FROM products
WHERE ProductName = 'chais';

SELECT CategoryName FROM categories
WHERE CategoryID =1;

-- JOIN :  두 개의 테이블 결합
-- 두 개의 테이블을 결합해서 한번에 조회하기
SELECT COUNT(*)
FROM categories JOIN products; -- JOIN말고 ,(콤마)찍어서 써도 됨

SELECT COUNT(*)
FROM categories JOIN products;

SELECT COUNT(*)
FROM categories; -- 8

SELECT COUNT(*)
FROM products; -- 77   8* 77해서 위에 총 616개가 나온것


-- 상품이 카테고리에 속해있는것
CREATE TABLE table_a (
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(20),
    category_id INT  -- 레퍼런스 생략
);
CREATE TABLE table_b (
    category_id INT PRIMARY KEY AUTO_INCREMENT,
    category_name VARCHAR(20)
);

INSERT INTO table_b (category_name)
VALUES ('음료수'), ('반찬');

INSERT INTO table_a (product_name, category_id)
VALUES ('콜라', 1),
       ('사이다', 1),
       ('제육', 2),
       ('돈까스', 2),
       ('두부', 2);

SELECT *
FROM table_a JOIN table_b;
-- 두 테이블 결합하면
-- 조회된 레코드 수는 A테이블 행(row) 5개 * B테이블 2개 결합해서 = 총 10개
-- 컬럼 갯수는 A테이블 열 3개 +  B테이블 열 2개 합쳐서 = 총 5개가 나옴

SELECT * FROM table_a;
SELECT * FROM table_b;
SELECT *
FROM table_a JOIN table_b
WHERE table_a.product_name = '콜라' -- product_name이라는 컬럼명이 하나의 테이블에만 있기 때문에 테이블명 생략 가능했음.
    AND table_a.category_id= table_b.category_id; -- 컬럼명이 두개의 테이블에 중복되어 있을땐 앞에 테이블명 써줘야함. 이미 프로덕트인 콜라가 카테고리 1에 있다고 정했기 때문에 2라고 쓰는건 안됨
                                -- 카테고리 아이디가 1로 겹치는 것을 골라내야 함
SELECT *
FROM table_a JOIN table_b
    ON table_a.category_id = table_b.category_id -- join 조건
    WHERE product_name = '콜라';

SELECT ProductID, ProductName, CategoryName
FROM products AS p JOIN categories AS c -- AS 생략가능
    ON p.CategoryID = c.CategoryID
WHERE ProductName = 'chais';


-- 예) chais 상품의 공급자명, 전화번호
SELECT SupplierName, Phone
FROM suppliers s JOIN products p
    ON s.SupplierID = p.SupplierID
WHERE ProductName = 'chais';

-- 예) 1996년 7월 4일에 주문한 고객명 (customers, orders)
SELECT CustomerName
FROM customers c JOIN orders o
    ON c.CustomerID = o.CustomerID
WHERE OrderDate= '1996-07-04';

-- 예) 1996년 7월 4일에 주문을 담당한 직원명 (employees, orders)
SELECT LastName
FROM employees e JOIN orders o
    ON e.EmployeeID = o.EmployeeID
WHERE OrderDate = '1996-07-04';

SELECT * FROM orders WHERE OrderDate = '1996-07-08';


SELECT COUNT(*) FROM products; -- 77개
SELECT COUNT(*) FROM suppliers; -- 29개
SELECT COUNT(*) FROM categories; -- 8개개

-- 공급자ID와 categoryID를 한번에 조회하고 싶다면?

-- 3개 테이블 조회
SELECT COUNT(*)
FROM products, suppliers, categories; -- 다 곱해서 17864개

-- 여러테이블 조인해서 조회
SELECT p.ProductName, s.SupplierID, s.Phone, c.CategoryName
FROM products p
    JOIN suppliers s
        ON p.SupplierID = s.SupplierID
    JOIN categories c
        ON p.CategoryID = c.CategoryID
WHERE p.ProductName = 'chais';

-- 예) 'Chang' 상품의 공급자명, 카테고리명 조회
SELECT s.SupplierName, c.CategoryName
FROM products p
    JOIN categories c
        ON p.CategoryID = c.CategoryID
    JOIN suppliers s
        ON p.SupplierID = s.SupplierID
WHERE p.ProductName = 'Chang';

-- 예) 1996년 7월 9일에 주문한 고객명과, 처리한 직원명
SELECT c.CustomerName, e.LastName, e.FirstName
FROM orders o
    JOIN customers c
        ON c.CustomerID = o.CustomerID
    JOIN employees e
        ON o.EmployeeID = e.EmployeeID
WHERE o.OrderDate = '1996-07-09';

-- 예) 1996년 7월 9일에 주문한 상품명( orders, oderDetails, products)
SELECT ProductName
FROM orders o
    JOIN orderdetails od
        ON o.OrderId = od.OrderID
    JOIN products p
        ON od.ProductID = p.ProductID
WHERE OrderDate = '1996-07-09';

-- 예) 'Chang' 상품이 주문된 날짜들
SELECT  p.ProductName, o.OrderDate, c.CustomerName, CONCAT(e.FirstName, ' ', e.LastName) FullName
FROM products p
    JOIN orderdetails od
        ON p.ProductID = od.ProductID
    JOIN orders o
        ON od.OrderID = o.OrderID
    JOIN customers c
        ON o.CustomerID = c.CustomerID
    JOIN employees e
        ON o.EmployeeID = c.CustomerID
WHERE ProductName = 'Chang';










