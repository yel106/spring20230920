-- DATABASE, SCHEMA 같은 용어: 테이블들이 있는 공간

-- DATABASE 만들기
CREATE DATABASE mydb1; -- 동전모양 데이터베이스 누르면 추가된걸 확인 가능
CREATE SCHEMA mydb2;

SELECT * FROM mydb1.table_name;
SELECT * FROM w3schools.customers;
SELECT * FROM w3schools.products;

SELECT * FROM products;
-- database 옮기기
USE mydb1;
SELECT * FROM w3schools.products; -- 데이터 베이스가 mydb1로 옮겨졌기 때문에 w3schools를 써줘야함

-- database 지우기. 함부로 지우면 안됨
DROP DATABASE mydb2;
DROP DATABASE mydb1;
USE w3schools;


CREATE DATABASE mydb1;



