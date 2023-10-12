USE mydb1;

-- 테이블 만들기
CREATE TABLE 테이블명 (
    컬럼명 컬럼타입,
    컬럼명 컬럼타입
);

-- 테이블명, 컬럼명 작성 관습
-- lower_snake_case > 우린 이걸 사용할 것
-- UPPER_SNAKE_CASE
-- UpperCamelCasel
-- lowerCamelCase

CREATE TABLE my_table1 (
    col_name1 varchar(100),
    col_name2 varchar(100),
    col_name3 varchar(100)
);

SELECT * FROM my_table1;
INSERT INTO my_table1 (col_name1, col_name2, col_name3)
VALUE ('민재', '흥민', '강인');

-- 예) my_table2 만들기, 컬럼은 4개, 모든 컬럼 타입 varchar(10)
CREATE TABLE my_table2 (
    food varchar(10),
    dessert varchar(10),
    price varchar(10),
    ex varchar(10)
);

SELECT  * FROM my_table2;
INSERT INTO my_table2
VALUE ('파스타', '바나나푸딩', 10, '맛있음');

-- 정수
-- 문자열
-- 실수
-- 날짜 (날짜시간)

