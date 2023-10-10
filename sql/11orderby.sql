SELECT * FROM employees;
SELECT *
FROM employees
ORDER BY BirthDate;

SELECT *
FROM employees
ORDER BY 4; -- 전체 중 4번째 컬럼인 birthDate 기준으로 정렬한다고 쓸수도 있음

SELECT EmployeeID, LastName, BirthDate
FROM employees
ORDER BY 2; -- SELECT문에서 조회되는 컬럼 중 2번째인 LastName의 오름차순으로 정렬됨

SELECT * FROM products;
SELECT * FROM products
ORDER BY CategoryID;

SELECT * FROM products
ORDER BY CategoryID , Price; -- Category 안에서 또 price별로 정렬됨( DESC나 ASC 생략된 경우 오름차순 정렬)

SELECT * FROM products
ORDER BY 4 , 6; -- 이렇게 써도 위와 결과는 같음

SELECT * FROM products
ORDER BY CategoryID ASC; -- 오름차순(생략 가능)
SELECT * FROM products
ORDER BY CategoryID DESC; -- 내림차순 정렬

SELECT * FROM products
ORDER BY CategoryID DESC, Price;

SELECT * FROM products
ORDER BY CategoryID DESC, Price DESC;

-- 예) 고객을 국가명 오름차순으로 조회
SELECT *
FROM customers
ORDER BY Country ASC;

-- 예) 가격이 비싼 상품이 먼저 오도록 조회되도록 코드 작성
SELECT *
FROM products
ORDER BY Price DESC;

-- 가장 어린 직원이 먼저 조회되도록 코드 작성
SELECT *
FROM employees
ORDER BY BirthDate DESC;

SELECT * FROM products
WHERE CategoryID = 1
ORDER BY Price DESC;