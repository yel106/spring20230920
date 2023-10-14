USE mydb1;

CREATE TABLE my_table42_a (
    col1 VARCHAR(1)
);

CREATE TABLE my_table43_b (
    col1 VARCHAR(1)
);

INSERT INTO my_table42_a (col1)
VALUES ('a'),
       ('b'),
       ('c');

INSERT INTO my_table43_b (col1)
VALUES ('b'),
       ('c'),
       ('d'),
       ('e');

SELECT *
FROM my_table42_a a JOIN my_table43_b b
    ON a.col1 = b.col1; /* a테이블에도 있고 b테이블에도 있는 것만 검색. INNER JOIN: 교집합*/

SELECT *
FROM my_table42_a a INNER JOIN my_table43_b b /*그냥 JOIN이라고 쓰면 INNER JOIN임. LEFT JOIN은 LEFT를 꼭 씀*/
    ON a.col1 = b.col1;


SELECT *
FROM my_table42_a a JOIN my_table43_b b;

SELECT *
FROM my_table42_a a LEFT JOIN my_table43_b b /* 교집합 + 왼쪽테이블인 a에만 있는게 나옴 */
 ON a.col1 = b.col1;

SELECT *
FROM my_table42_a a LEFT OUTER JOIN my_table43_b b /* fullname이 LEFT OUTER JOIN임 */
ON a.col1 = b.col1;

SELECT *
FROM my_table42_a a RIGHT JOIN my_table43_b b
ON a.col1 = b.col1;             /*b,c를 지우면 d,e만 남음, 겹치는거랑 b테이블만 갖고 있는것. 왼쪽 테이블은 없으니까 null로 나옴*/


CREATE TABLE my_table44_a (
    col1 VARCHAR(1),
    name VARCHAR(10),
    address VARCHAR(10)
);

CREATE TABLE my_table45_b (
    col1 VARCHAR(1), -- col1이 위의 테이블과 겹침
    product VARCHAR(10),
    country VARCHAR(10)
);

INSERT INTO my_table44_a (col1, name, address)
VALUES ('a', '흥민', '런던'),
       ('b', '강인', '파리'),
       ('c', '민재', '뮌헨');

INSERT INTO my_table45_b (col1, product, country)
VALUES ('b', '축구공', '한국'),
       ('c', '컴퓨터','미국'),
       ('d', '전화기', '호주'),
       ('e', '햄버거', '영국');

SELECT *
FROM my_table44_a a JOIN my_table45_b b;

SELECT *
FROM my_table44_a a JOIN my_table45_b b
    ON a.col1 = b.col1; -- name, address, product, country처럼 안겹치는건 사라짐


    -- NATURAL JOIN은 완전히 똑같은 열이 ex) supplierID가 똒같이 29개가 있어야함

SELECT *
FROM my_table44_a a LEFT JOIN my_table45_b b
      ON a.col1 = b.col1; -- a만 갖고있는게 추가됨, b는 없으니까 null값 나옴

SELECT *
FROM my_table44_a a RIGHT JOIN my_table45_b b
ON a.col1 = b.col1; -- 교집합 + 오른쪽 테이블인 b가 가지고 있는 d,e가 추가돼서 나옴

