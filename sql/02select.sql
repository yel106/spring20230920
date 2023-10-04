-- SELECT : 데이터 조회( 읽기, 검색, 가져오기)
SELECT * FROM w3schools.customers;
SELECT * FROM w3schools.employees;
SELECT * FROM w3schools.products;

-- 오른쪽 상단에 스키마인 w3schools를 선택해두면 스키마를 쓰지 않고 바로 테이블명을 쓸 수 있음
-- 테이블 형태로 데이터가 저장되어 있음
SELECT * FROM customers;
SELECT * FROM categories;
SELECT * FROM  employees;
SELECT * FROM orderdetails;
SELECT * FROM  products;
SELECT * FROM  shippers;
SELECT * FROM suppliers;

-- 행이나 어트리뷰트만 따로 뜯어서 보고 싶다면?
SELECT CustomerName  -- 테이블이 가지고 있는 column(attribute)명 나열
FROM customers; -- table명 나열

SELECT CustomerID, CustomerName
FROM customers;

SELECT CustomerID, CustomerName, Country
FROM customers;

-- 입력한 순서대로 결과가 나옴
SELECT CustomerName, CustomerID, Country
FROM customers;

SELECT * -- * : 전체 컬럼 조회
FROM customers;

-- 예1) 직원(employees)의 lastName, firstName, birthDate 조회
SELECT LastName, FirstName, BirthDate
FROM employees;

-- 예2) 상품(products)의 이름(productName), 단위(unit), 가격(price) 조회
SELECT ProductName, Unit, Price
FROM products;

-- 예3)공급자(suppliers)의 이름(supplierName), 주소(address), 국가(country) 조회
SELECT SupplierName, Address, Country
FROM suppliers;


-- 고객테이블의 국가 컬럼 조회: 91개의 row(record)가 조회됨
SELECT Country FROM customers;

-- distinct: 중복 제거 를 사용하면?
SELECT DISTINCT Country FROM customers; -- 중복된건 제외하고 21개 row만 조회됨

SELECT City, Country FROM customers; -- 91개
SELECT DISTINCT City, Country FROM customers; -- 69개

-- COUNT : 행(row, record)의 수
SELECT COUNT(Country) FROM customers; -- 91개
SELECT COUNT(DISTINCT Country) FROM customers; -- 21개

-- 전체 행의 수
SELECT COUNT(*) FROM customers;
SELECT COUNT(*) FROM employees;
SELECT COUNT(*) FROM orders;

-- 예) 공급자들이 있는 나라 수
SELECT DISTINCT COUNT(Country) FROM suppliers;

-- 예) 주문(Orders) 건수. 전체를 검색하려면 *을 써야함
SELECT COUNT(*) FROM orders;

-- 예) 몇 개의 카테고리가 있는지 조회
SELECT COUNT(*) FROM categories;

-- 예) 고객이 있는 도시의 수
SELECT DISTINCT COUNT(DISTINCT City) FROM customers;




