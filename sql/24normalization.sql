USE mydb1;

-- normalization: 정규화

-- atomic data( 원자적 데이터) 책 209쪽. 끊어서 세분화해서 넣음.
-- 예) 이름, 최종학력, 특기
-- 원자적 데이터로 구성된 열은 그 열에 같은 타입의 데이터를 여러 개 가질 수 없다.
CREATE TABLE my_table21_person (
    name VARCHAR(100) NOT NULL,
    schools VARCHAR(100) ,
    skill VARCHAR(1000)
);

INSERT INTO my_table21_person (name, schools, skill)
VALUE ('손흥민', '대학', '축구, 노래');

INSERT INTO my_table21_person (name, schools, skill)
    VALUE ('이강인', '대학원', '야구, 농구');

INSERT INTO my_table21_person (name, schools, skill)
    VALUE ('김민재', '대학원', '배구');

SELECT * FROM my_table21_person;

-- 책 209쪽 규칙2.
-- 원자적 데이터로 구성된 테이블은 같은 타입의 데이터를 여러 열에 가질 수 없음
CREATE TABLE my_table22_person (
    name VARCHAR(20) NOT NULL ,
    schools VARCHAR(100),
    skill1 VARCHAR(100),
    skill2 VARCHAR(100),
    skill3 VARCHAR(100)
);

INSERT INTO my_table22_person(name, schools, skill1, skill2, skill3)
VALUE ('흥민', '대학교', '축구', '노래', null);

INSERT INTO my_table22_person(name, schools, skill1, skill2, skill3)
    VALUE ('강인', '대학원', '야구', '농구', null);

INSERT INTO my_table22_person(name, schools, skill1, skill2, skill3)
    VALUE ('민재', '대학원', '배구', null , null);

SELECT * FROM my_table22_person;


CREATE TABLE my_table23_person (
    name VARCHAR(100) NOT NULL,
    schools VARCHAR(100) ,
    skill VARCHAR(1000)
);

INSERT INTO my_table23_person (name, schools, skill)
VALUE ('흥민', '대학', '축구');

INSERT INTO my_table23_person (name, schools, skill)
    VALUE ('흥민', '대학', '노래');

INSERT INTO my_table23_person (name, schools, skill)
    VALUE ('강인', '대학', '농구');

SELECT * FROM my_table23_person; -- 하나의 컬럼에 하나의 값을 넣음. 원자적이긴 하지만 아직부족. 규칙이 더 남아있음


-- 책 215 페이지. 규칙3.
-- 각 행의 데이터들은 원자적 값을 가져야한다. 각 행은 유일무이한 식별자인 기본키(primary key)를 가지고 있어야 한다.
-- 위의 테이블에는 name에 흥민이 2명이기 때문에 name으로만 식별할 수 없음
-- KEY : 각 행을 구분하는 컬럼(들)
CREATE TABLE my_table24_person (
    ssn VARCHAR(10) NOT NULL UNIQUE ,
    name VARCHAR(10) NOT NULL ,
    school VARCHAR(10),
    skill VARCHAR(10)
);

-- p.216~
-- 기본 키(primary key) 조건
-- 1. NOT NULL UNIQUE 기본키는 널이 될수 없음
-- 2. 기본키는 레코드가 삽입될 때 값이 있어야 함
-- 3. 기본키는 간결해야함. 유일무이한 정보를 가지고 있어야함
-- 4. 기본키의 값은 변경 불가함

CREATE TABLE my_table25_person (
  id INT NOT NULL UNIQUE AUTO_INCREMENT, -- AUTO_INCREMENT: 기본키는 값이 있어야하니까 1부터 자동으로 증가된 값 삽입
  ssn VARCHAR(10) NOT NULL ,
  name VARCHAR(10) NOT NULL ,
  school VARCHAR(10),
  skill VARCHAR(10)
);

INSERT INTO my_table25_person( ssn, name, school, skill)
VALUE ('080101', '흥민', '대학', '축구');

INSERT INTO my_table25_person( ssn, name, school, skill)
    VALUE ('080101', '흥민', '대학', '노래');

INSERT INTO my_table25_person( ssn, name, school, skill)
    VALUE ('090101', '강인', '대학', '농구');

INSERT INTO my_table25_person( ssn, name, school, skill)
    VALUE ('090101', '흥민', '대학', '농구');

SELECT * FROM my_table25_person;

CREATE TABLE my_table26_person (
    id INT NOT NULL UNIQUE AUTO_INCREMENT, -- PRIMAARY KEY: NOT NULL UNIQUE
    ssn VARCHAR(10) NOT NULL ,
    name VARCHAR(10) NOT NULL ,
    school VARCHAR(10),
    skill VARCHAR(10)
);

DESC my_table25_person;
DESC my_table26_person;
