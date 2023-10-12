-- DELETE FORM  tableName WHERE 조건
-- !! WHERE절 꼭 작성!! 안하면 테이블 전체가 삭제됨

SELECT * FROM employees WHERE LastName = '손';

DELETE FROM employees WHERE LastName = '손';

-- 지우기 전 같은 where 절로 지울 레코드인지 확인!!
SELECT * FROM employees WHERE FirstName = '차';
DELETE FROM employees WHERE FirstName = '차';

SELECT * FROM employees;
DELETE FROM employees; -- 다 지우는건 위험해서 막아둠. 설정을 바꿔야함

-- 예) 직원 테이블에 오늘 입력한 레코드들 지우기
SELECT * FROM employees WHERE LastName= '이';
DELETE FROM employees WHERE LastName= '이';
-- 예) 상품테이블테이블에 오늘 입력한 레코드들 지우기
SELECT * FROM products WHERE ProductName= '김치';
DELETE FROM products WHERE ProductName= '김치';
SELECT * FROM products;

SELECT * FROM products;