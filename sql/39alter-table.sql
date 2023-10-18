USE w3schools;
-- ATER TABLE : 테이블 수정

-- 컬럼 추가, 변경, 삭제(삭제는 잘 안함)

-- 제약 사항 변경
-- NOT NULL, UNIQUE, PRIMARY KEY, DEFAULT, FOREIGH KEY


-- 컬럼 추가
ALTER TABLE products
ADD COLUMN col1 INT;
ALTER TABLE products
ADD COLUMN col2 VARCHAR(10);

DESC products;

-- 컬럼을 중간에 ProductName 뒤에 추가하고 싶다면? 주의 해야함. 컬럼순서가 어그러질수 있음
ALTER TABLE products
ADD COLUMN col3 VARCHAR(10) AFTER ProductName;

-- 컬럼 추가 시 맨 앞에 오도록 함
ALTER TABLE products
ADD COLUMN col4 VARCHAR(10) FIRST ;

-- 여러제약 사항을 줄 수 있음
ALTER TABLE products
ADD COLUMN col5 INT
    NOT NULL DEFAULT 1 REFERENCES employees(EmployeeID);

DESC products;


-- 예) 직원 테이블에 salary 컬럼 마지막에 추가
-- data type은 dec(10, 2), null 허용 안하고, default는 0.00
ALTER TABLE employees
ADD COLUMN salary dec(10, 2) NOT NULL DEFAULT 0.00;

DESC employees;



-- 컬럼 삭제
ALTER TABLE products
DROP COLUMN col1;

-- 예) products 테이블에서 col2 컬럼 삭제
ALTER TABLE products
DROP COLUMN col2;

DESC products;

-- 컬럼 변경 (type)
ALTER TABLE products
MODIFY COLUMN col3 INT; -- 원래 col3은 varchar(10)이였는데 INT로 변경

-- 컬럼 변경 시 이미 값이 있다면 타입을 바꿀 시도를 하면 안됨
INSERT INTO products (col4)
VALUE ('pizza');
ALTER TABLE products
MODIFY COLUMN col4 INT; -- col4에 문자열인 pizza가 저장되어 있어서 INT로 안 바뀜

ALTER TABLE products
MODIFY COLUMN col4 VARCHAR(10); -- 기존보다 글자수를 늘리는건 괜찮지만 밑에처럼 3으로 줄이는건 위험

ALTER TABLE products
    MODIFY COLUMN col4 VARCHAR(3);

SELECT * FROM products ORDER BY ProductID DESC ;
DESC products;




